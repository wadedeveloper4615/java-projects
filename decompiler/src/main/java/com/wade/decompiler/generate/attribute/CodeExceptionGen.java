package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.CodeException;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class CodeExceptionGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class CodeExceptionGen {
    /** The from. */
    private Integer from;
    /** The to. */
    private Integer to;
    /** The target. */
    private Integer target;
    /** The type. */
    private String type;

    /**
     * Instantiates a new code exception gen.
     *
     * @param entry        the entry
     * @param constantPool the constant pool
     */
    public CodeExceptionGen(CodeException entry, ConstantPool constantPool) {
	this.from = entry.getFrom();
	this.to = entry.getTo();
	this.target = entry.getTarget();
	this.type = constantPool.constantToString(entry.getType(), ClassFileConstants.CONSTANT_Class);
    }
}
