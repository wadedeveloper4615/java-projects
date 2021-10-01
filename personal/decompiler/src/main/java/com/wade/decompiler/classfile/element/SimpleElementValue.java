package com.wade.decompiler.classfile.element;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class SimpleElementValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class SimpleElementValue extends ElementValue {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new simple element value.
     *
     * @param type  the type
     * @param index the index
     */
    public SimpleElementValue(int type, int index) {
	super(type);
	this.index = index;
    }
//
//    public boolean getValueBoolean(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_BOOLEAN) {
//	    throw new IllegalStateException("Dont call getValueBoolean() on a non BOOLEAN ElementValue");
//	}
//	ConstantInteger bo = (ConstantInteger) constantPool.getConstant(getIndex());
//	return bo.getBytes() != 0;
//    }
//
//    public byte getValueByte(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_BYTE) {
//	    throw new IllegalStateException("Dont call getValueByte() on a non BYTE ElementValue");
//	}
//	ConstantInteger c = (ConstantInteger) constantPool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//	return c.getBytes().byteValue();
//    }
//
//    public char getValueChar(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_CHAR) {
//	    throw new IllegalStateException("Dont call getValueChar() on a non CHAR ElementValue");
//	}
//	ConstantInteger c = (ConstantInteger) constantPool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//	return (char) c.getBytes().byteValue();
//    }
//
//    public double getValueDouble(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_DOUBLE) {
//	    throw new IllegalStateException("Dont call getValueDouble() on a non DOUBLE ElementValue");
//	}
//	ConstantDouble d = (ConstantDouble) constantPool.getConstant(getIndex());
//	return d.getBytes();
//    }
//
//    public float getValueFloat(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_FLOAT) {
//	    throw new IllegalStateException("Dont call getValueFloat() on a non FLOAT ElementValue");
//	}
//	ConstantFloat f = (ConstantFloat) constantPool.getConstant(getIndex());
//	return f.getBytes();
//    }
//
//    public int getValueInt(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_INT) {
//	    throw new IllegalStateException("Dont call getValueString() on a non STRING ElementValue");
//	}
//	ConstantInteger c = (ConstantInteger) constantPool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//	return c.getBytes();
//    }
//
//    public long getValueLong(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_LONG) {
//	    throw new IllegalStateException("Dont call getValueLong() on a non LONG ElementValue");
//	}
//	ConstantLong j = (ConstantLong) constantPool.getConstant(getIndex());
//	return j.getBytes();
//    }
//
//    public short getValueShort(ConstantPool constantPool) {
//	if (super.getType() != PRIMITIVE_SHORT) {
//	    throw new IllegalStateException("Dont call getValueShort() on a non SHORT ElementValue");
//	}
//	ConstantInteger s = (ConstantInteger) constantPool.getConstant(getIndex());
//	return s.getBytes().shortValue();
//    }
//
//    public String getValueString(ConstantPool constantPool) {
//	if (super.getType() != STRING) {
//	    throw new IllegalStateException("Dont call getValueString() on a non STRING ElementValue");
//	}
//	ConstantUtf8 c = (ConstantUtf8) constantPool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Utf8);
//	return c.getBytes();
//    }
//
//    public String stringifyValue(ConstantPool constantPool) {
//	ConstantPool cpool = constantPool;
//	int _type = super.getType();
//	switch (_type) {
//	    case PRIMITIVE_INT:
//		ConstantInteger c = (ConstantInteger) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//		return Integer.toString(c.getBytes());
//	    case PRIMITIVE_LONG:
//		ConstantLong j = (ConstantLong) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Long);
//		return Long.toString(j.getBytes());
//	    case PRIMITIVE_DOUBLE:
//		ConstantDouble d = (ConstantDouble) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Double);
//		return Double.toString(d.getBytes());
//	    case PRIMITIVE_FLOAT:
//		ConstantFloat f = (ConstantFloat) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Float);
//		return Float.toString(f.getBytes());
//	    case PRIMITIVE_SHORT:
//		ConstantInteger s = (ConstantInteger) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//		return Integer.toString(s.getBytes());
//	    case PRIMITIVE_BYTE:
//		ConstantInteger b = (ConstantInteger) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//		return Integer.toString(b.getBytes());
//	    case PRIMITIVE_CHAR:
//		ConstantInteger ch = (ConstantInteger) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//		return String.valueOf((char) ch.getBytes().shortValue());
//	    case PRIMITIVE_BOOLEAN:
//		ConstantInteger bo = (ConstantInteger) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Integer);
//		if (bo.getBytes() == 0) {
//		    return "false";
//		}
//		return "true";
//	    case STRING:
//		ConstantUtf8 cu8 = (ConstantUtf8) cpool.getConstant(getIndex(), ClassFileConstants.CONSTANT_Utf8);
//		return cu8.getBytes();
//	    default:
//		throw new IllegalStateException("SimpleElementValue class does not know how to stringify type " + _type);
//	}
//    }
}
