package helpers;

import java.util.function.Predicate;
import org.mockito.ArgumentMatcher;

public class StringPredicateArgumentMatcher implements ArgumentMatcher<Predicate<String>> {
    @Override
    public boolean matches(Predicate<String> argument) {
	return argument.test("a");
    }
}
