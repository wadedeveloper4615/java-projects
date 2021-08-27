package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ALOAD.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ALOAD extends Instruction {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new aload.
     */
    public ALOAD() {
        super(InstructionOpCodes.ALOAD, 1);
        this.index = -1;
    }

    /**
     * Instantiates a new aload.
     *
     * @param index the index
     */
    public ALOAD(int index) {
        super(InstructionOpCodes.ALOAD_0.add(index), 1);
        this.index = index;
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
            index = bytes.readUnsignedShort();
            this.length = 4;
        } else {
            index = null;
            super.setLength(null);
            final InstructionOpCodes opcode = super.getOpcode();
            if (opcode == InstructionOpCodes.ALOAD) {
                index = bytes.readUnsignedByte();
                super.setLength(2);
            } else if (opcode == InstructionOpCodes.ALOAD_0) {
                index = 0;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.ALOAD_1) {
                index = 1;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.ALOAD_2) {
                index = 2;
                super.setLength(1);
            } else {
                index = 3;
                super.setLength(1);
            }
        }
    }
}
