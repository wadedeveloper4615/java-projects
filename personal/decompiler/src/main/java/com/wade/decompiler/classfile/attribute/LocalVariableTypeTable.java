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
 * The Class LocalVariableTypeTable.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class LocalVariableTypeTable extends Attribute {

    /** The local variable type table. */
    private Map<Integer, LocalVariable> localVariableTypeTable;

    /**
     * Instantiates a new local variable type table.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public LocalVariableTypeTable(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_LOCAL_VARIABLE_TYPE_TABLE, nameIndex, length);
        int local_variable_type_table_length = input.readUnsignedShort();
        localVariableTypeTable = new HashMap<>();
        for (int i = 0; i < local_variable_type_table_length; i++) {
            LocalVariable localVariable = new LocalVariable(input);
            localVariableTypeTable.put(localVariable.getSlot(), localVariable);
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
