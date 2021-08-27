/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.Map;
import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.ASTORE;
import com.wade.decompiler.classfile.instructions.DSTORE;
import com.wade.decompiler.classfile.instructions.FSTORE;
import com.wade.decompiler.classfile.instructions.ISTORE;
import com.wade.decompiler.classfile.instructions.LSTORE;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.attribute.LocalVariableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTypeTableGen;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class StoreGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class StoreGen extends InstructionGen {

    /** The opcode. */
    private InstructionOpCodes opcode;

    /** The local variable reference. */
    private LocalVariableGen localVariableReference;

    /**
     * Instantiates a new store gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public StoreGen(int offset, ASTORE instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new store gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public StoreGen(int offset, DSTORE instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new store gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public StoreGen(int offset, FSTORE instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new store gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public StoreGen(int offset, ISTORE instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        Integer index = instr.getIndex();
        getReference(localVariableTable, localVariableTypeTable, index);
    }

    /**
     * Instantiates a new store gen.
     *
     * @param offset                 the offset
     * @param instr                  the instr
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param cp                     the cp
     */
    public StoreGen(int offset, LSTORE instr, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
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
//        Expression op1 = stack.pop();
//        TypeSignature type = new TypeSignature(this.localVariableReference.getSignature(), false);
//        String name = String.format("%s %s=%s;", type.getType().replace("/", "."), this.localVariableReference.getName(), op1.getName());
//        return "\t\t" + name;
        return super.decompile(stack);
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
