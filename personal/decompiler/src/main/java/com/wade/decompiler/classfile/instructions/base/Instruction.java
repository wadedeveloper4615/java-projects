/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.instructions.base;

import java.io.IOException;
import java.io.PrintStream;

import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class Instruction.
 */
@Getter
@Setter
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Instruction {
    /** The offset. */
    protected Integer offset;
    /** The length. */
    protected Integer length;
    /** The opcode. */
    protected InstructionOpCodes opcode;
    /** The wide. */
    protected Boolean wide;

    /**
     * Instantiates a new instruction.
     *
     * @param opcode the opcode
     * @param length the length
     */
    public Instruction(InstructionOpCodes opcode, int length) {
        this.length = length;
        this.opcode = opcode;
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void initFromFile(ByteSequence bytes) throws IOException {
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
