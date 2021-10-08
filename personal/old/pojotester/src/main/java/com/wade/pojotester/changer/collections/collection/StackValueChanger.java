/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.Stack;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Stack value changer.
 */
class StackValueChanger extends AbstractCollectionFieldValueChanger<Stack<?>> {
    /**
     * Create stack with one element stack.
     *
     * @return the stack
     */
    private Stack<Object> createStackWithOneElement() {
	Stack<Object> objects = new Stack<>();
	objects.add(new Object());
	return objects;
    }

    /**
     * Increase value stack.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the stack
     */
    @Override
    protected Stack<?> increaseValue(Stack<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : createStackWithOneElement();
    }
}
