package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.ModuleRequires;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModuleRequiresGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModuleRequiresGen {
    /** The requires version. */
    private String requiresVersion;
    /** The requires flags. */
    private ClassAccessFlagsList requiresFlags;
    /** The module name. */
    private String moduleName;

    /**
     * Instantiates a new module requires gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModuleRequiresGen(ModuleRequires attribute, ConstantPool constantPool) {
        this.moduleName = constantPool.constantToString(attribute.getRequiresIndex(), ClassFileConstants.CONSTANT_Module);
        this.requiresFlags = new ClassAccessFlagsList(attribute.getRequiresFlags());
        if (attribute.getRequiresVersionIndex() != 0) {
            this.requiresVersion = constantPool.constantToString(attribute.getRequiresVersionIndex(), ClassFileConstants.CONSTANT_Utf8);
        }
    }
}
