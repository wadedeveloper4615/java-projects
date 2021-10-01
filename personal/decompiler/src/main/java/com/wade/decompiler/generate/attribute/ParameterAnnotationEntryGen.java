package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ParameterAnnotationEntry;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ParameterAnnotationEntryGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ParameterAnnotationEntryGen {
    /** The annotation table. */
    private List<AnnotationEntryGen> annotationTable;

    /**
     * Instantiates a new parameter annotation entry gen.
     *
     * @param parameterAnnotationEntry the parameter annotation entry
     * @param constantPool             the constant pool
     */
    public ParameterAnnotationEntryGen(ParameterAnnotationEntry parameterAnnotationEntry, ConstantPool constantPool) {
        this.annotationTable = new ArrayList<>();
        parameterAnnotationEntry.getAnnotationTable().stream().forEach(entry -> this.annotationTable.add(AnnotationEntryGen.read(entry, constantPool)));
    }
//
//    /**
//     * Creates the parameter annotation entries.
//     *
//     * @param attrs the attrs
//     * @return the parameter annotation entry gen[]
//     */
//    public static ParameterAnnotationEntryGen[] createParameterAnnotationEntries(AttributeGen[] attrs) {
//	List<ParameterAnnotationEntryGen> accumulatedAnnotations = new ArrayList<>(attrs.length);
//	for (AttributeGen attribute : attrs) {
//	    if (attribute instanceof ParameterAnnotationsGen) {
//		ParameterAnnotationsGen runtimeAnnotations = (ParameterAnnotationsGen) attribute;
//		accumulatedAnnotations.addAll(runtimeAnnotations.getParameterAnnotationTable());
//	    }
//	}
//	return accumulatedAnnotations.toArray(new ParameterAnnotationEntryGen[accumulatedAnnotations.size()]);
//    }
}
