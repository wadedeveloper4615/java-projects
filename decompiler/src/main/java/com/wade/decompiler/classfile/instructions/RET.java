package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.constants.Const;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class RET.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class RET extends Instruction {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new ret.
     */
    public RET() {
        super(InstructionOpCodes.RET, 2);
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
            index = bytes.readUnsignedByte();
            this.length = 2;
        }
    }

    /**
     * Sets the index.
     *
     * @param n the new index
     */
    public void setIndex(int n) {
        if (n < 0) {
            throw new ClassGenException("Negative index value: " + n);
        }
        index = n;
        setWide();
    }

    /**
     * Sets the wide.
     */
    private void setWide() {
        wide = index > Const.MAX_BYTE;
        if (wide) {
            this.length = 4;
        } else {
            this.length = 2;
        }
    }
}
