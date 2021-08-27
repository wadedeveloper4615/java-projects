package com.wade.decompiler.test;

import java.util.List;
import java.util.stream.Stream;

/**
 * The Class SimpleClassWithInitializedFields.
 */
//@SuppressWarnings("unused")
public class SimpleClassWithInitializedFields {// implements Serializable {
//    /** The Constant serialVersionUID. */
//    private static final long serialVersionUID = -5103281989426867172L;
//
//    /**
//     * Gets the serialversionuid.
//     *
//     * @return the serialversionuid
//     */
//    public static long getSerialversionuid() {
//        return serialVersionUID;
//    }
//
//    /** The var 1. */
//    private char var1 = 'c';
//    /** The var 2. */
//    private byte var2 = 10;
//    /** The var 3. */
//    private short var3 = 9;
//    /** The var 4. */
//    private int var4 = 120;
//    /** The var 5. */
//    private long var5 = 7;
//    /** The var 6. */
//    private float var6 = 3.0f;
//    /** The var 7. */
//    private double var7 = 2.0;
//    /** The var 8. */
//    private String var8 = "string";
//
//    /** The var 9. */
//    private boolean var9 = false;
//
//    /**
//     * Instantiates a new test 5.
//     */
//    public SimpleClassWithInitializedFields() {
//    }
//
//    /**
//     * Instantiates a new test 5.
//     *
//     * @param var1 the var 1
//     * @param var2 the var 2
//     * @param var3 the var 3
//     * @param var4 the var 4
//     * @param var5 the var 5
//     * @param var6 the var 6
//     * @param var7 the var 7
//     * @param var8 the var 8
//     */
//    public SimpleClassWithInitializedFields(char var1, byte var2, short var3, int var4, long var5, float var6, double var7, String var8) {
//        this.var1 = var1;
//        this.var2 = var2;
//        this.var3 = var3;
//        this.var4 = var4;
//        this.var5 = var5;
//        this.var6 = var6;
//        this.var7 = var7;
//        this.var8 = var8;
//    }
//
//    /**
//     * Instantiates a new test 5.
//     *
//     * @param h the h
//     */
//    public SimpleClassWithInitializedFields(int h) {
//        var1 = 'c';
//        var2 = 10;
//        var3 = 9;
//        var4 = 8;
//        var5 = 7;
//        var6 = 3.0f;
//        var7 = 2.0;
//        var8 = "string";
//        var9 = true;
//    }
//
//    /**
//     * Gets the var 1.
//     *
//     * @return the var 1
//     */
//    public char getVar1() {
//        try {
//            var1 = (char) (var1 / 9);
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//        return var1;
//    }
//
//    /**
//     * Gets the var 2.
//     *
//     * @return the var 2
//     */
//    public byte getVar2() {
//        return var2;
//    }
//
//    /**
//     * Gets the var 3.
//     *
//     * @return the var 3
//     */
//    public short getVar3() {
//        return var3;
//    }
//
//    /**
//     * Gets the var 4.
//     *
//     * @return the var 4
//     */
//    public int getVar4() {
//        return var4;
//    }
//
//    /**
//     * Gets the var 5.
//     *
//     * @return the var 5
//     */
//    public long getVar5() {
//        return var5;
//    }
//
//    /**
//     * Gets the var 6.
//     *
//     * @return the var 6
//     */
//    public float getVar6() {
//        return var6;
//    }
//
//    /**
//     * Gets the var 7.
//     *
//     * @return the var 7
//     */
//    public double getVar7() {
//        return var7;
//    }
//
//    /**
//     * Gets the var 8.
//     *
//     * @return the var 8
//     */
//    public String getVar8() {
//        return var8;
//    }

    /**
     * Number of long color names.
     *
     * @return the long
     */
    public long numberOfLongColorNames() {
        List<String> value = List.of("Red", "Green", "Blue");
        Stream<String> stream = value.stream();
        Stream<String> filter = stream.filter(c -> c.length() > 3);
        return filter.count();
    }

//    /**
//     * Sets the var 1.
//     *
//     * @param var1 the new var 1
//     */
//    public void setVar1(char var1) {
//        this.var1 = var1;
//    }
//
//    /**
//     * Sets the var 2.
//     *
//     * @param var2 the new var 2
//     */
//    public void setVar2(byte var2) {
//        this.var2 = var2;
//    }
//
//    /**
//     * Sets the var 3.
//     *
//     * @param var3 the new var 3
//     */
//    public void setVar3(short var3) {
//        this.var3 = var3;
//    }
//
//    /**
//     * Sets the var 4.
//     *
//     * @param var4 the new var 4
//     */
//    public void setVar4(int var4) {
//        this.var4 = var4;
//    }
//
//    /**
//     * Sets the var 5.
//     *
//     * @param var5 the new var 5
//     */
//    public void setVar5(long var5) {
//        this.var5 = var5;
//    }
//
//    /**
//     * Sets the var 6.
//     *
//     * @param var6 the new var 6
//     */
//    public void setVar6(float var6) {
//        this.var6 = var6;
//    }
//
//    /**
//     * Sets the var 7.
//     *
//     * @param var7 the new var 7
//     */
//    public void setVar7(double var7) {
//        this.var7 = var7;
//    }
//
//    /**
//     * Sets the var 8.
//     *
//     * @param var8 the new var 8
//     */
//    public void setVar8(String var8) {
//        this.var8 = var8;
//    }
}
