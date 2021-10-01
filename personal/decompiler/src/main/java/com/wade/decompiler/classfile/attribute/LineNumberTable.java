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
 * The Class LineNumberTable.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class LineNumberTable extends Attribute {

    /** The line number table. */
    private List<LineNumber> lineNumberTable;

    /**
     * Instantiates a new line number table.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public LineNumberTable(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_LINE_NUMBER_TABLE, nameIndex, length);
        int line_number_table_length = input.readUnsignedShort();
        lineNumberTable = new ArrayList<>();
        for (int i = 0; i < line_number_table_length; i++) {
            lineNumberTable.add(new LineNumber(input));
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
