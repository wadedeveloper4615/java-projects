package com.wade.pojotester.instantiator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.lang.reflect.Constructor;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

import lombok.Data;

@SuppressWarnings({ "unused" })
class AbstractMultiConstructorInstantiatorTest {
    @Test
    void Should_Create_Object_Using_User_Parameters() {
	// given
	ArrayListValuedHashMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
	Class<?> clazz = A.class;
	constructorParameters.put(clazz, new ConstructorParameters(new Object[] { 12345 }, new Class[] { int.class }));
	AbstractMultiConstructorInstantiator instantiator = new MockMultiConstructorInstantiator(clazz, constructorParameters);
	A expectedResult = new A(12345);
	// when
	Object result = instantiator.instantiateUsingUserParameters();
	// then
	assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void Should_Return_Null_If_Parameters_For_This_Class_Are_Empty() {
	// given
	ArrayListValuedHashMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
	Class<?> clazz = A.class;
	AbstractMultiConstructorInstantiator instantiator = new MockMultiConstructorInstantiator(clazz, constructorParameters);
	// when
	Object result = instantiator.instantiateUsingUserParameters();
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Throw_Exception_If_Constructor_Throws_Exception() {
	// given
	ArrayListValuedHashMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
	Class<?> clazz = B.class;
	AbstractMultiConstructorInstantiator instantiator = new MockMultiConstructorInstantiator(clazz, constructorParameters);
	Throwable expectedResult = new ObjectInstantiationException(B.class, "msg", null);
	// when
	Throwable result = catchThrowable(instantiator::createFindingBestConstructor);
	// then
	assertThat(result).isEqualToComparingFieldByField(expectedResult);
    }

    @Data
    private class A {
	private int b;

	public A(int i) {
	    b = i;
	}
    }

    private class B {
	B(int a) {
	    throw new RuntimeException("eee");
	}
    }

    static class MockMultiConstructorInstantiator extends AbstractMultiConstructorInstantiator {
	MockMultiConstructorInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	    super(clazz, constructorParameters);
	}

	@Override
	public boolean canInstantiate() {
	    return true;
	}

	@Override
	protected Object createObjectFromArgsConstructor(Class<?>[] parameterTypes, Object[] parameters) throws ObjectInstantiationException {
	    try {
		Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(parameterTypes);
		declaredConstructor.setAccessible(true);
		return declaredConstructor.newInstance(parameters);
	    } catch (Exception e) {
		throw new ObjectInstantiationException(null, null);
	    }
	}

	@Override
	protected Object createObjectFromNoArgsConstructor(Constructor<?> constructor) {
	    return null;
	}

	@Override
	protected ObjectInstantiationException createObjectInstantiationException() {
	    return new ObjectInstantiationException(B.class, "msg", null);
	}

	@Override
	public Object instantiate() {
	    return null;
	}
    }
}