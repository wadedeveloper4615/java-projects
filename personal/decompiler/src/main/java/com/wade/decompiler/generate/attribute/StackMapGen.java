package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.StackMap;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class StackMapGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class StackMapGen extends AttributeGen {
    /** The map. */
    private List<StackMapEntryGen> map;

    /**
     * Instantiates a new stack map gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public StackMapGen(StackMap attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.map = new ArrayList<>();
        attribute.getMap().stream().forEach(entry -> this.map.add(new StackMapEntryGen(entry, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("Stack Map Table");
        for (StackMapEntryGen lvg : getMap()) {
            out.println("   " + lvg.toString());
        }
    }
}
