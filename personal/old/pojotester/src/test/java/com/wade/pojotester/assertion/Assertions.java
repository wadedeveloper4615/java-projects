package com.wade.pojotester.assertion;

public class Assertions {
    /**
     * Creates assertion for class.
     *
     * @param clazz class for assertion
     *
     * @return assertion for given class
     *
     * @see AbstractAssertion
     * @see MultiClassAssertion
     * @see SingleClassAssertion
     */
    // public static AbstractAssertion assertPojoMethodsFor( Class<?> clazz) {
    // ParameterPreconditions.checkNotNull("clazz", clazz);
    //
    // Predicate<String> predicateAcceptingAllFields = FieldPredicate.includeAllFields(clazz);
    // return assertPojoMethodsFor(clazz, predicateAcceptingAllFields);
    // }
    //
    // /**
    // * Creates assertion for class and field predicate.
    // *
    // * @param clazz class for assertion
    // * @param fieldPredicate field predicate for given class
    // *
    // * @return assertion for given class
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsFor( Class<?> clazz, Predicate<String> fieldPredicate) {
    // ParameterPreconditions.checkNotNull("clazz", clazz);
    // ParameterPreconditions.checkNotNull("fieldPredicate", fieldPredicate);
    //
    // ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, fieldPredicate);
    // return assertPojoMethodsFor(classAndFieldPredicatePair);
    // }
    //
    // /**
    // * Creates assertion for classes declared as {@link ClassAndFieldPredicatePair} objects.
    // *
    // * @param baseClassAndFieldPredicatePair base class to test
    // * @param classAndFieldPredicatePairs nested classes, which are used as field types in base class
    // *
    // * @return assertion for given base class
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsFor( ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
    // ParameterPreconditions.checkNotNull("baseClassAndFieldPredicatePair", baseClassAndFieldPredicatePair);
    // return new SingleClassAssertion(baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
    // }
    //
    // /**
    // * Creates assertion for class, by qualified class name.
    // *
    // * @param qualifiedClassName class for assertion
    // *
    // * @return assertion for given class
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsFor( String qualifiedClassName) {
    // ParameterPreconditions.checkNotBlank("qualifiedClassName", qualifiedClassName);
    //
    // Class<?> clazz = ClassLoader.loadClass(qualifiedClassName);
    // return assertPojoMethodsFor(clazz);
    // }
    //
    // /**
    // * Creates assertion for class, by qualified class name and field predicate.
    // *
    // * @param qualifiedClassName class for assertion
    // * @param fieldPredicate field predicate for given class
    // *
    // * @return assertion for given class
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsFor( String qualifiedClassName, Predicate<String> fieldPredicate) {
    // ParameterPreconditions.checkNotBlank("qualifiedClassName", qualifiedClassName);
    // ParameterPreconditions.checkNotNull("fieldPredicate", fieldPredicate);
    //
    // Class<?> clazz = ClassLoader.loadClass(qualifiedClassName);
    // return assertPojoMethodsFor(clazz, fieldPredicate);
    // }
    //
    // /**
    // * Creates assertion for all classes.
    // *
    // * @param classes classes to test
    // *
    // * @return assertion for all classes
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsForAll( Class... classes) {
    // ParameterPreconditions.checkNotNull("classes", classes);
    //
    // ClassAndFieldPredicatePair[] classesAndFieldPredicatesPairs = Arrays.stream(classes).map(ClassAndFieldPredicatePair::new).toArray(ClassAndFieldPredicatePair[]::new);
    // return assertPojoMethodsForAll(classesAndFieldPredicatesPairs);
    // }
    //
    // /**
    // * Creates assertion for all classes declared as {@link ClassAndFieldPredicatePair} objects.
    // *
    // * @param classesAndFieldPredicatesPairs class and field predicate pairs to test
    // *
    // * @return assertion for all classes
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsForAll( ClassAndFieldPredicatePair... classesAndFieldPredicatesPairs) {
    // checkNotNull("classesAndFieldPredicatesPairs", classesAndFieldPredicatesPairs);
    //
    // List<ClassAndFieldPredicatePair> classAndFieldPredicatePairs = Arrays.asList(classesAndFieldPredicatesPairs);
    // return new MultiClassAssertion(classAndFieldPredicatePairs);
    // }
    //
    // /**
    // * Creates assertion for all classes returned by {@link PackageFilter}.
    // *
    // * @param packageFilter package filter
    // *
    // * @return assertion for all classes
    // *
    // * @see PackageFilter
    // */
    // public static AbstractAssertion assertPojoMethodsForAll( PackageFilter packageFilter) {
    // checkNotNull("packageFilter", packageFilter);
    // return assertPojoMethodsForAll(packageFilter.getClasses());
    // }
    //
    // /**
    // * Creates assertion for all classes, by classes names.
    // *
    // * @param qualifiedClassNames classes to test
    // *
    // * @return assertion for all classes
    // *
    // * @see AbstractAssertion
    // * @see MultiClassAssertion
    // * @see SingleClassAssertion
    // */
    // public static AbstractAssertion assertPojoMethodsForAll( String... qualifiedClassNames) {
    // ParameterPreconditions.checkNotBlank("qualifiedClassNames", qualifiedClassNames);
    //
    // Class<?>[] classesAndFieldPredicatesPairs = Arrays.stream(qualifiedClassNames).map(ClassLoader::loadClass).toArray(Class[]::new);
    // return assertPojoMethodsForAll(classesAndFieldPredicatesPairs);
    // }
    private Assertions() {
    }
}
