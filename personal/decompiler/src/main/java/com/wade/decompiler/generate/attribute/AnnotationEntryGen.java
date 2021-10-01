package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.AnnotationEntry;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AnnotationEntryGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AnnotationEntryGen {
    /** The element value pairs. */
    private List<ElementValuePairGen> elementValuePairs;
    /** The type index. */
    private Integer typeIndex;
    /** The is runtime visible. */
    private Boolean isRuntimeVisible;

    /**
     * Instantiates a new annotation entry gen.
     *
     * @param annotationEntry the annotation entry
     */
    public AnnotationEntryGen(AnnotationEntry annotationEntry) {
	this.typeIndex = annotationEntry.getTypeIndex();
	this.isRuntimeVisible = annotationEntry.getIsRuntimeVisible();
    }

    /**
     * Read.
     *
     * @param ae           the ae
     * @param constantPool the constant pool
     * @return the annotation entry gen
     */
    public static AnnotationEntryGen read(AnnotationEntry ae, ConstantPool constantPool) {
	AnnotationEntryGen annotationEntry = new AnnotationEntryGen(ae);
	if (annotationEntry.elementValuePairs == null) {
	    annotationEntry.elementValuePairs = new ArrayList<>();
	}
	annotationEntry.elementValuePairs = new ArrayList<ElementValuePairGen>();
	ae.getElementValuePairs().stream().forEach(entry -> annotationEntry.elementValuePairs.add(new ElementValuePairGen(entry, ElementValueGen.readElementValue(entry.getElementValue(), constantPool), constantPool)));
	return annotationEntry;
    }
}
