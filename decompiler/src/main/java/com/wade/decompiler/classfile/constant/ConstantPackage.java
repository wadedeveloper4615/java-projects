package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantPackage.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantPackage extends Constant {
    /** The name index. */
    private Integer nameIndex;

    /**
     * Instantiates a new constant package.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantPackage(DataInput file) throws IOException {
	this(file.readUnsignedShort());
    }

    /**
     * Instantiates a new constant package.
     *
     * @param nameIndex the name index
     */
    public ConstantPackage(int nameIndex) {
	super(ClassFileConstants.CONSTANT_Package);
	this.nameIndex = nameIndex;
    }
}
