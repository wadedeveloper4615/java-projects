/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ItemNamesEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class StackMapType.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class StackMapType {

    /** The type. */
    private Byte type;

    /** The index. */
    private Integer index;

    /** The name. */
    private String name;

    /**
     * Instantiates a new stack map type.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public StackMapType(DataInput file) throws IOException {
        this.type = file.readByte();
        this.index = -1;
        if (type < ItemNamesEnum.ITEM_Bogus.getTag() || type > ItemNamesEnum.ITEM_NewObject.getTag()) {
            throw new IllegalArgumentException("Illegal type for StackMapType: " + type);
        }
        if (hasIndex()) {
            this.index = Integer.valueOf(file.readShort());
        }
    }

    /**
     * Checks for index.
     *
     * @return true, if successful
     */
    public boolean hasIndex() {
        return type == ItemNamesEnum.ITEM_Object.getTag() || type == ItemNamesEnum.ITEM_NewObject.getTag();
    }
}
