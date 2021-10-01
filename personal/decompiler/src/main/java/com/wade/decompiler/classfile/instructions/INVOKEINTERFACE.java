package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class INVOKEINTERFACE.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class INVOKEINTERFACE extends Instruction {
    /** The index. */
    private Integer index;
    /** The nargs. */
    private Integer nargs;

    /**
     * Instantiates a new invokeinterface.
     */
    public INVOKEINTERFACE() {
        super(InstructionOpCodes.INVOKEINTERFACE, 5);
        this.length = 5;
        index = -1;
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void initFromFile(ByteSequence bytes) throws IOException {
        this.length = 5;
        this.index = bytes.readUnsignedShort();
        this.nargs = bytes.readUnsignedByte();
        bytes.readByte();
    }
}
