package com.wade.pojotester.tester;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Constructor tester.
 */
@SuppressWarnings({ "rawtypes" })
public class ConstructorTester extends AbstractTester {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(ConstructorTester.class);

    /**
     * Instantiates a new Constructor tester.
     */
    public ConstructorTester() {
	super();
    }

    /**
     * Instantiates a new Constructor tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public ConstructorTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	super(abstractFieldValueChanger);
    }

    /**
     * Constructor parameters are provided boolean.
     *
     * @param constructor the constructor
     *
     * @return the boolean
     */
    private boolean constructorParametersAreProvided(Constructor<?> constructor) {
	Class<?> declaringClass = constructor.getDeclaringClass();
	return getConstructorParameters().containsKey(declaringClass);
    }

    /**
     * Create constructor parameters object [ ].
     *
     * @param constructor the constructor
     *
     * @return the object [ ]
     */
    private Object[] createConstructorParameters(Constructor<?> constructor) {
	return Arrays.stream(constructor.getParameterTypes()).map(objectGenerator::createNewInstance).toArray();
    }

    /**
     * Gets constructor parameters.
     *
     * @param constructor the constructor
     *
     * @return the constructor parameters
     */
    private Collection<ConstructorParameters> getConstructorParameters(Constructor<?> constructor) {
	return getConstructorParameters().get(constructor.getDeclaringClass());
    }

    /**
     * Gets not synthetic constructor from class.
     *
     * @param testedClass the tested class
     *
     * @return the not synthetic constructor from class
     */
    private List<Constructor<?>> getNotSyntheticConstructorFromClass(Class<?> testedClass) {
	return Arrays.stream(testedClass.getDeclaredConstructors()).filter(this::isNotSynthetic).collect(Collectors.toList());
    }

    /**
     * Is abstract boolean.
     *
     * @param clazz the clazz
     *
     * @return the boolean
     */
    private boolean isAbstract(Class<?> clazz) {
	return clazz.isInterface() || clazz.isAnnotation() || Modifier.isAbstract(clazz.getModifiers());
    }

    /**
     * Is not synthetic boolean.
     *
     * @param constructor the constructor
     *
     * @return the boolean
     */
    private boolean isNotSynthetic(Constructor<?> constructor) {
	return !constructor.isSynthetic();
    }

    /**
     * Log and try to create own parameters object [ ].
     *
     * @param constructor the constructor
     *
     * @return the object [ ]
     */
    private Object[] logAndTryToCreateOwnParameters(Constructor<?> constructor) {
	LOGGER.warn(String.format("Class '%s' could not be created by constructor '%s' and any user defined parameters.", constructor.getDeclaringClass(), constructor));
	return createConstructorParameters(constructor);
    }

    @Override
    public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	if (isAbstract(testedClass)) {
	    LOGGER.info(String.format("Tried to test constructor in abstract (%s) class, annotation or interface. Skipping due to nature of constructors in those classes", testedClass));
	    return;
	}
	List<Constructor<?>> declaredConstructors = getNotSyntheticConstructorFromClass(testedClass);
	declaredConstructors.forEach(this::tryInstantiate);
    }

    /**
     * Try instantiate.
     *
     * @param constructor the constructor
     */
    private void tryInstantiate(Constructor<?> constructor) {
	Object[] parameters;
	Predicate<ConstructorParameters> matchingConstructorParameterTypes = ctr -> ctr.matches(constructor.getParameterTypes());
	if (constructorParametersAreProvided(constructor)) {
	    Collection<ConstructorParameters> constructorParameters = getConstructorParameters(constructor);
	    parameters = constructorParameters.stream().filter(matchingConstructorParameterTypes).map(ConstructorParameters::getParameters).findFirst().orElseGet(() -> logAndTryToCreateOwnParameters(constructor));
	} else {
	    parameters = createConstructorParameters(constructor);
	}
	testAssertions.assertThatConstructor(constructor).willInstantiateClassUsing(parameters);
    }
}
