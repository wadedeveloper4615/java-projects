package com.wade.decompiler.classfile.element;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.AnnotationEntry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ElementValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public abstract class ElementValue {
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
     * Instantiates a new element value.
     */
    public ElementValue() {
	super();
    }

    /**
     * Instantiates a new element value.
     *
     * @param type the type
     */
    public ElementValue(int type) {
	this.type = type;
    }

    /**
     * Read element value.
     *
     * @param input the input
     * @return the element value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static ElementValue readElementValue(DataInput input) throws IOException {
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
		return new SimpleElementValue(type, input.readUnsignedShort());
	    case ENUM_CONSTANT:
		return new EnumElementValue(ENUM_CONSTANT, input.readUnsignedShort(), input.readUnsignedShort());
	    case CLASS:
		return new ClassElementValue(CLASS, input.readUnsignedShort());
	    case ANNOTATION:
		return new AnnotationElementValue(ANNOTATION, AnnotationEntry.read(input, false));
	    case ARRAY:
		int numArrayVals = input.readUnsignedShort();
		List<ElementValue> evalues = new ArrayList<>();
		for (int j = 0; j < numArrayVals; j++) {
		    evalues.add(ElementValue.readElementValue(input));
		}
		return new ArrayElementValue(ARRAY, evalues);
	    default:
		throw new IllegalArgumentException("Unexpected element value kind in annotation: " + type);
	}
    }
}
