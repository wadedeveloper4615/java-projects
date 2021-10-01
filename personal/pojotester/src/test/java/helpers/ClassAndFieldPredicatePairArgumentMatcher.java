package helpers;

import org.mockito.ArgumentMatcher;

import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;

public class ClassAndFieldPredicatePairArgumentMatcher implements ArgumentMatcher<ClassAndFieldPredicatePair> {
    private Class<?> clazz;
    private String fieldName;

    public ClassAndFieldPredicatePairArgumentMatcher(Class<?> clazz, String fieldName) {
	this.clazz = clazz;
	this.fieldName = fieldName;
    }

    @Override
    public boolean matches(ClassAndFieldPredicatePair argument) {
	boolean classesMatches = argument.getClazz().equals(clazz);
	boolean predicateMatches = argument.getFieldsPredicate().test(fieldName);
	return classesMatches && predicateMatches;
    }
}
