package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.NestMembers;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class NestMembersGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class NestMembersGen extends AttributeGen {
    /** The names. */
    private List<String> names;

    /**
     * Instantiates a new nest members gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public NestMembersGen(NestMembers attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.names = new ArrayList<>();
        attribute.getClasses().stream().forEach(entry -> this.names.add(constantPool.constantToString(entry, ClassFileConstants.CONSTANT_Class)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
