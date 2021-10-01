/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class Module.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Module extends Attribute {

    /** The module name index. */
    private Integer moduleNameIndex;

    /** The module flags. */
    private Integer moduleFlags;

    /** The module version index. */
    private Integer moduleVersionIndex;

    /** The requires table. */
    private List<ModuleRequires> requiresTable;

    /** The exports table. */
    private List<ModuleExports> exportsTable;

    /** The opens table. */
    private List<ModuleOpens> opensTable;

    /** The uses count. */
    private Integer usesCount;

    /** The uses index. */
    private List<Integer> usesIndex;

    /** The provides table. */
    private List<ModuleProvides> providesTable;

    /**
     * Instantiates a new module.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Module(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_MODULE, nameIndex, length);
        moduleNameIndex = input.readUnsignedShort();
        moduleFlags = input.readUnsignedShort();
        moduleVersionIndex = input.readUnsignedShort();
        int requires_count = input.readUnsignedShort();
        requiresTable = new ArrayList<>();
        for (int i = 0; i < requires_count; i++) {
            requiresTable.add(new ModuleRequires(input));
        }
        int exports_count = input.readUnsignedShort();
        exportsTable = new ArrayList<>();
        for (int i = 0; i < exports_count; i++) {
            exportsTable.add(new ModuleExports(input));
        }
        int opens_count = input.readUnsignedShort();
        opensTable = new ArrayList<>();
        for (int i = 0; i < opens_count; i++) {
            opensTable.add(new ModuleOpens(input));
        }
        usesCount = input.readUnsignedShort();
        usesIndex = new ArrayList<>();
        for (int i = 0; i < usesCount; i++) {
            usesIndex.add(input.readUnsignedShort());
        }
        int provides_count = input.readUnsignedShort();
        providesTable = new ArrayList<>();
        for (int i = 0; i < provides_count; i++) {
            providesTable.add(new ModuleProvides(input));
        }
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
