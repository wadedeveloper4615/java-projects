package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class CHECKCAST.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CHECKCAST extends Instruction {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new checkcast.
     *
     * @param index the index
     */
    public CHECKCAST(int index) {
        super(InstructionOpCodes.CHECKCAST, 3);
        this.index = index;
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
