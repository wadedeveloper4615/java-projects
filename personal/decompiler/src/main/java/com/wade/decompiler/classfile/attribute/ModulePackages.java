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
 * The Class ModulePackages.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ModulePackages extends Attribute {

    /** The package index table. */
    private List<Integer> packageIndexTable;

    /**
     * Instantiates a new module packages.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ModulePackages(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_MODULE_PACKAGES, nameIndex, length);
        int number_of_packages = input.readUnsignedShort();
        this.packageIndexTable = new ArrayList<>();
        for (int i = 0; i < number_of_packages; i++) {
            packageIndexTable.add(input.readUnsignedShort());
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
