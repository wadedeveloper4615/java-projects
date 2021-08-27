package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantNameAndType.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantNameAndType extends Constant {
    /** The name index. */
    private Integer nameIndex;
    /** The signature index. */
    private Integer signatureIndex;

    /**
     * Instantiates a new constant name and type.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantNameAndType(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_NameAndType);
	this.nameIndex = file.readUnsignedShort();
	this.signatureIndex = file.readUnsignedShort();
    }
}
