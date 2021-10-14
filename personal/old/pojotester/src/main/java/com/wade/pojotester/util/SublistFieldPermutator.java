/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.lang.reflect.Field;
import java.util.List;

import com.wade.pojotester.permutator.Permutator;

// TODO: Auto-generated Javadoc
/**
 * The Class SublistFieldPermutator.
 */
public class SublistFieldPermutator implements Permutator {
    /**
     * Permute.
     *
     * @param elements the elements
     *
     * @return the list
     */
    @Override
    public List<List<Field>> permute(List<Field> elements) {
	return Sublists.subsequences(elements);
    }
}
