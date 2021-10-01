package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.attribute.LocalVariableTable;
import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class LSTORE.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class LSTORE extends Instruction {
    /** The index. */
    private Integer index;
    /** The local variable table. */
    private LocalVariableTable localVariableTable;

    /**
     * Instantiates a new lstore.
     */
    public LSTORE() {
        super(InstructionOpCodes.LSTORE, 1);
    }

    /**
     * Instantiates a new lstore.
     *
     * @param index the index
     */
    public LSTORE(int index) {
        super(InstructionOpCodes.LSTORE_0.add(index), 1);
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
            if (opcode == InstructionOpCodes.LSTORE) {
                index = bytes.readUnsignedByte();
                super.setLength(2);
            } else if (opcode == InstructionOpCodes.LSTORE_0) {
                index = 0;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.LSTORE_1) {
                index = 1;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.LSTORE_2) {
                index = 2;
                super.setLength(1);
            } else if (opcode == InstructionOpCodes.LSTORE_3) {
                index = 3;
                super.setLength(1);
            }
        }
    }
}
