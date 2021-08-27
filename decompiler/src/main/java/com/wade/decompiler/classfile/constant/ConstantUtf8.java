package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantUtf8.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantUtf8 extends Constant {
    /** The bytes. */
    private String bytes;

    /**
     * Instantiates a new constant utf 8.
     *
     * @param dataInput the data input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantUtf8(DataInput dataInput) throws IOException {
	super(ClassFileConstants.CONSTANT_Utf8);
	this.bytes = dataInput.readUTF();
    }
}
