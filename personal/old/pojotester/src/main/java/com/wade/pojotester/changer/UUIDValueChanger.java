/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer;

import java.util.UUID;

/**
 * The type Uuid value changer.
 */
class UUIDValueChanger extends AbstractFieldValueChanger<UUID> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(UUID.class);
    }

    /**
     * Increase value uuid.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the uuid
     */
    @Override
    protected UUID increaseValue(UUID value, Class<?> type) {
	UUID random;
	do {
	    random = UUID.randomUUID();
	} while (!areDifferentValues(value, random));
	return random;
    }
}
