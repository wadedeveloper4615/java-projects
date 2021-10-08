package com.wade.pojotester.instantiator;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.testfiles.ClassContainingPrivateEnum;
import com.wade.pojotester.testfiles.ObjectContainingArray;
import com.wade.pojotester.testfiles.ObjectContainingIterable;
import com.wade.pojotester.testfiles.ObjectContainingIterator;
import com.wade.pojotester.testfiles.ObjectContainingStream;
import com.wade.pojotester.testfiles.fields.TestEnum1;
import com.wade.pojotester.testfiles.fields.collections.collection.Collections;
import com.wade.pojotester.testfiles.fields.collections.map.Maps;
import com.wade.pojotester.util.ConstructorParameters;
import com.wade.pojotester.util.SublistFieldPermutator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
class ObjectGeneratorFastTest {
    private AbstractFieldValueChanger abstractFieldValueChanger = DefaultFieldValueChanger.INSTANCE;
    private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();

    private ObjectGenerator makeObjectGenerator(AbstractFieldValueChanger abstractFieldValueChanger, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	return new ObjectGenerator(abstractFieldValueChanger, constructorParameters, new SublistFieldPermutator());
    }

    private ClassAndFieldPredicatePair pair(Class<?> clazz) {
	return new ClassAndFieldPredicatePair(clazz);
    }

    @Test
    void Should_Create_Any_Instance() {
	// given
	ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	Class<?> expectedClass = GoodPojo_Equals_HashCode_ToString.class;
	// when
	Object result = objectGenerator.createNewInstance(expectedClass);
	// then
	assertThat(result).isInstanceOf(expectedClass);
    }

    @TestFactory
    Stream<DynamicTest> Should_Create_Same_Instance() {
	return Stream.of(new GoodPojo_Equals_HashCode_ToString(), new ObjectContainingArray(), new Collections(), new Maps(), new SecondChild()).map(value -> dynamicTest(getDefaultDisplayName(value), Should_Create_Same_Instance(value)));
    }

    private Executable Should_Create_Same_Instance(Object objectToCreateSameInstance) {
	return () -> {
	    // given
	    ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	    // when
	    Object result = objectGenerator.generateSameInstance(objectToCreateSameInstance);
	    // then
	    assertThat(result).isEqualToComparingFieldByField(objectToCreateSameInstance);
	};
    }

    @TestFactory
    Stream<DynamicTest> Should_Generate_Different_Objects() {
	return Stream.of(new DifferentObjectTestCase(A.class, 3), new DifferentObjectTestCase(B.class, 4), new DifferentObjectTestCase(C.class, 5), new DifferentObjectTestCase(ObjectContainingArray.class, 2), new DifferentObjectTestCase(ObjectContainingIterable.class, 2), new DifferentObjectTestCase(ObjectContainingIterator.class, 2), new DifferentObjectTestCase(ObjectContainingStream.class, 2), new DifferentObjectTestCase(Collections.class, 13), new DifferentObjectTestCase(Maps.class, 7),
		new DifferentObjectTestCase(GoodPojo_Equals_HashCode_ToString.class, 11), new DifferentObjectTestCase(Arrays_Primitive_Boolean.class, 2), new DifferentObjectTestCase(Arrays_Primitive_Byte.class, 2), new DifferentObjectTestCase(Arrays_Primitive_Char.class, 2), new DifferentObjectTestCase(Arrays_Primitive_Double.class, 2), new DifferentObjectTestCase(Arrays_Primitive_Float.class, 2), new DifferentObjectTestCase(Arrays_Primitive_Int.class, 2),
		new DifferentObjectTestCase(Arrays_Primitive_Long.class, 2), new DifferentObjectTestCase(Arrays_Primitive_Short.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Boolean.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Byte.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Character.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Double.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Float.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Integer.class, 2),
		new DifferentObjectTestCase(Arrays_Wrapped_Long.class, 2), new DifferentObjectTestCase(Arrays_Wrapped_Short.class, 2)).map(value -> dynamicTest(getDefaultDisplayName(value), Should_Generate_Different_Objects(value)));
    }

    private Executable Should_Generate_Different_Objects(DifferentObjectTestCase testCase) {
	return () -> {
	    // given
	    ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	    ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(testCase.clazz);
	    // when
	    List<Object> result = objectGenerator.generateDifferentObjects(classAndFieldPredicatePair);
	    // then
	    assertThat(result).hasSize(testCase.expectedSize).doesNotHaveDuplicates();
	};
    }

