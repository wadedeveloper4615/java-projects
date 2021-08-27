package com.wade.decompiler.classfile.element;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ElementValuePair.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ElementValuePair {
    /** The element value. */
    private ElementValue elementValue;
    /** The element name index. */
    private Integer elementNameIndex;

    /**
     * Instantiates a new element value pair.
     *
     * @param elementNameIndex the element name index
     * @param elementValue     the element value
     */
    public ElementValuePair(int elementNameIndex, ElementValue elementValue) {
	this.elementValue = elementValue;
	this.elementNameIndex = elementNameIndex;
    }
}
