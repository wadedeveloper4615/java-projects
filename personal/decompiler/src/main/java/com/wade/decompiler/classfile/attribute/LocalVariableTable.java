/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class LocalVariableTable.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class LocalVariableTable extends Attribute {

    /** The local variable table. */
    private final Map<Integer, LocalVariable> localVariableTable;

    /**
     * Instantiates a new local variable table.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public LocalVariableTable(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_LOCAL_VARIABLE_TABLE, nameIndex, length);
        int local_variable_table_length = input.readUnsignedShort();
        localVariableTable = new HashMap<>();
        for (int i = 0; i < local_variable_table_length; i++) {
            LocalVariable localVar = new LocalVariable(input);
            localVariableTable.put(localVar.getSlot(), localVar);
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
