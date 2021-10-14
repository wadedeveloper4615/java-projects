/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// TODO: Auto-generated Javadoc
/**
 * The type Field helper.
 */
public class FieldHelper {
    /**
     * The constant MODIFIERS.
     */
    private static VarHandle MODIFIERS;
    static {
	try {
	    var lookup = MethodHandles.privateLookupIn(Field.class, MethodHandles.lookup());
	    MODIFIERS = lookup.findVarHandle(Field.class, FieldUtils.MODIFIERS_FIELD_NAME_IN_FIELD_CLASS, int.class);
	} catch (IllegalAccessException | NoSuchFieldException ex) {
	    throw new RuntimeException(ex);
	}
    }

    /**
     * Make non .
     *
     * @param field the field
     */
    public static void makeNon(Field field) {
	int mods = field.getModifiers();
	if (Modifier.isFinal(mods)) {
	    MODIFIERS.set(field, mods & ~Modifier.FINAL);
	}
    }
}