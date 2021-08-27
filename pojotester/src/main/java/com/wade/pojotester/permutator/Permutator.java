/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.permutator;

import java.lang.reflect.Field;
import java.util.List;

/**
 * The interface Permutator.
 */
public interface Permutator {
    /**
     * Permute list.
     *
     * @param baseClassFieldsToChange the base class fields to change
     * 
     * @return the list
     */
    List<List<Field>> permute(List<Field> baseClassFieldsToChange);
}
