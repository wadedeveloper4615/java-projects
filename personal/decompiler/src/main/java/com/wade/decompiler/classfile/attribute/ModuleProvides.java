/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ModuleProvides.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ModuleProvides {

    /** The provides index. */
    private Integer providesIndex;

    /** The provides with count. */
    private Integer providesWithCount;

    /** The provides with index. */
    private List<Integer> providesWithIndex;

    /**
     * Instantiates a new module provides.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ModuleProvides(DataInput file) throws IOException {
        providesIndex = file.readUnsignedShort();
        providesWithCount = file.readUnsignedShort();
        providesWithIndex = new ArrayList<>();
        for (int i = 0; i < providesWithCount; i++) {
            providesWithIndex.add(file.readUnsignedShort());
        }
    }
}
