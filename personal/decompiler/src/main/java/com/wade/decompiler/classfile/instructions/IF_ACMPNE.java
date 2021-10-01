package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class IF_ACMPNE.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class IF_ACMPNE extends Instruction {
    /** The index. */
    private Short index;

    /**
     * Instantiates a new if acmpne.
     */
    public IF_ACMPNE() {
        super(InstructionOpCodes.IF_ACMPNE, 3);
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    protected void initFromFile(ByteSequence bytes) throws IOException {
        index = bytes.readShort();
    }

    /**
     * Negate.
     *
     * @return the instruction
     */
    public Instruction negate() {
        return new IF_ACMPEQ();
    }
}
