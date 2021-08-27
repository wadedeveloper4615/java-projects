package com.wade.decompiler.util;

import java.io.DataInput;
import java.io.IOException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Instantiates a new byte array.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ByteArray {
    /** The array. */
    private byte[] array;

    /**
     * Instantiates a new byte array.
     */
    public ByteArray() {
    }

    /**
     * Gets the array length.
     *
     * @return the array length
     */
    public long getArrayLength() {
        return (array == null) ? (0) : (array.length);
    }

    /**
     * Read fully.
     *
     * @param in  the in
     * @param len the len
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void readFully(DataInput in, int len) throws IOException {
        array = new byte[len];
        in.readFully(array, 0, len);
    }
}