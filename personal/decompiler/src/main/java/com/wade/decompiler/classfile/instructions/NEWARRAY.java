package com.wade.decompiler.classfile.instructions;

import java.io.IOException;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.enums.TypeEnum;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class NEWARRAY.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class NEWARRAY extends Instruction {
    /** The type. */
    private TypeEnum type;

    /**
     * Instantiates a new newarray.
     */
    public NEWARRAY() {
        super(InstructionOpCodes.NEWARRAY, 2);
    }

    /**
     * Instantiates a new newarray.
     *
     * @param type the type
     */
    public NEWARRAY(TypeEnum type) {
        super(InstructionOpCodes.NEWARRAY, 2);
    }

    /**
     * Inits the from file.
     *
     * @param bytes the bytes
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void initFromFile(ByteSequence bytes) throws IOException {
        this.type = TypeEnum.read(bytes.readByte());
        this.length = 2;
    }
}
