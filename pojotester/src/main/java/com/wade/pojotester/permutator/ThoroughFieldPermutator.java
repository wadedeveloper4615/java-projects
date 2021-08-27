/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.permutator;

import java.lang.reflect.Field;
import java.util.List;

import com.wade.pojotester.util.FieldUtils;

/**
 * The type Thorough field permutator.
 */
public class ThoroughFieldPermutator implements Permutator {
    /**
     * Permute list.
     *
     * @param elements the elements
     * 
     * @return the list
     */
    @Override
    public List<List<Field>> permute(List<Field> elements) {
	return FieldUtils.permutations(elements);
    }
}
