package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantMethodref.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantMethodref extends ConstantCP {
    /**
     * Instantiates a new constant methodref.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantMethodref(DataInput input) throws IOException {
	super(ClassFileConstants.CONSTANT_Methodref, input);
    }
}
