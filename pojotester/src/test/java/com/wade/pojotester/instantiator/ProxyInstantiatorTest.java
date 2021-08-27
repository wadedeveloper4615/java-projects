package com.wade.pojotester.instantiator;

class ProxyInstantiatorTest {
    //
    // @Data
    // static class A {
    // private int a;
    // }
    //
    // @Data
    // private static class B {
    // private int a;
    // }
    //
    // @Data
    // class C {
    // private int a;
    // }
    //
    // @Data
    // public class D {
    // private int a;
    // }
    //
    // @Data
    // private class E {
    // private int a;
    // }
    //
    // private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
    //
    // // @TestFactory
    // Stream<DynamicTest> Should_Create_Abstract_Class_Without_Default_Constructor() {
    // return Stream.of(A.class, B.class, C.class, D.class, E.class).map(value -> dynamicTest(getDefaultDisplayName(value.getName()), Should_Create_Abstract_Class_Without_Default_Constructor(value)));
    // }
    //
    // private Executable Should_Create_Abstract_Class_Without_Default_Constructor( Class<?> classToInstantiate) {
    // return () -> {
    // // given
    //
    // ProxyInstantiator instantiator = new ProxyInstantiator(classToInstantiate, constructorParameters);
    //
    // // when
    // Object result = instantiator.instantiate();
    //
    // // then
    // assertThat(result).isInstanceOf(classToInstantiate);
    // };
    // }
    //
    // @Test
    // void Should_Create_Java_Proxy_Which_Returns_Expected_Values() {
    // // given
    // ProxyInstantiator instantiator = new ProxyInstantiator(Interface.class, constructorParameters);
    //
    // // when
    // Object result = instantiator.instantiate();
    //
    // // then
    // assertThat(result.toString()).isEqualTo("string");
    // assertThat(result.equals(null)).isTrue();
    // assertThat(result.hashCode()).isZero();
    // }
    //
    // // @TestFactory
    // Stream<DynamicTest> Should_Instantiate_Abstract_Interface_Or_Annotation_Classes() {
    // return Stream.of(Annotation.class, Abstract.class, Interface.class, Abstract_PrivateConstructor.class).map(value -> dynamicTest(getDefaultDisplayName(value.getName()), Should_Instantiate_Abstract_Interface_Or_Annotation_Classes(value)));
    // }
    //
    // private Executable Should_Instantiate_Abstract_Interface_Or_Annotation_Classes( Class<?> classToInstantiate) {
    // return () -> {
    // // given
    // ProxyInstantiator instantiator = new ProxyInstantiator(classToInstantiate, constructorParameters);
    //
    // // when
    // Object result = instantiator.instantiate();
    //
    // // then
    // assertThat(result).isInstanceOf(classToInstantiate);
    // };
    // }
    //
}
