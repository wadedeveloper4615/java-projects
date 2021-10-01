package com.wade.decompiler.enums;

/**
 * The Enum ItemNamesEnum.
 */
public enum ItemNamesEnum {
    /** The ITE M bogus. */
    //@formatter:off
    ITEM_Bogus(0),
 /** The ITE M integer. */
 ITEM_Integer(1),
 /** The ITE M float. */
 ITEM_Float(2),
 /** The ITE M double. */
 ITEM_Double(3),
 /** The ITE M long. */
 ITEM_Long(4),
 /** The ITE M null. */
 ITEM_Null(5),
 /** The ITE M init object. */
 ITEM_InitObject(6),
 /** The ITE M object. */
 ITEM_Object(7),
 /** The ITE M new object. */
 ITEM_NewObject(8);

    /**
     * Read.
     *
     * @param type the type
     * @return the item names enum
     */
    public static ItemNamesEnum read(byte type) {
	for (ItemNamesEnum flag : ItemNamesEnum.values()) {
	    if (type == flag.getTag()) {
		return flag;
	    }
	}
	return null;
    }

    /** The item names. */
    private final String[] ITEM_NAMES = {"Bogus", "Integer", "Float", "Double", "Long", "Null", "InitObject", "Object", "NewObject"};
    /** The tag. */
    //@formatter:on
    private final int tag;

    /** The name. */
    private final String name;

    /**
     * Instantiates a new item names enum.
     *
     * @param tag the tag
     */
    ItemNamesEnum(int tag) {
        this.tag = tag;
        this.name = ITEM_NAMES[tag];
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the tag.
     *
     * @return the tag
     */
    public int getTag() {
        return tag;
    }
}
