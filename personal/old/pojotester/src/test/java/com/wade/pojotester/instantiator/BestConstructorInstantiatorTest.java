package com.wade.pojotester.instantiator;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.testfiles.ClassContainingStaticClasses;
import com.wade.pojotester.testfiles.Constructor_Stream;
import com.wade.pojotester.testfiles.Constructor_Thread;
import com.wade.pojotester.testfiles.Constructors_First_Throws_Exception;
import com.wade.pojotester.testfiles.PackageConstructor;
import com.wade.pojotester.testfiles.Person;
import com.wade.pojotester.testfiles.PrivateConstructor;
import com.wade.pojotester.testfiles.ProtectedConstructor;
import com.wade.pojotester.testfiles.UnpublicClass;
import com.wade.pojotester.util.ConstructorParameters;
import com.wade.pojotester.util.FieldUtils;
import com.wade.pojotester.util.MethodUtils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings({ "unused" })
class BestConstructorInstantiatorTest {
    private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();

    @TestFactory
    Stream<DynamicTest> Should_Create_Object_Using_Best_Constructor() {
	return Stream.of(Constructor_Array_Boolean.class, Constructor_Array_Boolean_Primitive.class, Constructor_Array_Byte.class, Constructor_Array_Byte_Primitive.class, Constructor_Array_Char.class, Constructor_Array_Char_Primitive.class, Constructor_Array_Double.class, Constructor_Array_Double_Primitive.class, Constructor_Array_Float.class, Constructor_Array_Float_Primitive.class, Constructor_Array_Int.class, Constructor_Array_Int_Primitive.class, Constructor_Array_Long.class,
		Constructor_Array_Long_Primitive.class, Constructor_Array_Short.class, Constructor_Array_Short_Primitive.class, Constructor_Stream.class, Constructor_Thread.class, NoDefaultConstructor.class, PackageConstructor.class, PrivateConstructor.class, ProtectedConstructor.class, ClassContainingStaticClasses.NestedStaticClass_PublicConstructor.class, ClassContainingStaticClasses.NestedStaticClass_PackageConstructor.class, ClassContainingStaticClasses.NestedStaticClass_ProtectedConstructor.class,
		ClassContainingStaticClasses.NestedStaticClass_PrivateConstructor.class, Person.class, Person.PersonBuilder.class, FieldUtils.class, MethodUtils.class, FieldPredicate.class).map(value -> dynamicTest(getDefaultDisplayName(value.getName()), Should_Create_Object_Using_Best_Constructor(value)));
    }

    private Executable Should_Create_Object_Using_Best_Constructor(Class<?> classToInstantiate) {
	return () -> {
	    // given
	    BestConstructorInstantiator instantiator = new BestConstructorInstantiator(classToInstantiate, constructorParameters);
	    // when
	    Object result = instantiator.instantiate();
	    // then
	    assertThat(result).isInstanceOf(classToInstantiate);
	};
    }

    @Test
    void Should_Create_Object_Using_Private_Constructor() {
	// given
	Class<?> classToInstantiate = PrivateConstructor.class;
	BestConstructorInstantiator instantiator = new BestConstructorInstantiator(classToInstantiate, constructorParameters);
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(classToInstantiate);
    }

    @Test
    void Should_Create_Object_With_Second_Constructor_If_First_Threw_exception() {
	// given
	Class<?> classToInstantiate = Constructors_First_Throws_Exception.class;
	BestConstructorInstantiator instantiator = new BestConstructorInstantiator(classToInstantiate, constructorParameters);
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(classToInstantiate);
    }

    @Test
    void Should_Create_Object_With_User_Defined_Constructor_Parameters() {
	// given
	ArrayListValuedHashMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
	ConstructorParameters parameters = new ConstructorParameters(new Object[] { "expectedString" }, new Class[] { Object.class });
	constructorParameters.put(NoDefaultConstructor.class, parameters);
	BestConstructorInstantiator instantiator = new BestConstructorInstantiator(NoDefaultConstructor.class, constructorParameters);
	NoDefaultConstructor expectedResult = new NoDefaultConstructor("expectedString");
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isEqualTo(expectedResult);
    }

