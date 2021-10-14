/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import com.wade.pojotester.exception.ClassLoadingException;

// TODO: Auto-generated Javadoc
/**
 * The type Class loader.
 */
public class ClassLoader {
    /**
     * Load class class.
     *
     * @param qualifiedClassName the qualified class name
     * 
     * @return the class
     */
    public static Class<?> loadClass(String qualifiedClassName) {
	try {
	    return Class.forName(qualifiedClassName);
	} catch (ClassNotFoundException e) {
	    throw new ClassLoadingException(qualifiedClassName, e);
	}
    }
}
