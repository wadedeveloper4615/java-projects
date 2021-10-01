/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Character value changer.
 */
class CharacterValueChanger extends AbstractPrimitiveValueChanger<Character> {
    /**
     * Increase character.
     *
     * @param value the value
     * 
     * @return the character
     */
    @Override
    protected Character increase(Character value) {
	return (char) (value + 1);
    }
}
