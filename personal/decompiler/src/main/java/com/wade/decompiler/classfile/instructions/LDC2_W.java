package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class LDC2_W.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class LDC2_W extends Instruction {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new ldc2 w.
     */
    public LDC2_W() {
        super(InstructionOpCodes.LDC2_W, 1);
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
        this.wide = true;
    }
}
