package com.wade.decompiler.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.wade.decompiler.exceptions.ClassFormatException;

public class TypeSignatureTest {
    @Test(expected = ClassFormatException.class)
    public void test0() {
        new TypeSignature("[M", false);
    }

    @Test(expected = ClassFormatException.class)
    public void test0_1() {
        new TypeSignature("", false);
    }

    @Test
    public void test1() {
        TypeSignature ms = new TypeSignature("[B", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("byte[]");
    }

    @Test
    public void test10() {
        TypeSignature ms = new TypeSignature("Tjava/lang/Object;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/lang/Object");
    }

    @Test
    public void test11() {
        TypeSignature ms = new TypeSignature("Ljava/lang/Object;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/lang/Object");
    }

    @Test
    public void test12() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<Ljava/lang/Object;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<java/lang/Object>");
    }

    @Test
    public void test12_1() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<Ljava/lang/Object;>;Ljava/util/List<Ljava/lang/Object;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<java/lang/Object>");
    }

    @Test
    public void test12_2() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<Ljava/lang/Object;Ljava/lang/Object;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<java/lang/Object, java/lang/Object>");
    }

    @Test
    public void test12_3() {
        TypeSignature ms = new TypeSignature("Ljava/util/List;<Ljava/lang/Object;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List");
    }

    @Test
    public void test12_4() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<+Ljava/lang/String;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<? extends java/lang/String>");
    }

    @Test
    public void test12_5() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<*>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<?>");
    }

    @Test
    public void test12_6() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<-Ljava/lang/String;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<? super java/lang/String>");
    }

    @Test
    public void test12_7() {
        TypeSignature ms = new TypeSignature("Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("java/util/List<java/util/Map<java/lang/String, java/lang/String>>");
    }

    @Test
    public void test2() {
        TypeSignature ms = new TypeSignature("[C", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("char[]");
    }

    @Test
    public void test3() {
        TypeSignature ms = new TypeSignature("[D", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("double[]");
    }

    @Test
    public void test4() {
        TypeSignature ms = new TypeSignature("[F", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("float[]");
    }

    @Test
    public void test5() {
        TypeSignature ms = new TypeSignature("[I", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("int[]");
    }

    @Test
    public void test6() {
        TypeSignature ms = new TypeSignature("[J", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("long[]");
    }

    @Test
    public void test7() {
        TypeSignature ms = new TypeSignature("[S", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("short[]");
    }

    @Test
    public void test8() {
        TypeSignature ms = new TypeSignature("[Z", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("boolean[]");
    }

    @Test
    public void test9() {
        TypeSignature ms = new TypeSignature("[V", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getType()).isNotNull();
        assertThat(ms.getType()).isEqualTo("void[]");
    }
}
