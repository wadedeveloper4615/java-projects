package com.wade.pojotester.utils;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import com.wade.pojotester.exception.ClassLoadingException;
import com.wade.pojotester.util.ClassLoader;

class ClassLoaderTest {
    @TestFactory
    Stream<DynamicTest> Should_Load_Expected_Class_By_Qualified_Class_Name() {
	//@formatter:off
	return Stream
		.of("com.wade.pojotester.instantiator.Instantiable",
		    "com.wade.pojotester.testfiles.EmptyEnum",
		    "com.wade.pojotester.testfiles.Constructor_Field",
		    "com.wade.pojotester.testfiles.Constructor_Stream",
		    "com.wade.pojotester.testfiles.Constructor_Thread",
		    "java.lang.Boolean",
		    "java.lang.Byte",
		    "java.lang.Character",
		    "java.lang.Double",
		    "java.lang.Float",
		    "java.lang.Integer",
		    "java.lang.Long",
		    "java.lang.Short",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_PublicConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_PackageConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_ProtectedConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingStaticClasses$NestedStaticClass_PrivateConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Package_PublicConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Package_PackageConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Package_ProtectedConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Package_PrivateConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Protected_PublicConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Protected_PackageConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Protected_ProtectedConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Protected_PrivateConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Private_PublicConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Private_PackageConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Private_ProtectedConstructor",
		    "com.wade.pojotester.testfiles.ClassContainingUnpublicClasses$Private_PrivateConstructor",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicStaticFinalNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicStaticNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateStaticFinalNestedClass",
 		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateStaticFinalNestedClass$PrivateStaticFinalNestedClass2",
 		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedStaticFinalNestedClass",
 		    "com.wade.pojotester.testfiles.UnpublicClass$PackageStaticFinalNestedClass",
 		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateStaticNestedClass",
 		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedStaticNestedClass",
 		    "com.wade.pojotester.testfiles.UnpublicClass$PackageStaticNestedClass",
 		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateFinalNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedFinalNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PackageFinalNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicFinalNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PrivateNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$ProtectedNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PackageNestedClass",
		    "com.wade.pojotester.testfiles.UnpublicClass$PublicNestedClass",
		    "java.lang.String")
		.map(value -> dynamicTest(getDefaultDisplayName(value), Should_Load_Expected_Class_By_Qualified_Class_Name(value)));
	//@formatter:on
    }

    private Executable Should_Load_Expected_Class_By_Qualified_Class_Name(final String qualifiedClassName) {
	return () -> {
	    // when
	    final Class<?> result = ClassLoader.loadClass(qualifiedClassName);
	    // then
	    assertThat(result.getName()).isEqualTo(qualifiedClassName);
	};
    }

    @Test
    void Should_Throw_Exception_If_Class_Does_Not_Exist() {
	// given
	// when
	final Throwable result = catchThrowable(() -> ClassLoader.loadClass("lopopopo.ale.tlucze"));
	// then
	assertThat(result).isInstanceOf(ClassLoadingException.class);
    }
}
