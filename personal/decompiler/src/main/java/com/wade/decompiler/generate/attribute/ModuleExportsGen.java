package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ModuleExports;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModuleExportsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModuleExportsGen {
    /** The exports. */
    private List<String> exports;
    /** The package name. */
    private String package_name;
    /** The export flags. */
    private ClassAccessFlagsList exportFlags;

    /**
     * Instantiates a new module exports gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModuleExportsGen(ModuleExports attribute, ConstantPool constantPool) {
	this.package_name = constantPool.constantToString(attribute.getExportsIndex(), ClassFileConstants.CONSTANT_Package);
	this.exportFlags = new ClassAccessFlagsList(attribute.getExportsFlags());
	this.exports = new ArrayList<>();
	attribute.getExportsToIndex().stream().forEach(entry -> this.exports.add(constantPool.constantToString(entry, ClassFileConstants.CONSTANT_Module)));
    }
}
