package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.exception.GetterNotFoundException;
import com.wade.pojotester.predicate.FieldPredicate;

import lombok.Getter;

@SuppressWarnings({ "rawtypes", "unused" })
class GetterTesterTest {
    @Test
    void Should_Fail_Multiple_Classes() {
	// given
	Class[] classesToTest = { BadPojoGetter.class, Getters.class };
	GetterTester getterTester = new GetterTester();
	// when
	Throwable result = catchThrowable(() -> getterTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(GetterNotFoundException.class);
    }

    @Test
    void Should_Pass_All_Getter_Tests() {
	// given
	Class[] classesToTest = { GoodPojoGetter.class };
	GetterTester getterTester = new GetterTester(DefaultFieldValueChanger.INSTANCE);
	// when
	Throwable result = catchThrowable(() -> getterTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Getter_Tests_Excluding_Fields() {
	// given
	GetterTester getterTester = new GetterTester();
	Class<?> clazz = BadPojoGetter.class;
	List<String> excludedFields = newArrayList("c", "d", "charY");
	// when
	Throwable result = catchThrowable(() -> getterTester.test(clazz, FieldPredicate.exclude(excludedFields)));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Pass_All_Getter_Tests_Including_Fields() {
	// given
	GetterTester getterTester = new GetterTester();
	Class<?> clazz = BadPojoGetter.class;
	List<String> includedFields = newArrayList("a", "b");
	// when
	Throwable result = catchThrowable(() -> getterTester.test(clazz, FieldPredicate.include(includedFields)));
	// then
	assertThat(result).isNull();
    }

    private class BadPojoGetter {
	public char charY = 'y';
	private int a;
	private int b;
	private int c;
	private int d;

	public int getA() {
	    return a;
	}

	public int getB() {
	    return b;
	}

	public char getX() {
	    return 'x';
	}
    }

    private class Getters {
	boolean getter1;
	boolean getter2;
	boolean getter3;
	Boolean getter4;
	int getter5;
	Integer getter6;
	Boolean getter7;
	private int a;
	private int b;
	private int d;
	private boolean e;
	private boolean f;
	private boolean g;

	public int a() {
	    return 0;
	}

	public Boolean containsGetter4() {
	    return getter4;
	}

	public boolean e() {
	    return false;
	}

	public int get() {
	    return 0;
	}

	public int getB(Object o) {
	    return 0;
	}

	public int getGetter5() {
	    return getter5;
	}

	public Integer getGetter6() {
	    return getter6;
	}

	public Boolean getGetter7() {
	    return getter7;
	}

	public boolean hasGetter2() {
	    return getter2;
	}

	public boolean haveGetter3() {
	    return getter3;
	}

	public boolean isGetter1() {
	    return getter1;
	}

	public boolean issG() {
	    return g;
	}
    }

    @Getter
    private class GoodPojoGetter {
	private int a;
	private int b;
	private int c;
	private int d;
    }
}
