package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantString.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantString extends Constant {
    /** The string index. */
    private Integer stringIndex;

    /**
     * Instantiates a new constant string.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantString(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_String);
	this.stringIndex = file.readUnsignedShort();
    }
}
