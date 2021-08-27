package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantMethodHandle.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantMethodHandle extends Constant {
    /** The reference kind. */
    private Integer referenceKind;
    /** The reference index. */
    private Integer referenceIndex;

    /**
     * Instantiates a new constant method handle.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantMethodHandle(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_MethodHandle);
	this.referenceKind = file.readUnsignedByte();
	this.referenceIndex = file.readUnsignedShort();
    }
}
