package com.wade.decompiler.test;

import java.io.Serializable;

/**
 * The Class Test1.
 */
@SuppressWarnings("unused")
public class SimpleClassWithSwitches implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5103281989426867172L;
    /** The var 1. */
    private int var1;
    /** The var 2. */
    private int var2;

    /**
     * Switch 1.
     *
     * @param choice the choice
     */
    public void switch1(int choice) {
        var1 = switch (choice) {
            case 0 -> 0;
            case 1 -> 5;
            default -> 10;
        };
    }

    /**
     * Switch 2.
     *
     * @param choice the choice
     */
    public void switch2(int choice) {
        var1 = switch (choice) {
            case 5 -> 5;
            case 10 -> 10;
            default -> 15;
        };
    }

    /**
     * Switch 3.
     *
     * @param choice the choice
     */
    public void switch3(int choice) {
        switch (choice) {
            case 0:
                var1 = 0;
                break;
            case 1:
                var2 = 5;
                break;
            default:
                var1 = 10;
                break;
        }
    }

    /**
     * Switch 4.
     *
     * @param choice the choice
     */
    public void switch4(int choice) {
        switch (choice) {
            case 5:
                var1 = 0;
                break;
            case 10:
                var2 = 5;
                break;
            default:
                var1 = 10;
                break;
        }
    }
}
