package helpers;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.ArgumentMatcher;

import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;

public class RecursivelyEqualArgumentMatcher implements ArgumentMatcher<ClassAndFieldPredicatePair> {
    private ClassAndFieldPredicatePair expectedParameter;

    public RecursivelyEqualArgumentMatcher(ClassAndFieldPredicatePair expectedParameter) {
	this.expectedParameter = expectedParameter;
    }

    @Override
    public boolean matches(ClassAndFieldPredicatePair argument) {
	assertThat(argument).isEqualToComparingFieldByFieldRecursively(expectedParameter);
	return true;
    }
}
