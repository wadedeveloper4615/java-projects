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
 * The Class ModuleOpens.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ModuleOpens {

    /** The opens index. */
    private Integer opensIndex;

    /** The opens flags. */
    private Integer opensFlags;

    /** The opens to count. */
    private Integer opensToCount;

    /** The opens to index. */
    private List<Integer> opensToIndex;

    /**
     * Instantiates a new module opens.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ModuleOpens(DataInput file) throws IOException {
        opensIndex = file.readUnsignedShort();
        opensFlags = file.readUnsignedShort();
        opensToCount = file.readUnsignedShort();
        opensToIndex = new ArrayList<>();
        for (int i = 0; i < opensToCount; i++) {
            opensToIndex.add(file.readUnsignedShort());
        }
    }
}
