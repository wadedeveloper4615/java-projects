/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ModuleRequires.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ModuleRequires {

    /** The requires index. */
    private Integer requiresIndex;

    /** The requires flags. */
    private Integer requiresFlags;

    /** The requires version index. */
    private Integer requiresVersionIndex;

    /**
     * Instantiates a new module requires.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ModuleRequires(DataInput file) throws IOException {
        this.requiresIndex = file.readUnsignedShort();
        this.requiresFlags = file.readUnsignedShort();
        this.requiresVersionIndex = file.readUnsignedShort();
    }
}