    @TestFactory
    Stream<DynamicTest> Should_Instantiate_Non_Public_Classes() {
	//@formatter:off
	return Stream
		.of(UnpublicClass.class.getName(),
		    //  TODO Fix me
		    //"com.wade.pojotester.testfiles.UnpublicClass$PrivateStaticNestedClass.class",
		    //"com.wade.pojotester.testfiles.UnpublicClass$PrivateStaticNestedClass$PrivateStaticNestedClass2",
		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PackageStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PackageStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PackageNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PackageNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicNestedClass",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_PublicConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_PackageConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_ProtectedConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_PrivateConstructor",
		    "com.wade.pojotester.testfiles.Person",
		    "com.wade.pojotester.testfiles.Person$PersonBuilder")
		.map(value -> dynamicTest(getDefaultDisplayName(value), Should_Instantiate_Non_Public_Classes(value)));
	//@formatter:on
    }

    private Executable Should_Instantiate_Non_Public_Classes(String className) {
	return () -> {
	    // given
	    Class<?> classUnderTest = Class.forName(className);
	    BestConstructorInstantiator instantiator = new BestConstructorInstantiator(classUnderTest, constructorParameters);
	    // when
	    Object result = instantiator.instantiate();
	    // then
	    assertThat(result).isInstanceOf(classUnderTest);
	};
    }

    @TestFactory
    Stream<DynamicTest> Should_Throw_Exception_When_Cannot_Instantiate_Class() {
	return Stream.of(One_Arg_Constructor_Throws_NPE.class, No_Args_Constructor_Throws_NPE.class).map(value -> dynamicTest(getDefaultDisplayName(value.getName()), Should_Throw_Exception_When_Cannot_Instantiate_Class(value)));
    }

    private Executable Should_Throw_Exception_When_Cannot_Instantiate_Class(Class<?> classToInstantiate) {
	return () -> {
	    // given
	    BestConstructorInstantiator instantiator = new BestConstructorInstantiator(classToInstantiate, constructorParameters);
	    // when
	    Throwable result = catchThrowable(instantiator::instantiate);
	    // then
	    assertThat(result).isInstanceOf(ObjectInstantiationException.class);
	};
    }

    private class Constructor_Array_Boolean {
	private Boolean[] array;

	Constructor_Array_Boolean(Boolean[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Boolean_Primitive {
	private boolean[] array;

	Constructor_Array_Boolean_Primitive(boolean[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Byte {
	private Byte[] array;

	Constructor_Array_Byte(Byte[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Byte_Primitive {
	private byte[] array;

	Constructor_Array_Byte_Primitive(byte[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Char {
	private Character[] array;

	Constructor_Array_Char(Character[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Char_Primitive {
	private char[] array;

	Constructor_Array_Char_Primitive(char[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Double {
	private Double[] array;

	Constructor_Array_Double(Double[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Double_Primitive {
	private double[] array;

	Constructor_Array_Double_Primitive(double[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Float {
	private Float[] array;

	Constructor_Array_Float(Float[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Float_Primitive {
	private float[] array;

	Constructor_Array_Float_Primitive(float[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Int {
	private Integer[] array;

	Constructor_Array_Int(Integer[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Int_Primitive {
	private int[] array;

	Constructor_Array_Int_Primitive(int[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Long {
	private Long[] array;

	Constructor_Array_Long(Long[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Long_Primitive {
	private long[] array;

	Constructor_Array_Long_Primitive(long[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Short {
	private Short[] array;

	Constructor_Array_Short(Short[] array) {
	    this.array = array;
	}
    }

    private class Constructor_Array_Short_Primitive {
	private short[] array;

	Constructor_Array_Short_Primitive(short[] array) {
	    this.array = array;
	}
    }

    private class No_Args_Constructor_Throws_NPE {
	No_Args_Constructor_Throws_NPE() {
	    throw new NullPointerException("test");
	}
    }

    @ToString
    @EqualsAndHashCode
    private class NoDefaultConstructor {
	private int a;
	private int b;
	private int c;
	private Object object;

	NoDefaultConstructor(int a) {
	    this.a = a;
	}

	NoDefaultConstructor(Object object) {
	    this.object = object;
	}
    }

    private class One_Arg_Constructor_Throws_NPE {
	One_Arg_Constructor_Throws_NPE(Object o) {
	    throw new NullPointerException("test");
	}
    }
}
