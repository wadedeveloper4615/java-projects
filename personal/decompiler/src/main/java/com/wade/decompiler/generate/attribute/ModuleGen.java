package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.Module;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModuleGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModuleGen extends AttributeGen {
    /** The module name. */
    private String moduleName;
    /** The module version. */
    private String moduleVersion;
    /** The module flags. */
    private ClassAccessFlagsList moduleFlags;
    /** The requires table. */
    private List<ModuleRequiresGen> requiresTable;
    /** The exports table. */
    private List<ModuleExportsGen> exportsTable;
    /** The opens table. */
    private List<ModuleOpensGen> opensTable;
    /** The uses index. */
    private List<String> usesIndex;
    /** The provides table. */
    private List<ModuleProvidesGen> providesTable;

    /**
     * Instantiates a new module gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModuleGen(Module attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.moduleName = constantPool.constantToString(attribute.getModuleNameIndex(), ClassFileConstants.CONSTANT_Module);
        this.moduleVersion = constantPool.constantToString(attribute.getModuleVersionIndex(), ClassFileConstants.CONSTANT_Utf8);
        this.moduleFlags = new ClassAccessFlagsList(attribute.getModuleFlags());
        this.requiresTable = new ArrayList<>();
        attribute.getRequiresTable().stream().forEach(entry -> this.requiresTable.add(new ModuleRequiresGen(entry, constantPool)));
        this.exportsTable = new ArrayList<>();
        attribute.getExportsTable().stream().forEach(entry -> this.exportsTable.add(new ModuleExportsGen(entry, constantPool)));
        this.opensTable = new ArrayList<>();
        attribute.getOpensTable().stream().forEach(entry -> this.opensTable.add(new ModuleOpensGen(entry, constantPool)));
        this.usesIndex = new ArrayList<>();
        attribute.getUsesIndex().stream().forEach(entry -> {
            if (entry >= 0) {
                this.usesIndex.add(constantPool.constantToString(entry));
            }
        });
        this.providesTable = new ArrayList<>();
        attribute.getProvidesTable().stream().forEach(entry -> this.providesTable.add(new ModuleProvidesGen(entry, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
