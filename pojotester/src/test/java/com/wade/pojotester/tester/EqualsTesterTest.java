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

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings({ "rawtypes", "unused" })
class EqualsTesterTest {
    @Test
    void Should_Fail_Different_Object_With_Same_Type() {
	Class[] classesToTest = { BadPojoEqualsDifferentObjectSameType.class };
	EqualsTester equalsTester = new EqualsTester();
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Different_Type_Test() {
	Class[] classesToTest = { BadPojoEqualsDifferentType.class };
	EqualsTester equalsTester = new EqualsTester();
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Itself_Test() {
	Class[] classesToTest = { BadPojoEqualsItself.class };
	EqualsTester equalsTester = new EqualsTester();
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Multiple_Classes() {
	// given
	Class[] classesToTest = { BadPojoEqualsNull.class, BadPojoEqualsDifferentType.class, BadPojoEqualsItself.class };
	EqualsTester equalsTester = new EqualsTester();
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_Null_Test() {
	Class[] classesToTest = { BadPojoEqualsNull.class };
	EqualsTester equalsTester = new EqualsTester();
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Fail_When_Equals_Implementation_Depends_On_Excluded_Field() {
	EqualsTester equalsTester = new EqualsTester();
	Class<?> classToTest = GoodPojo_Equals_HashCode_ToString.class;
	Predicate<String> includedFields = FieldPredicate.include("byteField");
	Throwable result = catchThrowable(() -> equalsTester.test(classToTest, includedFields));
	assertThat(result).isInstanceOf(AbstractEqualsAssertionError.class);
    }

    @Test
    void Should_Pass_All_Equals_Tests() {
	Class[] classesToTest = { GoodPojo_Equals_HashCode_ToString.class };
	EqualsTester equalsTester = new EqualsTester(DefaultFieldValueChanger.INSTANCE);
	Throwable result = catchThrowable(() -> equalsTester.testAll(classesToTest));
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Equals_Tests_Excluding_Fields() {
	EqualsTester equalsTester = new EqualsTester();
	Class<?> clazz = BadPojoEqualsDifferentObjectSameType.class;
	ArrayList<String> excludedFields = newArrayList("notIncludedToEqual_byteField", "notIncludedToEqual_shortType");
	Throwable result = catchThrowable(() -> equalsTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Equals_Tests_Including_Fields() {
	EqualsTester equalsTester = new EqualsTester();
	Class<?> clazz = BadPojoEqualsDifferentObjectSameType.class;
	ArrayList<String> includedFields = newArrayList("byteField", "shortType");
	Throwable result = catchThrowable(() -> equalsTester.test(clazz, FieldPredicate.include(includedFields)));
	assertThat(result).isNull();
    }

    class BadPojoEqualsDifferentObjectSameType {
	private byte byteField;
	private byte notIncludedToEqual_byteField;
	private short notIncludedToEqual_shortType;
	private short shortType;

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

    private class BadPojoEqualsDifferentType {
	private boolean booleanType;
	private byte byteField;
	private char charType;
	private double doubleType;
	private float floatType;
	private int intType;
	private long longType;
	private short shortType;

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

    private class BadPojoEqualsItself {
	private boolean booleanType;
	private byte byteField;
	private char charType;
	private double doubleType;
	private float floatType;
	private int intType;
	private long longType;
	private short shortType;

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
	private boolean booleanType;
	private byte byteField;
	private char charType;
	private double doubleType;
	private float floatType;
	private int intType;
	private long longType;
	private short shortType;

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

    @Getter
    @Setter
    private class GoodPojo_Equals_HashCode_ToString {
	boolean booleanType;
	byte byteField;
	char charType;
	double doubleType;
	float floatType;
	int intType;
	long longType;
	long random;
	short shortType;
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

	@Override
	public int hashCode() {
	    return new HashCodeBuilder().append(random).append(byteField).append(shortType).append(intType).append(longType).append(doubleType).append(booleanType).append(floatType).append(charType).append(testEnum1).toHashCode();
	}

	@Override
	public String toString() {
	    return new ToStringBuilder(this).append("random", random).append("byteField", byteField).append("shortType", shortType).append("intType", intType).append("longType", longType).append("doubleType", doubleType).append("booleanType", booleanType).append("floatType", floatType).append("charType", charType).append("testEnum1", testEnum1).toString();
	}
    }
}
