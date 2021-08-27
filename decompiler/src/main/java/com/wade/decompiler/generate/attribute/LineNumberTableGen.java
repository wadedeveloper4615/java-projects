package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.LineNumberTable;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LineNumberTableGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class LineNumberTableGen extends AttributeGen {
    /** The line number table. */
    private List<LineNumberGen> lineNumberTable;

    /**
     * Instantiates a new line number table gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public LineNumberTableGen(LineNumberTable attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        lineNumberTable = new ArrayList<>();
        attribute.getLineNumberTable().stream().forEach(entry -> lineNumberTable.add(new LineNumberGen(entry)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("Line Number Table:");
        for (LineNumberGen lvg : getLineNumberTable()) {
            out.println("   " + lvg.toString());
        }
    }
}
