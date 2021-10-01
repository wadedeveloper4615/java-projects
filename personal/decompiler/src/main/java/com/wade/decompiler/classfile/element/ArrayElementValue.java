package com.wade.decompiler.classfile.element;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ArrayElementValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ArrayElementValue extends ElementValue {
    /** The element values. */
    private List<ElementValue> elementValues;

    /**
     * Instantiates a new array element value.
     *
     * @param type   the type
     * @param datums the datums
     */
    public ArrayElementValue(int type, List<ElementValue> datums) {
	super(type);
	if (type != ARRAY) {
	    throw new IllegalArgumentException("Only element values of type array can be built with this ctor - type specified: " + type);
	}
	this.elementValues = datums;
    }
}
