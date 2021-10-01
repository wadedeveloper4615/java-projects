package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.Annotations;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AnnotationsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AnnotationsGen extends AttributeGen {
    /** The is runtime visible. */
    private Boolean isRuntimeVisible;
    /** The annotation table. */
    private List<AnnotationEntryGen> annotationTable;

    /**
     * Instantiates a new annotations gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public AnnotationsGen(Annotations attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.isRuntimeVisible = attribute.getIsRuntimeVisible();
        this.annotationTable = new ArrayList<>();
        attribute.getAnnotationTable().stream().forEach(annotation -> annotationTable.add(AnnotationEntryGen.read(annotation, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("\n\t" + toString());
    }
}
