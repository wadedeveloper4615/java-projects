package helpers;

import org.mockito.ArgumentMatcher;

import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;

class ClassNameAndFieldPredicatePairArgumentMatcher implements ArgumentMatcher<ClassAndFieldPredicatePair> {
    private String className;
    private String fieldName;

    public ClassNameAndFieldPredicatePairArgumentMatcher(String className, String fieldName) {
	this.className = className;
	this.fieldName = fieldName;
    }

    @Override
    public boolean matches(ClassAndFieldPredicatePair argument) {
	boolean classesMatches = argument.getClazz().getName().equals(className);
	boolean predicateMatches = argument.getFieldsPredicate().test(fieldName);
	return classesMatches && predicateMatches;
    }
}
