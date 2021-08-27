/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.lang.reflect.InvocationTargetException;

import com.wade.pojotester.exception.TesterInstantiationException;
import com.wade.pojotester.tester.AbstractTester;
import com.wade.pojotester.tester.ConstructorTester;
import com.wade.pojotester.tester.EqualsTester;
import com.wade.pojotester.tester.GetterTester;
import com.wade.pojotester.tester.HashCodeTester;
import com.wade.pojotester.tester.SetterTester;
import com.wade.pojotester.tester.ToStringTester;

// TODO: Auto-generated Javadoc
/**
 * The enum Method.
 */
public enum Method {
    /**
     * Equals method.
     */
    //@formatter:off
    EQUALS(EqualsTester.class),
    /**
     * Hash code method.
     */
    HASH_CODE(HashCodeTester.class),
    /**
     * Setter method.
     */
    SETTER(SetterTester.class),
    /**
     * Getter method.
     */
    GETTER(GetterTester.class),
    /**
     * To string method.
     */
    TO_STRING(ToStringTester.class),
    /**
     * Constructor method.
     */
    CONSTRUCTOR(ConstructorTester.class)
    ;
    //@formatter:on

    /**
     * The Tester class.
     */
    private Class<? extends AbstractTester> testerClass;

    /**
     * Instantiates a new Method.
     *
     * @param testerClass the tester class
     */
    Method(Class<? extends AbstractTester> testerClass) {
	this.testerClass = testerClass;
    }

    /**
     * Gets tester.
     *
     * @return the tester
     */
    public AbstractTester getTester() {
	try {
	    return this.testerClass.getDeclaredConstructor().newInstance();
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
	    throw new TesterInstantiationException(e);
	}
    }

    /**
     * Gets the tester class.
     *
     * @return the tester class
     */
    public Class<? extends AbstractTester> getTesterClass() {
	return testerClass;
    }
}
