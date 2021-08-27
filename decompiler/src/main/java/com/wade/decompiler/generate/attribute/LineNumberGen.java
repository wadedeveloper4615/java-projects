package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.LineNumber;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LineNumberGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class LineNumberGen {
    /** The start. */
    private Short start;
    /** The line number. */
    private Short lineNumber;

    /**
     * Instantiates a new line number gen.
     *
     * @param attribute the attribute
     */
    public LineNumberGen(LineNumber attribute) {
	this.start = attribute.getStartPc();
	this.lineNumber = attribute.getLineNumber();
    }
}
