package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.element.AnnotationElementValue;
import com.wade.decompiler.classfile.element.ArrayElementValue;
import com.wade.decompiler.classfile.element.ClassElementValue;
import com.wade.decompiler.classfile.element.ElementValue;
import com.wade.decompiler.classfile.element.EnumElementValue;
import com.wade.decompiler.classfile.element.SimpleElementValue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ElementValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ElementValueGen {
    /** The Constant STRING. */
    public static final byte STRING = 's';
    /** The Constant ENUM_CONSTANT. */
    public static final byte ENUM_CONSTANT = 'e';
    /** The Constant CLASS. */
    public static final byte CLASS = 'c';
    /** The Constant ANNOTATION. */
    public static final byte ANNOTATION = '@';
    /** The Constant ARRAY. */
    public static final byte ARRAY = '[';
    /** The Constant PRIMITIVE_INT. */
    public static final byte PRIMITIVE_INT = 'I';
    /** The Constant PRIMITIVE_BYTE. */
    public static final byte PRIMITIVE_BYTE = 'B';
    /** The Constant PRIMITIVE_CHAR. */
    public static final byte PRIMITIVE_CHAR = 'C';
    /** The Constant PRIMITIVE_DOUBLE. */
    public static final byte PRIMITIVE_DOUBLE = 'D';
    /** The Constant PRIMITIVE_FLOAT. */
    public static final byte PRIMITIVE_FLOAT = 'F';
    /** The Constant PRIMITIVE_LONG. */
    public static final byte PRIMITIVE_LONG = 'J';
    /** The Constant PRIMITIVE_SHORT. */
    public static final byte PRIMITIVE_SHORT = 'S';
    /** The Constant PRIMITIVE_BOOLEAN. */
    public static final byte PRIMITIVE_BOOLEAN = 'Z';
    /** The type. */
    protected Integer type;

    /**
     * Instantiates a new element value gen.
     *
     * @param type the type
     */
    protected ElementValueGen(int type) {
	this.type = type;
    }

    /**
     * Read element value.
     *
     * @param value        the value
     * @param constantPool the constant pool
     * @return the element value gen
     */
    public static ElementValueGen readElementValue(ElementValue value, ConstantPool constantPool) {
	switch (value.getType().byteValue()) {
	    case 16:
	    case PRIMITIVE_CHAR:
	    case PRIMITIVE_DOUBLE:
	    case PRIMITIVE_FLOAT:
	    case PRIMITIVE_INT:
	    case PRIMITIVE_LONG:
	    case PRIMITIVE_SHORT:
	    case PRIMITIVE_BOOLEAN:
	    case STRING:
		return new SimpleElementValueGen((SimpleElementValue) value, constantPool);
	    case ENUM_CONSTANT:
		return new EnumElementValueGen(ENUM_CONSTANT, (EnumElementValue) value, constantPool);
	    case CLASS:
		return new ClassElementValueGen(CLASS, (ClassElementValue) value, constantPool);
	    case ANNOTATION:
		return new AnnotationElementValueGen(ANNOTATION, (AnnotationElementValue) value);
	    case ARRAY:
		return new ArrayElementValueGen(ARRAY, (ArrayElementValue) value, constantPool);
	    default:
		throw new IllegalArgumentException("Unexpected element value kind in annotation: " + value.getType());
	}
    }
}
