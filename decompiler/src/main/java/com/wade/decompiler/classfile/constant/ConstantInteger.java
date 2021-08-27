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
 * The Class ConstantInteger.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantInteger extends Constant {
    /** The bytes. */
    private BigDecimal bytes;

    /**
     * Instantiates a new constant integer.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantInteger(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_Integer);
	this.bytes = new BigDecimal(file.readInt());
    }
}
