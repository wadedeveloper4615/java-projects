package com.wade.decompiler.classfile.element;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ClassElementValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ClassElementValue extends ElementValue {
    /** The idx. */
    private Integer idx;

    /**
     * Instantiates a new class element value.
     *
     * @param type the type
     * @param idx  the idx
     */
    public ClassElementValue(int type, int idx) {
	super(type);
	this.idx = idx;
    }
}
