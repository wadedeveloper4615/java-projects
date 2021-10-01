package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ModuleOpens;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModuleOpensGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModuleOpensGen {
    /** The package name. */
    private String package_name;
    /** The opens to index. */
    private List<String> opensToIndex;
    /** The opens flags. */
    private ClassAccessFlagsList opensFlags;

    /**
     * Instantiates a new module opens gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModuleOpensGen(ModuleOpens attribute, ConstantPool constantPool) {
	this.package_name = constantPool.constantToString(attribute.getOpensIndex(), ClassFileConstants.CONSTANT_Package);
	this.opensFlags = new ClassAccessFlagsList(attribute.getOpensFlags());
	this.opensToIndex = new ArrayList<>();
	attribute.getOpensToIndex().stream().forEach(entry -> this.opensToIndex.add(constantPool.constantToString(entry, ClassFileConstants.CONSTANT_Module)));
    }
}
