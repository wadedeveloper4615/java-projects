package com.wade.decompiler.test;

import java.io.Serializable;

/**
 * The Class SimpleClassWithArrayFields.
 */
public class SimpleClassWithArrayFields implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5103281989426867172L;
    /** The var 1. */
    private char[] var1;
    /** The var 2. */
    private byte[] var2;
    /** The var 3. */
    private short[] var3;
    /** The var 4. */
    private int[] var4;
    /** The var 5. */
    private long[] var5;
    /** The var 6. */
    private float[] var6;
    /** The var 7. */
    private double[] var7;
    /** The var 8. */
    private Object[] var8;

    /**
     * Function A.
     *
     * @param var1 the var 1
     */
    public void functionA(char[] var1) {
        this.var1 = var1;
    }

    /**
     * Function B.
     *
     * @param index the index
     * @param var1  the var 1
     */
    public void functionB(int index, char[] var1) {
        char var = var1[index];
        this.var1[index] = var;
    }

    /**
     * Function C.
     *
     * @param var2 the var 2
     */
    public void functionC(byte[] var2) {
        this.var2 = var2;
    }

    /**
     * Function C.
     *
     * @param index the index
     * @param var2  the var 2
     */
    public void functionC(int index, byte[] var2) {
        byte var = var2[index];
        this.var2[index] = var;
    }

    /**
     * Function D.
     *
     * @param var3 the var 3
     */
    public void functionD(short[] var3) {
        this.var3 = var3;
    }

    /**
     * Function E.
     *
     * @param index the index
     * @param var3  the var 3
     */
    public void functionE(int index, short[] var3) {
        short var = var3[index];
        this.var3[index] = var;
    }

    /**
     * Function F.
     *
     * @param var4 the var 4
     */
    public void functionF(int[] var4) {
        this.var4 = var4;
    }

    /**
     * Function G.
     *
     * @param index the index
     * @param var4  the var 4
     */
    public void functionG(int index, int[] var4) {
        int var = var4[index];
        this.var4[index] = var;
    }

    /**
     * Function H.
     *
     * @param var5 the var 5
     */
    public void functionH(long[] var5) {
        this.var5 = var5;
    }

    /**
     * Function I.
     *
     * @param index the index
     * @param var5  the var 5
     */
    public void functionI(int index, long[] var5) {
        long var = var5[index];
        this.var5[index] = var;
    }

    /**
     * Function J.
     *
     * @param var6 the var 6
     */
    public void functionJ(float[] var6) {
        this.var6 = var6;
    }

    /**
     * Function K.
     *
     * @param index the index
     * @param var6  the var 6
     */
    public void functionK(int index, float[] var6) {
        float var = var6[index];
        this.var6[index] = var;
    }

    /**
     * Function L.
     *
     * @param var7 the var 7
     */
    public void functionL(double[] var7) {
        this.var7 = var7;
    }

    /**
     * Function M.
     *
     * @param index the index
     * @param var7  the var 7
     */
    public void functionM(int index, double[] var7) {
        double var = var7[index];
        this.var7[index] = var;
    }

    /**
     * Function N.
     *
     * @param var8 the var 8
     */
    public void functionN(Object[] var8) {
        this.var8 = var8;
    }

    /**
     * Function O.
     *
     * @param index the index
     * @param var8  the var 8
     */
    public void functionO(int index, Object[] var8) {
        Object var = var8[index];
        this.var8[index] = var;
    }
}
