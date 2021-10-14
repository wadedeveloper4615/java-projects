package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.assertion.equals.AbstractEqualsAssertionError;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.testfiles.fields.TestEnum1;
import com.wade.pojotester.util.SublistFieldPermutator;

@SuppressWarnings({ "rawtypes", "unused" })
class EqualsFastTesterTest {
    @Test
    void Should_Fail_Different_Object_With_Same_Type() {
	// given
	Class[] classesToTest = { BadPojoEqualsDifferentObjectSameType.class };
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	// when
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Different_Type_Test() {
	// given
	Class[] classesToTest = { BadPojoEqualsDifferentType.class };
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	// when
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Itself_Test() {
	// given
	Class[] classesToTest = { BadPojoEqualsItself.class };
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	// when
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Multiple_Classes() {
	// given
	Class[] classesToTest = { BadPojoEqualsNull.class, BadPojoEqualsDifferentType.class, BadPojoEqualsItself.class };
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	// when
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Null_Test() {
	// given
	Class[] classesToTest = { BadPojoEqualsNull.class };
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	// when
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_When_Equals_Implementation_Depends_On_Excluded_Field() {
	// given
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	Class<?> classToTest = GoodPojo_Equals_HashCode_ToString.class;
	Predicate<String> includedFields = FieldPredicate.include("byteField");
	// when
	Throwable result = catchThrowable(() -> equalsTester.test(classToTest, includedFields));
	// then
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Pass_All_Equals_Tests() {
	// given
	Class[] classesToTest = { GoodPojo_Equals_HashCode_ToString.class };
	EqualsTester equalsTester = new EqualsTester(DefaultFieldValueChanger.INSTANCE);
	equalsTester.setPermutator(new SublistFieldPermutator());
	// when
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Equals_Tests_Excluding_Fields() {
	// given
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	Class<?> clazz = BadPojoEqualsDifferentObjectSameType.class;
	ArrayList<String> excludedFields = newArrayList("notIncludedToEqual_byteField", "notIncludedToEqual_shortType");
	// when
	Throwable result = catchThrowable(() -> equalsTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Equals_Tests_Including_Fields() {
	// given
	EqualsTester equalsTester = new EqualsTester();
	equalsTester.setPermutator(new SublistFieldPermutator());
	Class<?> clazz = BadPojoEqualsDifferentObjectSameType.class;
	ArrayList<String> includedFields = newArrayList("byteField", "shortType");
	// when
	Throwable result = catchThrowable(() -> equalsTester.test(clazz, FieldPredicate.include(includedFields)));
	// then
	assertThat(result).isNull();
    }

    class BadPojoEqualsDifferentObjectSameType {
	private byte byteField;
	private short shortType;
	private byte notIncludedToEqual_byteField;
	private short notIncludedToEqual_shortType;

	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
		return false;
	    }
	    BadPojoEqualsDifferentObjectSameType that = (BadPojoEqualsDifferentObjectSameType) o;
	    return new EqualsBuilder().append(byteField, that.byteField).append(shortType, that.shortType).isEquals();
	}

	@Override
	public int hashCode() {
	    return new HashCodeBuilder().append(byteField).append(shortType).toHashCode();
	}

	@Override
	public String toString() {
	    return byteField + " " + shortType + " " + notIncludedToEqual_byteField + " " + notIncludedToEqual_shortType;
	}
    }

    class BadPojoEqualsDifferentType {
	private byte byteField;
	private short shortType;
	private int intType;
	private long longType;
	private double doubleType;
	private boolean booleanType;
	private char charType;
	private float floatType;

	@Override
	public boolean equals(Object o) {
	    if (o == null) {
		return false;
	    }
	    return o.getClass() != getClass();
	}

	@Override
	public int hashCode() {
	    return 1;
	}

	@Override
	public String toString() {
	    return "";
	}
    }

    class BadPojoEqualsItself {
	private byte byteField;
	private short shortType;
	private int intType;
	private long longType;
	private double doubleType;
	private boolean booleanType;
	private char charType;
	private float floatType;

	@Override
	public boolean equals(Object o) {
	    if (o == null || o.getClass() != getClass()) {
		return false;
	    }
	    return o != this;
	}

	@Override
	public int hashCode() {
	    return 1;
	}

	@Override
	public String toString() {
	    return "";
	}
    }

    class BadPojoEqualsNull {
	private byte byteField;
	private short shortType;
	private int intType;
	private long longType;
	private double doubleType;
	private boolean booleanType;
	private char charType;
	private float floatType;

	@Override
	public boolean equals(Object o) {
	    return o == null;
	}

	@Override
	public int hashCode() {
	    return 1;
	}

	@Override
	public String toString() {
	    return new ToStringBuilder(this).append("byteField", byteField).append("shortType", shortType).append("intType", intType).append("longType", longType).append("doubleType", doubleType).append("booleanType", booleanType).append("charType", charType).append("floatType", floatType).toString();
	}
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
}
