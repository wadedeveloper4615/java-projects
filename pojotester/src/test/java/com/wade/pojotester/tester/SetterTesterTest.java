package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.exception.SetterNotFoundException;
import com.wade.pojotester.predicate.FieldPredicate;

import lombok.Setter;

@SuppressWarnings({ "rawtypes", "unused" })
class SetterTesterTest {
    @Test
    void Should_Fail_Multiple_Classes() {
	// given
	Class[] classesToTest = { BadPojoSetter.class, Setters.class };
	SetterTester setterTester = new SetterTester();
	// when
	Throwable result = catchThrowable(() -> setterTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(SetterNotFoundException.class);
    }

    @Test
    void Should_Pass_All_Setter_Tests() {
	// given
	Class[] classesToTest = { GoodPojoSetter.class };
	SetterTester setterTester = new SetterTester(DefaultFieldValueChanger.INSTANCE);
	// when
	Throwable result = catchThrowable(() -> setterTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Setter_Tests_Excluding_Fields() {
	// given
	SetterTester setterTester = new SetterTester();
	Class<?> clazz = BadPojoSetter.class;
	List<String> excludedFields = newArrayList("c", "d", "charY");
	// when
	Throwable result = catchThrowable(() -> setterTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Setter_Tests_Including_Fields() {
	// given
	SetterTester setterTester = new SetterTester();
	Class<?> clazz = BadPojoSetter.class;
	List<String> includedFields = newArrayList("a", "b");
	// when
	Throwable result = catchThrowable(() -> setterTester.test(clazz, FieldPredicate.include(includedFields)));
	// then
	assertThat(result).isNull();
    }

    private class BadPojoSetter {
	public char charY = 'y';
	private int a;
	private int b;
	private int c;
	private int d;

	public void setA(int a) {
	    this.a = a;
	}

	public void setB(int b) {
	    this.b = b;
	}

	public void setX(char x) {
	}
    }

    @Setter
    private class GoodPojoSetter {
	private int a;
	private int b;
	private int c;
	private int d = 0;
    }

    private class Setters {
	int setter1;
	int setter2;
	Integer setter3;
	Integer setter4;
	private int a;
	private int b;
	private int c;
	private int d;
	private int f;
	private int g;

	public void B() {
	}

	public void set() {
	}

	public void setD() {
	}

	public Object setF(int f) {
	    return null;
	}

	public void setSetter1(int setter1) {
	    this.setter1 = setter1;
	}

	public void setSetter2(Integer setter2) {
	    this.setter2 = setter2;
	}

	public void setSetter3(Integer setter3) {
	    this.setter3 = setter3;
	}

	public void setSetter4(int setter4) {
	    this.setter4 = setter4;
	}

	public void setxxxC() {
	}

	public void setXXXXG(int g) {
	    this.g = g;
	}
    }
}
