package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantModule.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantModule extends Constant {
    /** The name index. */
    private Integer nameIndex;

    /**
     * Instantiates a new constant module.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantModule(DataInput file) throws IOException {
	super(ClassFileConstants.CONSTANT_Module);
	this.nameIndex = file.readUnsignedShort();
    }
}
