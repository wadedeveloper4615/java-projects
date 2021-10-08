package com.wade.pojotester.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.permutator.ThoroughFieldPermutator;
import com.wade.pojotester.testfiles.permutator.A;
import com.wade.pojotester.util.CollectionUtils;

@SuppressWarnings({ "unchecked" })
class ThoroughFieldPermutatorTest {
    @Test
    void Should_Create_Permutations() throws NoSuchFieldException {
	// given
	final ThoroughFieldPermutator permutator = new ThoroughFieldPermutator();
	final Field aField = A.class.getDeclaredField("a");
	final Field bField = A.class.getDeclaredField("b");
	final List<Field> elements = CollectionUtils.asList(aField, bField);
	final List<List<Field>> expectedResult = CollectionUtils.asList(CollectionUtils.asList(aField), CollectionUtils.asList(bField), CollectionUtils.asList(aField, bField));
	// when
	final List<List<Field>> result = permutator.permute(elements);
	// then
	assertThat(result).isEqualTo(expectedResult);
    }
}