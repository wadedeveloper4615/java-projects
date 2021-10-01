package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.element.AnnotationElementValue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AnnotationElementValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AnnotationElementValueGen extends ElementValueGen {
    /** The annotation entry. */
    private AnnotationEntryGen annotationEntry;

    /**
     * Instantiates a new annotation element value gen.
     *
     * @param type  the type
     * @param value the value
     */
    public AnnotationElementValueGen(byte type, AnnotationElementValue value) {
	super(type);
	if (type != ANNOTATION) {
	    throw new IllegalArgumentException("Only element values of type annotation can be built with this ctor - type specified: " + type);
	}
	this.annotationEntry = new AnnotationEntryGen(value.getAnnotationEntry());
    }
}
