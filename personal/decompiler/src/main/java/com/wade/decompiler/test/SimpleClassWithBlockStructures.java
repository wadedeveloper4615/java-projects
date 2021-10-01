package com.wade.decompiler.test;

/**
 * The Class SimpleClass.
 */
public class SimpleClassWithBlockStructures {
    /**
     * If block byte.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the byte
     */
    public byte ifBlockByte(byte value1, byte value2) {
        byte result = -1;
        if (value1 == value2) {
            result = 0;
        }
        if (value1 != value2) {
            result = 1;
        }
        if (value1 >= value2) {
            result = 2;
        }
        if (value1 <= value2) {
            result = 3;
        }
        if (value1 > value2) {
            result = 4;
        }
        if (value1 < value2) {
            result = 5;
        }
        return result;
    }

    /**
     * If block int.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the int
     */
    public int ifBlockInt(int value1, int value2) {
        int result = -1;
        if (value1 == value2) {
            result = 0;
        }
        if (value1 != value2) {
            result = 1;
        }
        if (value1 >= value2) {
            result = 2;
        }
        if (value1 <= value2) {
            result = 3;
        }
        if (value1 > value2) {
            result = 4;
        }
        if (value1 < value2) {
            result = 5;
        }
        return result;
    }

    /**
     * If block long.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the long
     */
    public long ifBlockLong(long value1, long value2) {
        long result = -1;
        if (value1 == value2) {
            result = 0;
        }
        if (value1 != value2) {
            result = 1;
        }
        if (value1 >= value2) {
            result = 2;
        }
        if (value1 <= value2) {
            result = 3;
        }
        if (value1 > value2) {
            result = 4;
        }
        if (value1 < value2) {
            result = 5;
        }
        return result;
    }

    /**
     * If else block byte.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the byte
     */
    public byte ifElseBlockByte(byte value1, byte value2) {
        byte result = -1;
        if (value1 == value2) {
            result = 0;
        } else {
            result = 0;
        }
        if (value1 != value2) {
            result = 1;
        } else {
            result = 0;
        }
        if (value1 >= value2) {
            result = 2;
        } else {
            result = 0;
        }
        if (value1 <= value2) {
            result = 3;
        } else {
            result = 0;
        }
        if (value1 > value2) {
            result = 4;
        } else {
            result = 0;
        }
        if (value1 < value2) {
            result = 5;
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * If else block int.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the int
     */
    public int ifElseBlockInt(int value1, int value2) {
        int result = -1;
        if (value1 == value2) {
            result = 0;
        } else {
            result = 0;
        }
        if (value1 != value2) {
            result = 1;
        } else {
            result = 0;
        }
        if (value1 >= value2) {
            result = 2;
        } else {
            result = 0;
        }
        if (value1 <= value2) {
            result = 3;
        } else {
            result = 0;
        }
        if (value1 > value2) {
            result = 4;
        } else {
            result = 0;
        }
        if (value1 < value2) {
            result = 5;
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * If else block long.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the long
     */
    public long ifElseBlockLong(long value1, long value2) {
        long result = -1;
        if (value1 == value2) {
            result = 0;
        } else {
            result = 0;
        }
        if (value1 != value2) {
            result = 1;
        } else {
            result = 0;
        }
        if (value1 >= value2) {
            result = 2;
        } else {
            result = 0;
        }
        if (value1 <= value2) {
            result = 3;
        } else {
            result = 0;
        }
        if (value1 > value2) {
            result = 4;
        } else {
            result = 0;
        }
        if (value1 < value2) {
            result = 5;
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * Switch int 1.
     *
     * @param value1 the value 1
     * @return the int
     */
    public int switchInt1(int value1) {
        int result = -1;
        switch (value1) {
            case 1:
                result = 1;
            case 2:
                result = 2;
            case 3:
                result = 3;
            default:
                result = 4;
        }
        return result;
    }

    /**
     * Switch int 2.
     *
     * @param value1 the value 1
     * @return the int
     */
    public int switchInt2(int value1) {
        int result = -1;
        switch (value1) {
            case 5:
                result = 1;
            case 10:
                result = 2;
            case 15:
                result = 3;
            default:
                result = 4;
        }
        return result;
    }
}
