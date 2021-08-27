package com.wade.decompiler.classfile.element;

import com.wade.decompiler.classfile.attribute.AnnotationEntry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AnnotationElementValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AnnotationElementValue extends ElementValue {
    /** The annotation entry. */
    private AnnotationEntry annotationEntry;

    /**
     * Instantiates a new annotation element value.
     *
     * @param type            the type
     * @param annotationEntry the annotation entry
     */
    public AnnotationElementValue(int type, AnnotationEntry annotationEntry) {
	super(type);
	if (type != ANNOTATION) {
	    throw new IllegalArgumentException("Only element values of type annotation can be built with this ctor - type specified: " + type);
	}
	this.annotationEntry = annotationEntry;
    }
}
