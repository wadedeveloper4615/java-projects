package com.wade.pojotester.testfiles;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class FullPojo.
 */
public class FullPojo {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5103281989426867172L;
    
    /** The var 1. */
    private char var1;
    
    /** The var 2. */
    private byte var2;
    
    /** The var 3. */
    private short var3;
    
    /** The var 4. */
    private int var4;
    
    /** The var 5. */
    private long var5;
    
    /** The var 6. */
    private float var6;
    
    /** The var 7. */
    private double var7;
    
    /** The var 8. */
    private String var8;

    /**
     * Instantiates a new full pojo.
     */
    public FullPojo() {
	super();
    }

    /**
     * Instantiates a new full pojo.
     *
     * @param var1 the var 1
     * @param var2 the var 2
     * @param var3 the var 3
     * @param var4 the var 4
     * @param var5 the var 5
     * @param var6 the var 6
     * @param var7 the var 7
     * @param var8 the var 8
     */
    public FullPojo(char var1, byte var2, short var3, int var4, long var5, float var6, double var7, String var8) {
	super();
	this.var1 = var1;
	this.var2 = var2;
	this.var3 = var3;
	this.var4 = var4;
	this.var5 = var5;
	this.var6 = var6;
	this.var7 = var7;
	this.var8 = var8;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof FullPojo)) {
	    return false;
	}
	FullPojo other = (FullPojo) obj;
	return var1 == other.var1 && var2 == other.var2 && var3 == other.var3 && var4 == other.var4 && var5 == other.var5 && Float.floatToIntBits(var6) == Float.floatToIntBits(other.var6) && Double.doubleToLongBits(var7) == Double.doubleToLongBits(other.var7) && Objects.equals(var8, other.var8);
    }

    /**
     * Gets the var 1.
     *
     * @return the var 1
     */
    public char getVar1() {
	try {
	    var1 = (char) (var1 / 9);
	} catch (Exception e) {
	    throw new RuntimeException();
	}
	return var1;
    }

    /**
     * Gets the var 2.
     *
     * @return the var 2
     */
    public byte getVar2() {
	return var2;
    }

    /**
     * Gets the var 3.
     *
     * @return the var 3
     */
    public short getVar3() {
	return var3;
    }

    /**
     * Gets the var 4.
     *
     * @return the var 4
     */
    public int getVar4() {
	return var4;
    }

    /**
     * Gets the var 5.
     *
     * @return the var 5
     */
    public long getVar5() {
	return var5;
    }

    /**
     * Gets the var 6.
     *
     * @return the var 6
     */
    public float getVar6() {
	return var6;
    }

    /**
     * Gets the var 7.
     *
     * @return the var 7
     */
    public double getVar7() {
	return var7;
    }

    /**
     * Gets the var 8.
     *
     * @return the var 8
     */
    public String getVar8() {
	return var8;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return Objects.hash(var1, var2, var3, var4, var5, var6, var7, var8);
    }

    /**
     * Sets the var 1.
     *
     * @param var1 the new var 1
     */
    public void setVar1(char var1) {
	this.var1 = var1;
    }

    /**
     * Sets the var 2.
     *
     * @param var2 the new var 2
     */
    public void setVar2(byte var2) {
	this.var2 = var2;
    }

    /**
     * Sets the var 3.
     *
     * @param var3 the new var 3
     */
    public void setVar3(short var3) {
	this.var3 = var3;
    }

    /**
     * Sets the var 4.
     *
     * @param var4 the new var 4
     */
    public void setVar4(int var4) {
	this.var4 = var4;
    }

    /**
     * Sets the var 5.
     *
     * @param var5 the new var 5
     */
    public void setVar5(long var5) {
	this.var5 = var5;
    }

    /**
     * Sets the var 6.
     *
     * @param var6 the new var 6
     */
    public void setVar6(float var6) {
	this.var6 = var6;
    }

    /**
     * Sets the var 7.
     *
     * @param var7 the new var 7
     */
    public void setVar7(double var7) {
	this.var7 = var7;
    }

    /**
     * Sets the var 8.
     *
     * @param var8 the new var 8
     */
    public void setVar8(String var8) {
	this.var8 = var8;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("FullPojo [var1=");
	builder.append(var1);
	builder.append(", var2=");
	builder.append(var2);
	builder.append(", var3=");
	builder.append(var3);
	builder.append(", var4=");
	builder.append(var4);
	builder.append(", var5=");
	builder.append(var5);
	builder.append(", var6=");
	builder.append(var6);
	builder.append(", var7=");
	builder.append(var7);
	builder.append(", var8=");
	builder.append(var8);
	builder.append("]");
	return builder.toString();
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
	return serialVersionUID;
    }
}
