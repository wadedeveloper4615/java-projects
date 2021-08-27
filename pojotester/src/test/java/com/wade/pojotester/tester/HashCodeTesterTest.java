package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.assertion.hashcode.AbstractHashCodeAssertionError;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.testfiles.fields.TestEnum1;

@SuppressWarnings({ "rawtypes", "unused" })
class HashCodeTesterTest {
    @Test
    void Should_Fail_Different_Object_With_Same_Type() {
	// given
	Class[] classesToTest = { BadPojoHashCodeDifferentObjectSameType.class };
	HashCodeTester hashCodeTester = new HashCodeTester();
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractHashCodeAssertionError.class);
    }

    @Test
    void Should_Fail_Itself_Test() {
	// given
	Class[] classesToTest = { BadPojoHashCodeItself.class };
	HashCodeTester hashCodeTester = new HashCodeTester();
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractHashCodeAssertionError.class);
    }

    @Test
    void Should_Fail_Multiple_Classes() {
	// given
	Class[] classesToTest = { BadPojoHashCodeItself.class, BadPojoHashCodeDifferentObjectSameType.class, BadPojoHashCodeItself.class };
	HashCodeTester hashCodeTester = new HashCodeTester();
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractHashCodeAssertionError.class);
    }

    @Test
    void Should_Fail_When_HashCode_Implementation_Depends_On_Excluded_Field() {
	// given
	HashCodeTester hashCodeTester = new HashCodeTester();
	Class<?> classToTest = GoodPojo_Equals_HashCode_ToString.class;
	Predicate<String> includedFields = FieldPredicate.include("byteField");
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.test(classToTest, includedFields));
	// then
	assertThat(result).isInstanceOf(AbstractHashCodeAssertionError.class);
    }

    @Test
    void Should_Pass_All_HashCode_Tests() {
	// given
	Class[] classesToTest = { GoodPojo_Equals_HashCode_ToString.class };
	HashCodeTester hashCodeTester = new HashCodeTester(DefaultFieldValueChanger.INSTANCE);
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_HashCode_Tests_Excluding_Fields() {
	// given
	HashCodeTester hashCodeTester = new HashCodeTester();
	Class<?> clazz = BadPojoHashCode.class;
	List<String> excludedFields = newArrayList("increment3", "increment4");
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_HashCode_Tests_Including_Fields() {
	// given
	HashCodeTester hashCodeTester = new HashCodeTester();
	Class<?> clazz = BadPojoHashCode.class;
	List<String> includedFields = newArrayList("increment1", "increment2");
	// when
	Throwable result = catchThrowable(() -> hashCodeTester.test(clazz, FieldPredicate.include(includedFields)));
	// then
	assertThat(result).isNull();
    }

    private class BadPojoHashCode {
	private int increment1;
	private int increment2;
	private int increment3;
	private int increment4;

	@Override
	public int hashCode() {
	    return new HashCodeBuilder().append(increment1).append(increment2).toHashCode();
	}
    }

    private static class BadPojoHashCodeDifferentObjectSameType {
	private static int increment;

	@Override
	public int hashCode() {
	    return BadPojoHashCodeDifferentObjectSameType.increment++;
	}
    }

    class BadPojoHashCodeItself {
	private int increment;

	@Override
	public int hashCode() {
	    return increment++;
	}
    }

    private class GoodPojo_Equals_HashCode_ToString {
	long random;
	byte byteField;
	short shortType;
	int intType;
	long longType;
	double doubleType;
	boolean booleanType;
	float floatType;
	char charType;
	TestEnum1 testEnum1;

	GoodPojo_Equals_HashCode_ToString() {
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
}
