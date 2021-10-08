package com.wade.decompiler.classfile.element;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.classfile.attribute.AnnotationEntry;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public abstract class ElementValue {
    public static final byte STRING = 's';
    public static final byte ENUM_CONSTANT = 'e';
    public static final byte CLASS = 'c';
    public static final byte ANNOTATION = '@';
    public static final byte ARRAY = '[';
    public static final byte PRIMITIVE_INT = 'I';
    public static final byte PRIMITIVE_BYTE = 'B';
    public static final byte PRIMITIVE_CHAR = 'C';
    public static final byte PRIMITIVE_DOUBLE = 'D';
    public static final byte PRIMITIVE_FLOAT = 'F';
    public static final byte PRIMITIVE_LONG = 'J';
    public static final byte PRIMITIVE_SHORT = 'S';
    public static final byte PRIMITIVE_BOOLEAN = 'Z';
    protected int type;
    protected ConstantPool constantPool;

    protected ElementValue(int type, ConstantPool constantPool) {
        this.type = type;
        this.constantPool = constantPool;
    }

    public static ElementValue readElementValue(DataInput input, ConstantPool cpool) throws IOException {
        byte type = input.readByte();
        switch (type) {
            case 16:
            case PRIMITIVE_CHAR:
            case PRIMITIVE_DOUBLE:
            case PRIMITIVE_FLOAT:
            case PRIMITIVE_INT:
            case PRIMITIVE_LONG:
            case PRIMITIVE_SHORT:
            case PRIMITIVE_BOOLEAN:
            case STRING:
                return new SimpleElementValue(type, input.readUnsignedShort(), cpool);
            case ENUM_CONSTANT:
                return new EnumElementValue(ENUM_CONSTANT, input.readUnsignedShort(), input.readUnsignedShort(), cpool);
            case CLASS:
                return new ClassElementValue(CLASS, input.readUnsignedShort(), cpool);
            case ANNOTATION:
                return new AnnotationElementValue(ANNOTATION, AnnotationEntry.read(input, cpool, false), cpool);
            case ARRAY:
                int numArrayVals = input.readUnsignedShort();
                ElementValue[] evalues = new ElementValue[numArrayVals];
                for (int j = 0; j < numArrayVals; j++) {
                    evalues[j] = ElementValue.readElementValue(input, cpool);
                }
                return new ArrayElementValue(ARRAY, evalues, cpool);
            default:
                throw new IllegalArgumentException("Unexpected element value kind in annotation: " + type);
        }
    }

    public abstract String stringifyValue();

    public String toShortString() {
        return stringifyValue();
    }

    @Override
    public String toString() {
        return stringifyValue();
    }
}
