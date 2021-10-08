package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.assertion.AbstractAssertionError;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.testfiles.fields.TestEnum1;

@SuppressWarnings({ "rawtypes", "unused" })
class ToStringTesterTest {
    @Test
    void Should_Fail_All_ToString_Tests() {
	// given
	Class[] classesToTest = { ToStringWithoutField.class };
	ToStringTester toStringTester = new ToStringTester();
	// when
	Throwable result = catchThrowable(() -> toStringTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractAssertionError.class);
    }

    @Test
    void Should_Fail_All_ToString_Tests_Excluding_Fields() {
	// given
	ToStringTester toStringTester = new ToStringTester();
	Class<?> clazz = ToStringWithoutField.class;
	List<String> excludedFields = newArrayList("a");
	// when
	Throwable result = catchThrowable(() -> toStringTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	// then
	assertThat(result).isInstanceOf(AbstractAssertionError.class);
    }

    @Test
    void Should_Fail_All_ToString_Tests_Including_Fields() {
	// given
	ToStringTester toStringTester = new ToStringTester();
	Class<?> clazz = ToStringWithoutField.class;
	List<String> includedFields = newArrayList("a", "b");
	// when
	Throwable result = catchThrowable(() -> toStringTester.test(clazz, FieldPredicate.include(includedFields)));
	// then
	assertThat(result).isInstanceOf(AbstractAssertionError.class);
    }

    @Test
    void Should_Pass_All_ToString_Tests() {
	// given
	Class[] classesToTest = { GoodPojo_Equals_HashCode_ToString.class };
	ToStringTester toStringTester = new ToStringTester(DefaultFieldValueChanger.INSTANCE);
	// when
	Throwable result = catchThrowable(() -> toStringTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_ToString_Tests_Excluding_Fields() {
	// given
	ToStringTester toStringTester = new ToStringTester();
	Class<?> clazz = ToStringWithoutField.class;
	List<String> excludedFields = newArrayList("testEnum");
	// when
	Throwable result = catchThrowable(() -> toStringTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_ToString_Tests_Including_Fields() {
	// given
	ToStringTester toStringTester = new ToStringTester();
	Class<?> clazz = ToStringWithoutField.class;
	List<String> includedFields = newArrayList("a", "b", "obj");
	// when
	Throwable result = catchThrowable(() -> toStringTester.test(clazz, FieldPredicate.include(includedFields)));
	// then
	assertThat(result).isNull();
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

    private class ToStringWithoutField {
	private int a = 1;
	private float b = 1.43F;
	private Object obj = null;
	private TestEnum1 testEnum;

	@Override
	public String toString() {
	    return new ToStringBuilder(this).append("a", a).append("b", b).append("obj", obj).toString();
	}
    }
}
