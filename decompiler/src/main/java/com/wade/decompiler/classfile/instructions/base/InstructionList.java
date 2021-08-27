package com.wade.decompiler.classfile.instructions.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.util.ByteArray;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InstructionList.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class InstructionList {
    /** The instructions. */
    private List<Instruction> instructions = new ArrayList<>();

    /**
     * Instantiates a new instruction list.
     *
     * @param code         the code
     * @param constantPool the constant pool
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InstructionList(ByteArray code, ConstantPool constantPool) throws IOException {
        try (ByteSequence bytes = new ByteSequence(code.getArray())) {
            int offset = 0;
            while (bytes.available() > 0) {
                Instruction instruction = InstructionFactory.readInstruction(bytes, offset);
                // System.out.println(instruction.toString());
                instructions.add(instruction);
                offset += instruction.getLength();
            }
        }
    }
}
