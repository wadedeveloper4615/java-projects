package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ExceptionTable;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ExceptionTableGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ExceptionTableGen extends AttributeGen {
    /** The names. */
    private List<String> names;

    /**
     * Instantiates a new exception table gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ExceptionTableGen(ExceptionTable attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        names = new ArrayList<>();
        attribute.getExceptionIndexTable().stream().forEach(entry -> this.names.add(constantPool.constantToString(entry, ClassFileConstants.CONSTANT_Class)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("\n\t" + toString());
    }
}
