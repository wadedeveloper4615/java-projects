package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ISTORE.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ISTORE extends Instruction {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new istore.
     */
    public ISTORE() {
        super(InstructionOpCodes.ISTORE, 1);
    }

    /**
     * Instantiates a new istore.
     *
     * @param index the index
     */
    public ISTORE(int index) {
        super(InstructionOpCodes.ISTORE_0.add(index), 1);
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
            if (opcode == InstructionOpCodes.ISTORE) {
                index = bytes.readUnsignedByte();
                super.setLength(2);
            } else if (opcode == InstructionOpCodes.ISTORE_0) {
                index = 0;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.ISTORE_1) {
                index = 1;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.ISTORE_2) {
                index = 2;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.ISTORE_3) {
                index = 3;
                super.setLength(1);
            }
        }
    }
}