    @Test
    void Should_Generate_Different_Objects_For_Class_Containing_Boolean_Type() {
	// given
	ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(ClassWithBooleanField.class);
	// when
	List<Object> result = objectGenerator.generateDifferentObjects(classAndFieldPredicatePair);
	// then
	assertThat(result).hasSize(2).doesNotHaveDuplicates();
    }

    @Test
    void Should_Generate_Different_Objects_For_Class_With_Private_Enum() {
	// given
	ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(ClassContainingPrivateEnum.class);
	// when
	List<Object> result = objectGenerator.generateDifferentObjects(classAndFieldPredicatePair);
	// then
	assertThat(result).hasSize(5).doesNotHaveDuplicates();
    }

    @TestFactory
    Stream<DynamicTest> Should_Generate_Different_Objects_Recursively() {
	ClassAndFieldPredicatePair[] pair1 = { pair(E.class), pair(F.class) };
	ClassAndFieldPredicatePair[] pair2 = { pair(F.class) };
	ClassAndFieldPredicatePair[] pair3 = { pair(A.class), pair(B.class), pair(F.class), pair(G.class) };
	RecursivelyDifferentObjectTestCase case1 = new RecursivelyDifferentObjectTestCase(11, pair(D.class), pair1);
	RecursivelyDifferentObjectTestCase case2 = new RecursivelyDifferentObjectTestCase(5, pair(G.class), pair2);
	RecursivelyDifferentObjectTestCase case3 = new RecursivelyDifferentObjectTestCase(176, pair(H.class), pair3);
	return Stream.of(case1, case2, case3).map(value -> dynamicTest(getDefaultDisplayName(value), Should_Generate_Different_Objects_Recursively(value)));
    }

    public Executable Should_Generate_Different_Objects_Recursively(RecursivelyDifferentObjectTestCase testCase) {
	return () -> {
	    // given
	    ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	    // when
	    List<Object> result = objectGenerator.generateDifferentObjects(testCase.baseClass, testCase.otherClasses);
	    // then
	    assertThat(result).hasSize(testCase.expectedSize).doesNotHaveDuplicates();
	};
    }

    @Test
    void Should_Not_Fall_In_Endless_Loop() {
	// given
	ObjectGenerator objectGenerator = makeObjectGenerator(abstractFieldValueChanger, constructorParameters);
	ClassAndFieldPredicatePair iClass = new ClassAndFieldPredicatePair(R.class);
	int expectedSize = 2;
	// when
	List<Object> result = objectGenerator.generateDifferentObjects(iClass, iClass);
	// then
	assertThat(result).hasSize(expectedSize).doesNotHaveDuplicates();
    }

    @Data
    class A {
	int a;
	int b;
    }

    @Data
    private class Arrays_Primitive_Boolean {
	private boolean[] a = new boolean[] {};
    }

    @Data
    private class Arrays_Primitive_Byte {
	private byte[] b = new byte[] {};
    }

    @Data
    private class Arrays_Primitive_Char {
	private char[] c = new char[] {};
    }

    @Data
    private class Arrays_Primitive_Double {
	private double[] d = new double[] {};
    }

    @Data
    private class Arrays_Primitive_Float {
	private float[] e = new float[] {};
    }

    @Data
    private class Arrays_Primitive_Int {
	private int[] f = new int[] {};
    }

    @Data
    private class Arrays_Primitive_Long {
	private long[] g = new long[] {};
    }

    @Data
    private class Arrays_Primitive_Short {
	private short[] h = new short[] {};
    }

    @Data
    private class Arrays_Wrapped_Boolean {
	private Boolean[] i = new Boolean[] {};
    }

    @Data
    private class Arrays_Wrapped_Byte {
	private Byte[] j = new Byte[] {};
    }

    @Data
    private class Arrays_Wrapped_Character {
	private Character[] k = new Character[] {};
    }

    @Data
    private class Arrays_Wrapped_Double {
	private Double[] l = new Double[] {};
    }

    @Data
    private class Arrays_Wrapped_Float {
	private Float[] m = new Float[] {};
    }

    @Data
    private class Arrays_Wrapped_Integer {
	private Integer[] n = new Integer[] {};
    }

    @Data
    private class Arrays_Wrapped_Long {
	private Long[] o = new Long[] {};
    }

    @Data
    private class Arrays_Wrapped_Short {
	private Short[] p = new Short[] {};
    }

