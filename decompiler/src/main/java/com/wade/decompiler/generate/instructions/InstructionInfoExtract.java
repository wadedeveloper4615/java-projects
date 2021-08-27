/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTypeTableGen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class InstructionInfoExtract.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class InstructionInfoExtract {
    /** The instructions extracted. */
    private LinkedList<InstructionGen> instructionsExtracted;

    /**
     * Instantiates a new instruction info extract.
     *
     * @param instructions           the instructions
     * @param localVariableTable     the local variable table
     * @param localVariableTypeTable the local variable type table
     * @param constantPool           the constant pool
     */
    public InstructionInfoExtract(List<Instruction> instructions, LocalVariableTableGen localVariableTable, LocalVariableTypeTableGen localVariableTypeTable, ConstantPool constantPool) {
        int offset = 0;
        LinkedList<InstructionGen> temp = new LinkedList<>();
        for (Instruction instr : instructions) {
            InstructionGen instruction = InstructionGen.read(offset, instr, localVariableTable, localVariableTypeTable, constantPool);
            temp.add(instruction);
            offset += instr.getLength();
        }
        this.instructionsExtracted = processBlock(temp);
//        this.instructionsExtracted = temp;
    }

    protected InstructionGen getOffsetPevious(int offset, LinkedList<InstructionGen> instructionsExtracted) {
        InstructionGen result = null;
        ListIterator<InstructionGen> iterator = instructionsExtracted.listIterator();
        while (iterator.hasNext()) {
            InstructionGen current = iterator.next();
            if (current.getOffset() == offset) {
                iterator.previous();
                result = iterator.previous();
                break;
            }
        }
        return result;
    }

    public LinkedList<InstructionGen> markInstructionsPartOfIfBlock(LinkedList<InstructionGen> temp) {
        LinkedList<InstructionGen> ig1 = new LinkedList<>();
        CompareGen is = null;
        boolean ifFound = false;
        for (InstructionGen instr : temp) {
            if (instr.isIfStatement()) {
                is = (CompareGen) instr;
                ifFound = true;
                int offset = is.getIndex() + is.getOffset();
                InstructionGen last = getOffsetPevious(offset, temp);
                if (last != null) {
                    last.setEndIfStatement(true);
                }
            }
            instr.setIfStatement(ifFound);
            if (instr.isEndIfStatement()) {
                ifFound = false;
            }
            ig1.add(instr);
        }
        return ig1;
    }

    public LinkedList<InstructionGen> processBlock(LinkedList<InstructionGen> temp) {
        LinkedList<InstructionGen> ig1 = markInstructionsPartOfIfBlock(temp);
        LinkedList<InstructionGen> ig2 = new LinkedList<>();
        CompareGen is = null;
        for (InstructionGen instr : ig1) {
            if (instr instanceof CompareGen) {
                is = (CompareGen) instr;
                ig2.add(instr);
            } else if (is != null && instr.isIfStatement()) {
                is.getThenBlock().add(instr);
            } else {
                ig2.add(instr);
            }
        }
        return ig2;
    }
}
