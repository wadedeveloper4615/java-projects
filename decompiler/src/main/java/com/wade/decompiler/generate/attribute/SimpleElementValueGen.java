package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.element.SimpleElementValue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class SimpleElementValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class SimpleElementValueGen extends ElementValueGen {
    /** The index constant. */
    private Constant indexConstant;

    /**
     * Instantiates a new simple element value gen.
     *
     * @param element      the element
     * @param constantPool the constant pool
     */
    public SimpleElementValueGen(SimpleElementValue element, ConstantPool constantPool) {
        super(element.getType());
        this.indexConstant = constantPool.getConstant(element.getIndex());
        this.type = element.getType();
    }

//    public boolean getValueBoolean() {
//	if (super.getType() != PRIMITIVE_BOOLEAN) {
//	    throw new IllegalStateException("Dont call getValueBoolean() on a non BOOLEAN ElementValue");
//	}
//	ConstantInteger bo = (ConstantInteger) indexConstant;
//	return bo.getBytes().intValue() != 0;
//    }
//
//    public byte getValueByte() {
//	if (super.getType() != PRIMITIVE_BYTE) {
//	    throw new IllegalStateException("Dont call getValueByte() on a non BYTE ElementValue");
//	}
//	ConstantInteger c = (ConstantInteger) indexConstant;
//	return c.getBytes().byteValue();
//    }
//
//    public char getValueChar() {
//	if (super.getType() != PRIMITIVE_CHAR) {
//	    throw new IllegalStateException("Dont call getValueChar() on a non CHAR ElementValue");
//	}
//	ConstantInteger c = (ConstantInteger) indexConstant;
//	return (char) c.getBytes().shortValue();
//    }
//
//    public double getValueDouble() {
//	if (super.getType() != PRIMITIVE_DOUBLE) {
//	    throw new IllegalStateException("Dont call getValueDouble() on a non DOUBLE ElementValue");
//	}
//	ConstantDouble d = (ConstantDouble) indexConstant;
//	return d.getBytes().doubleValue();
//    }
//
//    public float getValueFloat() {
//	if (super.getType() != PRIMITIVE_FLOAT) {
//	    throw new IllegalStateException("Dont call getValueFloat() on a non FLOAT ElementValue");
//	}
//	ConstantFloat f = (ConstantFloat) indexConstant;
//	return f.getBytes().floatValue();
//    }
//
//    public int getValueInt() {
//	if (super.getType() != PRIMITIVE_INT) {
//	    throw new IllegalStateException("Dont call getValueString() on a non STRING ElementValue");
//	}
//	ConstantInteger c = (ConstantInteger) indexConstant;
//	return c.getBytes().intValue();
//    }
//
//    public long getValueLong() {
//	if (super.getType() != PRIMITIVE_LONG) {
//	    throw new IllegalStateException("Dont call getValueLong() on a non LONG ElementValue");
//	}
//	ConstantLong j = (ConstantLong) indexConstant;
//	return j.getBytes().longValue();
//    }
//
//    public short getValueShort() {
//	if (super.getType() != PRIMITIVE_SHORT) {
//	    throw new IllegalStateException("Dont call getValueShort() on a non SHORT ElementValue");
//	}
//	ConstantInteger s = (ConstantInteger) indexConstant;
//	return s.getBytes().shortValue();
//    }
//
//    public String getValueString() {
//	if (super.getType() != STRING) {
//	    throw new IllegalStateException("Dont call getValueString() on a non STRING ElementValue");
//	}
//	ConstantUtf8 c = (ConstantUtf8) indexConstant;
//	return c.getBytes();
//    }
//
//    public String stringifyValue() {
//	switch (type.intValue()) {
//	    case PRIMITIVE_INT:
//		return Integer.toString(((ConstantInteger) indexConstant).getBytes().intValue());
//	    case PRIMITIVE_LONG:
//		return Long.toString(((ConstantLong) indexConstant).getBytes().longValue());
//	    case PRIMITIVE_DOUBLE:
//		return Double.toString(((ConstantDouble) indexConstant).getBytes().doubleValue());
//	    case PRIMITIVE_FLOAT:
//		return Float.toString(((ConstantFloat) indexConstant).getBytes().floatValue());
//	    case PRIMITIVE_SHORT:
//	    case PRIMITIVE_BYTE:
//	    case PRIMITIVE_CHAR:
//		return Integer.toString(((ConstantInteger) indexConstant).getBytes().intValue());
//	    case PRIMITIVE_BOOLEAN:
//		if (((ConstantInteger) indexConstant).getBytes().intValue() == 0) {
//		    return "false";
//		}
//		return "true";
//	    case STRING:
//		return ((ConstantUtf8) indexConstant).getBytes();
//	    default:
//		throw new IllegalStateException("SimpleElementValue class does not know how to stringify type " + type);
//	}
//    }
}
