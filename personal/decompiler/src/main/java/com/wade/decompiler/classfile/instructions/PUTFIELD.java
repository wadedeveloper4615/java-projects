package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class PUTFIELD.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class PUTFIELD extends Instruction {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new putfield.
     */
    public PUTFIELD() {
        super(InstructionOpCodes.PUTFIELD, 3);
        index = -1;
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    protected void initFromFile(ByteSequence bytes) throws IOException {
        this.index = bytes.readUnsignedShort();
        this.length = 3;
    }
}
