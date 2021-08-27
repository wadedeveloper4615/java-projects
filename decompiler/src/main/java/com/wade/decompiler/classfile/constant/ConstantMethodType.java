package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantMethodType.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantMethodType extends Constant {
    /** The descriptor index. */
    private Integer descriptorIndex;

    /**
     * Instantiates a new constant method type.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantMethodType(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_MethodType);
	this.descriptorIndex = file.readUnsignedShort();
    }
}
