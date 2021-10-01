package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantClass.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantClass extends Constant {
    /** The name index. */
    private Integer nameIndex;

    /**
     * Instantiates a new constant class.
     *
     * @param dataInput the data input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantClass(DataInput dataInput) throws IOException {
	super(ClassFileConstants.CONSTANT_Class);
	this.nameIndex = dataInput.readUnsignedShort();
    }
}
