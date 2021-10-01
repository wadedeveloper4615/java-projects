package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class IFLT.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class IFLT extends Instruction {
    /** The index. */
    private Short index;

    /**
     * Instantiates a new iflt.
     */
    public IFLT() {
        super(InstructionOpCodes.IFLT, 3);
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
        return new IFGE();
    }
}
