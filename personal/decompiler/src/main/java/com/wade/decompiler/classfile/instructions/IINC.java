package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class IINC.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class IINC extends Instruction {
    /** The increment. */
    private Short increment;
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new iinc.
     */
    public IINC() {
        super(InstructionOpCodes.IINC, 3);
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void initFromFile(ByteSequence bytes) throws IOException {
        if (wide) {
            this.length = 6;
            index = bytes.readUnsignedShort();
            increment = bytes.readShort();
        } else {
            this.length = 3;
            index = bytes.readUnsignedByte();
            increment = (short) bytes.readByte();
        }
    }
}