    @Data
    class B {
	int a;
	int b;
	int c;
    }

    @Data
    class C {
	int a;
	int b;
	int c;
	int d;
    }

    @Data
    private class ClassWithBooleanField {
	private boolean booleanField;
    }

    @Data
    class D {
	int a;
	E e;
	F f;
    }

    @Data
    @AllArgsConstructor
    private class DifferentObjectTestCase {
	private Class<?> clazz;
	private int expectedSize;
    }

    @Data
    class E {
	int b;
    }

    @Data
    class F {
	int d;
    }

    @Getter
    @Setter
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    private class FirstChild extends Parent {
	private UUID childUUID;

	private FirstChild() {
	    this.childUUID = UUID.randomUUID();
	}
    }

    @Data
    class G {
	int d;
	F f;
    }

    private class GoodPojo_Equals_HashCode_ToString {
	public long random;
	public byte byteField;
	public short shortType;
	public int intType;
	public long longType;
	public double doubleType;
	public boolean booleanType;
	public float floatType;
	public char charType;
	public TestEnum1 testEnum1;

	public GoodPojo_Equals_HashCode_ToString() {
	    Random random = new Random();
	    this.random = random.nextLong();
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
		return false;
	    }
	    GoodPojo_Equals_HashCode_ToString that = (GoodPojo_Equals_HashCode_ToString) o;
	    return new EqualsBuilder().append(random, that.random).append(byteField, that.byteField).append(shortType, that.shortType).append(intType, that.intType).append(longType, that.longType).append(doubleType, that.doubleType).append(booleanType, that.booleanType).append(floatType, that.floatType).append(charType, that.charType).append(testEnum1, that.testEnum1).isEquals();
	}

	public byte getByteField() {
	    return byteField;
	}

	public char getCharType() {
	    return charType;
	}

	public double getDoubleType() {
	    return doubleType;
	}

	public float getFloatType() {
	    return floatType;
	}

	public int getIntType() {
	    return intType;
	}

	public long getLongType() {
	    return longType;
	}

	public long getRandom() {
	    return random;
	}

	public short getShortType() {
	    return shortType;
	}

	public TestEnum1 getTestEnum1() {
	    return testEnum1;
	}

	@Override
	public int hashCode() {
	    return new HashCodeBuilder().append(random).append(byteField).append(shortType).append(intType).append(longType).append(doubleType).append(booleanType).append(floatType).append(charType).append(testEnum1).toHashCode();
	}

	public boolean isBooleanType() {
	    return booleanType;
	}

	public void setBooleanType(boolean booleanType) {
	    this.booleanType = booleanType;
	}

	public void setByteField(byte byteField) {
	    this.byteField = byteField;
	}

	public void setCharType(char charType) {
	    this.charType = charType;
	}

	public void setDoubleType(double doubleType) {
	    this.doubleType = doubleType;
	}

	public void setFloatType(float floatType) {
	    this.floatType = floatType;
	}

	public void setIntType(int intType) {
	    this.intType = intType;
	}

	public void setLongType(long longType) {
	    this.longType = longType;
	}

	public void setRandom(long random) {
	    this.random = random;
	}

	public void setShortType(short shortType) {
	    this.shortType = shortType;
	}

	public void setTestEnum1(TestEnum1 testEnum1) {
	    this.testEnum1 = testEnum1;
	}

	@Override
	public String toString() {
	    return new ToStringBuilder(this).append("random", random).append("byteField", byteField).append("shortType", shortType).append("intType", intType).append("longType", longType).append("doubleType", doubleType).append("booleanType", booleanType).append("floatType", floatType).append("charType", charType).append("testEnum1", testEnum1).toString();
	}
    }

    @Data
    class H {
	A a;
	B b;
	F f;
	G g;
    }

    @Data
    private class Parent {
	private UUID parentUUID;

	private Parent() {
	    this.parentUUID = UUID.randomUUID();
	}
    }

    @Data
    class R {
	R r;
    }

    @Data
    @AllArgsConstructor
    class RecursivelyDifferentObjectTestCase {
	private int expectedSize;
	private ClassAndFieldPredicatePair baseClass;
	private ClassAndFieldPredicatePair[] otherClasses;
    }

    @Getter
    @Setter
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    private class SecondChild extends FirstChild {
	private UUID secondChild;

	private SecondChild() {
	    this.secondChild = UUID.randomUUID();
	}
    }
}
