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
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ExceptionTable.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ExceptionTable extends Attribute {

    /** The exception index table. */
    private List<Integer> exceptionIndexTable;

    /**
     * Instantiates a new exception table.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ExceptionTable(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_EXCEPTIONS, nameIndex, length);
        int number_of_exceptions = input.readUnsignedShort();
        exceptionIndexTable = new ArrayList<>();
        for (int i = 0; i < number_of_exceptions; i++) {
            exceptionIndexTable.add(input.readUnsignedShort());
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
