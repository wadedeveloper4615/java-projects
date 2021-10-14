package helpers;

import java.util.Arrays;
import java.util.Map;

import org.mockito.ArgumentMatcher;

import com.wade.pojotester.util.ConstructorParameters;

class MapMatcher implements ArgumentMatcher<Map<Class<?>, ConstructorParameters>> {
    private Class<?> expectedClass;
    private ConstructorParameters expectedArguments;

    public MapMatcher(Class<?> expectedClass, ConstructorParameters expectedArguments) {
	this.expectedClass = expectedClass;
	this.expectedArguments = expectedArguments;
    }

    @Override
    public boolean matches(Map<Class<?>, ConstructorParameters> argument) {
	if (!argument.containsKey(expectedClass)) {
	    return false;
	}
	ConstructorParameters actualArguments = argument.get(expectedClass);
	return Arrays.equals(actualArguments.getParameters(), expectedArguments.getParameters()) && Arrays.equals(actualArguments.getParametersTypes(), expectedArguments.getParametersTypes());
    }
}
