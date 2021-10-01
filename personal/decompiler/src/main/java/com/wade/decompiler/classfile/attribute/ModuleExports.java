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
 * The Class ModuleExports.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ModuleExports {

    /** The exports index. */
    private final Integer exportsIndex;

    /** The exports flags. */
    private final Integer exportsFlags;

    /** The exports to count. */
    private final Integer exportsToCount;

    /** The exports to index. */
    private final List<Integer> exportsToIndex;

    /**
     * Instantiates a new module exports.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ModuleExports(DataInput file) throws IOException {
        exportsIndex = file.readUnsignedShort();
        exportsFlags = file.readUnsignedShort();
        exportsToCount = file.readUnsignedShort();
        exportsToIndex = new ArrayList<>();
        for (int i = 0; i < exportsToCount; i++) {
            exportsToIndex.add(file.readUnsignedShort());
        }
    }
}
