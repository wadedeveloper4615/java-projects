package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.BootstrapMethod;
import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class BootstrapMethodGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class BootstrapMethodGen {
    /** The bootstrap method name. */
    private String bootstrapMethodName;
    /** The bootstrap arguments. */
    private List<String> bootstrapArguments;

    /**
     * Instantiates a new bootstrap method gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public BootstrapMethodGen(BootstrapMethod attribute, ConstantPool constantPool) {
	bootstrapMethodName = constantPool.constantToString(attribute.getBootstrapMethodRef(), ClassFileConstants.CONSTANT_MethodHandle);
	this.bootstrapArguments = new ArrayList<>();
	attribute.getBootstrapArguments().stream().forEach(entry -> {
	    Constant c = constantPool.getConstant(entry);
	    String cp = constantPool.constantToString(c);
	    bootstrapArguments.add(cp);
	});
    }
}
