package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantCP.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class ConstantCP extends Constant {
    /** The class index. */
    protected int classIndex;
    /** The name and type index. */
    protected int nameAndTypeIndex;

    /**
     * Instantiates a new constant CP.
     *
     * @param tag  the tag
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantCP(ClassFileConstants tag, DataInput file) throws IOException {
	super(tag);
	this.classIndex = file.readUnsignedShort();
	this.nameAndTypeIndex = file.readUnsignedShort();
    }
}
