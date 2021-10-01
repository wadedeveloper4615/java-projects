/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.Map;
import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.ALOAD;
import com.wade.decompiler.classfile.instructions.DLOAD;
import com.wade.decompiler.classfile.instructions.FLOAD;
import com.wade.decompiler.classfile.instructions.ILOAD;
import com.wade.decompiler.classfile.instructions.LLOAD;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.attribute.LocalVariableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTypeTableGen;
import com.wade.decompiler.generate.statement.LoadStatement;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class LoadGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class LoadGen extends InstructionGen {

    /** The opcode. */
    private InstructionOpCodes opcode;

    /** The local variable reference. */
    private LocalVariableGen localVariableReference;

    /**
     * Instantiates a new load gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public LoadGen(int offset, ALOAD instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new load gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public LoadGen(int offset, DLOAD instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new load gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public LoadGen(int offset, FLOAD instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new load gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public LoadGen(int offset, ILOAD instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new load gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public LoadGen(int offset, LLOAD instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        localVariableReference = null;
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    @Override
    public Statement decompile(Stack<Statement> stack) {
        String name = localVariableReference.getName();
        String signature = localVariableReference.getSignature();
        String comment = String.format("pushing '%s' type= '%s'", name, signature);
        stack.push(new LoadStatement().comment(comment).name(name).signature(signature));
        return null;
    }

    /**
     * Gets the reference.
     *
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param index                  the index
     */
    public void getReference(LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, Integer index) {
        Map<Integer, LocalVariableGen> localVariableMap;
        if (localVariableTypeTable == null || index == 0) {
            localVariableMap = localVariableTable.getLocalVariableTable();
        } else {
            localVariableMap = localVariableTypeTable.getLocalVariableTypeTable();
        }
        localVariableReference = localVariableMap.get(index);
    }
}
