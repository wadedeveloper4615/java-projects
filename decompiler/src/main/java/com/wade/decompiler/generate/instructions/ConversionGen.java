package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.D2F;
import com.wade.decompiler.classfile.instructions.D2I;
import com.wade.decompiler.classfile.instructions.D2L;
import com.wade.decompiler.classfile.instructions.F2D;
import com.wade.decompiler.classfile.instructions.F2I;
import com.wade.decompiler.classfile.instructions.F2L;
import com.wade.decompiler.classfile.instructions.I2B;
import com.wade.decompiler.classfile.instructions.I2C;
import com.wade.decompiler.classfile.instructions.I2D;
import com.wade.decompiler.classfile.instructions.I2F;
import com.wade.decompiler.classfile.instructions.I2L;
import com.wade.decompiler.classfile.instructions.I2S;
import com.wade.decompiler.classfile.instructions.L2D;
import com.wade.decompiler.classfile.instructions.L2F;
import com.wade.decompiler.classfile.instructions.L2I;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ConversionGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ConversionGen extends InstructionGen {
    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, D2F instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, D2I instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, D2L instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, F2D instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, F2I instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, F2L instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, I2B instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, I2C instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, I2D instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, I2F instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, I2L instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, I2S instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, L2D instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, L2F instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new conversion gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConversionGen(int offset, L2I instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }
}
