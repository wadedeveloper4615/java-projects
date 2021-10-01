package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantInvokeDynamic.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantInvokeDynamic extends ConstantCP {
    /**
     * Instantiates a new constant invoke dynamic.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantInvokeDynamic(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_InvokeDynamic, file);
    }
}
