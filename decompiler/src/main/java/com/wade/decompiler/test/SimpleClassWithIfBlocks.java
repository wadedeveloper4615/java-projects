package com.wade.decompiler.test;

import java.io.Serializable;

/**
 * The Class SimpleClassWithIfBlocks.
 */
@SuppressWarnings("unused")
public class SimpleClassWithIfBlocks implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5103281989426867172L;

    /** The var 1. */
    private int var1;
    /** The var 2. */
    private int var2;

    /**
     * Function 1.
     *
     * @param var the var
     */
    public void function1(int var) {
        if (var == 10) {
            this.var1 = var + 5;
        }
        this.var2 = var + 7;
    }

    /**
     * Function 2.
     *
     * @param var the var
     */
    public void function2(int var) {
        if (var == 10) {
            this.var1 = var + 5;
        } else {
            this.var2 = var + 7;
        }
    }

    /**
     * Function 3.
     *
     * @param var the var
     */
    public void function3(int var) {
        for (int index = 0; index < var; index++) {

        }
    }
}
