package com.wade.decompiler.classfile.instructions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LOOKUPSWITCH.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class LOOKUPSWITCH extends Instruction {
    /** The match. */
    protected List<Integer> match;
    /** The offsets. */
    protected Integer[] offsets;
    /** The padding. */
    protected Integer padding;
    /** The default offset. */
    protected Integer defaultOffset;

    /**
     * Instantiates a new lookupswitch.
     *
     * @param match the match
     */
    public LOOKUPSWITCH(List<Integer> match) {
        super(InstructionOpCodes.LOOKUPSWITCH, 3);
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
        padding = (4 - (bytes.getIndex() % 4)) % 4; // Compute number of pad bytes
        for (int i = 0; i < padding; i++) {
            bytes.readByte();
        }
        this.defaultOffset = bytes.readInt() + 1;
        int matchlength = bytes.readInt();
        int fixedlength = (short) (9 + matchlength * 8);
        int length = fixedlength + 1;// (short) (matchlength + getPadding());
        this.length = length;
        this.match = new ArrayList<>();
        this.offsets = new Integer[matchlength];
        for (int i = 0; i < matchlength; i++) {
            match.add(bytes.readInt());
            offsets[i] = bytes.readInt();
        }
    }
}
