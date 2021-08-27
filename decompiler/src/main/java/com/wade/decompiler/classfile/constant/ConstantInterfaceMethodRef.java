package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantInterfaceMethodRef.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantInterfaceMethodRef extends ConstantCP {
    /**
     * Instantiates a new constant interface method ref.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantInterfaceMethodRef(DataInput input) throws IOException {
	super(ClassFileConstants.CONSTANT_InterfaceMethodref, input);
    }
}
