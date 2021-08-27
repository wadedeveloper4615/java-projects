package com.wade.decompiler.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * The Class ByteSequence.
 */
public class ByteSequence extends DataInputStream {
    /**
     * The Class ByteArrayStream.
     */
    private static class ByteArrayStream extends ByteArrayInputStream {
        /**
         * Instantiates a new byte array stream.
         *
         * @param bytes the bytes
         */
        ByteArrayStream(byte[] bytes) {
            super(bytes);
        }

        /**
         * Gets the position.
         *
         * @return the position
         */
        int getPosition() {
            // pos is protected in ByteArrayInputStream
            return pos;
        }
    }

    /** The byte stream. */
    private final ByteArrayStream byteStream;

    /**
     * Instantiates a new byte sequence.
     *
     * @param bytes the bytes
     */
    public ByteSequence(byte[] bytes) {
        super(new ByteArrayStream(bytes));
        byteStream = (ByteArrayStream) in;
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    public int getIndex() {
        return byteStream.getPosition();
    }
}
