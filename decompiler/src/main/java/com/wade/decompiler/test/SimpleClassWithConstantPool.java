package com.wade.decompiler.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The Class SimpleClassWithConstantPool.
 */
@SuppressWarnings({ "unused" })
public class SimpleClassWithConstantPool {
    /** The var 1. */
    private char var1;
    /** The var 2. */
    private short var2;
    /** The var 3. */
    private int var3 = 250000;
    /** The var 4. */
    private long var4 = 7;
    /** The var 5. */
    private float var5 = 8f;
    /** The var 6. */
    private double var6 = 6;
    /** The var 7. */
    private boolean var7 = true;
    /** The v 8. */
    private List<String> v8;
    /** The v 9. */
    private String v9 = "shdhsalhd";

    /**
     * Instantiates a new simple class with constant pool.
     */
    public SimpleClassWithConstantPool() {
        v8 = new ArrayList<>();
        v8.add("");
        this.toString();
    }

    /**
     * Fuction 1.
     */
    public void fuction1() {
        List<String> value = List.of("Red", "Green", "Blue");
        Stream<String> stream = value.stream();
        long lengthyColors = stream.filter(c -> c.length() > 3).count();
    }
}
