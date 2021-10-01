package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantDynamic.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantDynamic extends ConstantCP {
    /**
     * Instantiates a new constant dynamic.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantDynamic(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_Dynamic, file);
    }
}
