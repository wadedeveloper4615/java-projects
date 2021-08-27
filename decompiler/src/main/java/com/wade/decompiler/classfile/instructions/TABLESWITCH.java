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
 * The Class TABLESWITCH.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TABLESWITCH extends Instruction {
    /** The match. */
    protected Integer[] match;
    /** The offsets. */
    protected Integer[] offsets;
    /** The padding. */
    protected Integer padding = 0;
    /** The default offset. */
    protected Integer defaultOffset;

    /**
     * Instantiates a new tableswitch.
     *
     * @param match the match
     */
    public TABLESWITCH(Integer[] match) {
        super(InstructionOpCodes.TABLESWITCH, 3);
        this.match = match;
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    protected void initFromFile(ByteSequence bytes) throws IOException {
        padding = (4 - (bytes.getIndex() % 4)) % 4;
        System.out.println("padding=" + padding);
        for (int i = 0; i < padding; i++) {
            bytes.readByte();
        }
        this.defaultOffset = bytes.readInt();
        System.out.println("defaultOffset=" + defaultOffset);
        int low = bytes.readInt();
        System.out.println("low=" + low);
        int high = bytes.readInt();
        System.out.println("high=" + high);
        int matchlength = high - low + 1;
        System.out.println("matchlength=" + matchlength);
        int fixedlength = (13 + matchlength * 4);
        System.out.println("fixedlength=" + fixedlength);
        this.length = fixedlength + getPadding();
        this.match = new Integer[matchlength];
        this.offsets = new Integer[matchlength];
        for (int i = 0; i < matchlength; i++) {
            match[i] = low + i;
            offsets[i] = bytes.readInt();
        }
    }
}
