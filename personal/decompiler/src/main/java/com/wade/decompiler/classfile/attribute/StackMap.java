/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class StackMap.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class StackMap extends Attribute {

    /** The map. */
    private final List<StackMapEntry> map;

    /**
     * Instantiates a new stack map.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public StackMap(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_STACK_MAP, nameIndex, length);
        int map_length = input.readUnsignedShort();
        map = new ArrayList<>();
        for (int i = 0; i < map_length; i++) {
            map.add(new StackMapEntry(input));
        }
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
