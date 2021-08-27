package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ModuleProvides;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModuleProvidesGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModuleProvidesGen {
    /** The provides index. */
    private List<String> providesIndex;
    /** The interface name. */
    private String interfaceName;

    /**
     * Instantiates a new module provides gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModuleProvidesGen(ModuleProvides attribute, ConstantPool constantPool) {
	this.interfaceName = constantPool.constantToString(attribute.getProvidesIndex(), ClassFileConstants.CONSTANT_Class);
	this.providesIndex = new ArrayList<>();
	attribute.getProvidesWithIndex().stream().forEach(entry -> this.providesIndex.add(constantPool.constantToString(entry, ClassFileConstants.CONSTANT_Class)));
    }
}
