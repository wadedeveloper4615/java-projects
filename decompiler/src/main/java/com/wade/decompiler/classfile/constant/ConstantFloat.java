package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;
import java.math.BigDecimal;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantFloat.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantFloat extends Constant {
    /** The bytes. */
    private BigDecimal bytes;

    /**
     * Instantiates a new constant float.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantFloat(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_Float);
	this.bytes = new BigDecimal(file.readFloat());
    }
}
