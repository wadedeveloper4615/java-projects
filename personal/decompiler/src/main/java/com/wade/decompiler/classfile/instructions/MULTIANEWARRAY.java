package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class MULTIANEWARRAY.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class MULTIANEWARRAY extends Instruction {
    /** The dimensions. */
    private Byte dimensions;
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new multianewarray.
     */
    public MULTIANEWARRAY() {
        super(InstructionOpCodes.MULTIANEWARRAY, 3);
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
        this.index = bytes.readUnsignedShort();
        this.dimensions = bytes.readByte();
        this.length = 4;
        if (dimensions < 1) {
            throw new ClassGenException("Invalid dimensions value: " + dimensions);
        }
    }
}
