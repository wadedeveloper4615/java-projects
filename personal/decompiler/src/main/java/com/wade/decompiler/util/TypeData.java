package com.wade.decompiler.util;

import com.wade.decompiler.enums.TypeEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class TypeData.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class TypeData {
    /** The base type. */
    private TypeEnum baseType;
    /** The index type. */
    private TypeEnum indexType;
    /** The reference. */
    private String reference;
    /** The name. */
    private String name;
    /** The type list. */
    private String typeList;

    /**
     * Instantiates a new type data.
     *
     * @param baseType  the base type
     * @param indexType the index type
     */
    public TypeData(TypeEnum baseType, TypeEnum indexType) {
	this.baseType = baseType;
	this.indexType = indexType;
    }

    /**
     * Instantiates a new type data.
     *
     * @param baseType  the base type
     * @param indexType the index type
     * @param reference the reference
     * @param typeList  the type list
     * @param name      the name
     */
    public TypeData(TypeEnum baseType, TypeEnum indexType, String reference, String typeList, String name) {
	this.baseType = baseType;
	this.indexType = indexType;
	this.reference = reference;
	this.name = name;
	this.typeList = typeList;
    }
}
