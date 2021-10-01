/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wade.decompiler.classfile.attribute.LocalVariable;
import com.wade.decompiler.classfile.attribute.LocalVariableTable;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LocalVariableTableGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class LocalVariableTableGen extends AttributeGen {

    /** The local variable table. */
    private Map<Integer, LocalVariableGen> localVariableTable;

    /** The local variable table 2. */
    private List<LocalVariableGen> localVariableTable2;

    /**
     * Instantiates a new local variable table gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public LocalVariableTableGen(LocalVariableTable attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.localVariableTable = new HashMap<>();
        this.localVariableTable2 = new ArrayList<>();
        Map<Integer, LocalVariable> map = attribute.getLocalVariableTable();
        map.keySet().stream().forEach(entry -> localVariableTable.put(entry, new LocalVariableGen(map.get(entry), constantPool)));
        map.keySet().stream().forEach(entry -> localVariableTable2.add(new LocalVariableGen(map.get(entry), constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    /**
     * Gets the local variable.
     *
     * @param index the index
     * @param pc    the pc
     * @return the local variable
     */
    public LocalVariableGen getLocalVariable(final int index, final int pc) {
        for (final LocalVariableGen variable : localVariableTable2) {
            if (variable.getSlot() == index) {
                final int start_pc = variable.getStart();
                final int end_pc = start_pc + variable.getLength();
                if ((pc >= start_pc) && (pc <= end_pc)) {
                    return variable;
                }
            }
        }
        return null;
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    @Override
    public void printUsefulData(PrintStream out) {
        out.println("Local Variable Table");
        for (Integer index : getLocalVariableTable().keySet()) {
            out.println("   " + getLocalVariableTable().get(index).toString());
        }
    }
}
