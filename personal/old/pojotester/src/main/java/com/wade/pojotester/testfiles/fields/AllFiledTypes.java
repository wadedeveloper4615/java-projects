package com.wade.pojotester.testfiles.fields;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * The Class AllFiledTypes.
 */
@SuppressWarnings({ "unused" })
public class AllFiledTypes {
    
    /** The final int type. */
    private final int finalIntType = 0;
    
    /** The byte type. */
    private byte byteType;
    
    /** The short type. */
    private short shortType;
    
    /** The int type. */
    private int intType;
    
    /** The long type. */
    private long longType;
    
    /** The double type. */
    private double doubleType;
    
    /** The boolean type. */
    private boolean booleanType;
    
    /** The character type. */
    private char characterType;
    
    /** The float type. */
    private float floatType;
    
    /** The string type. */
    private String stringType;
    
    /** The uuid. */
    private UUID uuid;
    
    /** The big decimal. */
    private BigDecimal bigDecimal;
    
    /** The big integer. */
    private BigInteger bigInteger;

    /**
     * Instantiates a new all filed types.
     */
    public AllFiledTypes() {
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param bigDecimal the big decimal
     */
    public AllFiledTypes(final BigDecimal bigDecimal) {
	this.bigDecimal = bigDecimal;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param bigInteger the big integer
     */
    public AllFiledTypes(final BigInteger bigInteger) {
	this.bigInteger = bigInteger;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param booleanType the boolean type
     */
    public AllFiledTypes(final boolean booleanType) {
	this.booleanType = booleanType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param byteType the byte type
     */
    public AllFiledTypes(final byte byteType) {
	this.byteType = byteType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param characterType the character type
     */
    public AllFiledTypes(final char characterType) {
	this.characterType = characterType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param doubleType the double type
     */
    public AllFiledTypes(final double doubleType) {
	this.doubleType = doubleType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param floatType the float type
     */
    public AllFiledTypes(final float floatType) {
	this.floatType = floatType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param intType the int type
     */
    public AllFiledTypes(final int intType) {
	this.intType = intType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param longType the long type
     */
    public AllFiledTypes(final long longType) {
	this.longType = longType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param shortType the short type
     */
    public AllFiledTypes(final short shortType) {
	this.shortType = shortType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param stringType the string type
     */
    public AllFiledTypes(final String stringType) {
	this.stringType = stringType;
    }

    /**
     * Instantiates a new all filed types.
     *
     * @param uuid the uuid
     */
    public AllFiledTypes(final UUID uuid) {
	this.uuid = uuid;
    }
}
