package helpers;

import java.util.Arrays;

import org.apache.commons.collections4.MultiValuedMap;
import org.mockito.ArgumentMatcher;

import com.wade.pojotester.util.ConstructorParameters;

public class MultiValuedMapMatcher implements ArgumentMatcher<MultiValuedMap<Class<?>, ConstructorParameters>> {
    private Class<?> expectedClass;
    private ConstructorParameters expectedArguments;

    public MultiValuedMapMatcher(Class<?> expectedClass, ConstructorParameters expectedArguments) {
	this.expectedClass = expectedClass;
	this.expectedArguments = expectedArguments;
    }

    @Override
    public boolean matches(MultiValuedMap<Class<?>, ConstructorParameters> argument) {
	if (!argument.containsKey(expectedClass)) {
	    return false;
	}
	return argument.get(expectedClass).stream().map(actualArgument -> Arrays.equals(actualArgument.getParameters(), expectedArguments.getParameters()) && Arrays.equals(actualArgument.getParametersTypes(), expectedArguments.getParametersTypes())).findAny().isPresent();
    }
}
