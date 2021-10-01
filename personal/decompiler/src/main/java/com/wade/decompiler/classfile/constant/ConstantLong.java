package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantLong.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantLong extends Constant {
    /** The bytes. */
    private Number bytes;

    /**
     * Instantiates a new constant long.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantLong(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_Long);
	this.bytes = file.readLong();
    }
}
