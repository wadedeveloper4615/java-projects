package com.wade.decompiler.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.wade.decompiler.exceptions.ClassFormatException;

public class MethodSignatureTest {
    @Test(expected = ClassFormatException.class)
    public void test0() {
        new MethodSignature("([M", false);
    }

    @Test(expected = ClassFormatException.class)
    public void test1() {
        new MethodSignature("", false);
    }

    @Test
    public void test2() {
        MethodSignature ms = new MethodSignature("(Tjava/lang/Object;)V", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getReturnType()).isNotNull();
        assertThat(ms.getParameters()).isNotNull();
    }

    @Test
    public void test3() {
        MethodSignature ms = new MethodSignature("(Ljava/util/List<+Ljava/lang/String;>;)V", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getReturnType()).isNotNull();
        assertThat(ms.getParameters()).isNotNull();
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("java/util/List<? extends java/lang/String>");
        assertThat(ms.getParameters().size()).isEqualTo(1);
    }

    @Test
    public void test4() {
        MethodSignature ms = new MethodSignature("(Ljava/util/List<*>;)V", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getReturnType()).isNotNull();
        assertThat(ms.getParameters()).isNotNull();
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("java/util/List<?>");
        assertThat(ms.getParameters().size()).isEqualTo(1);
    }

    @Test
    public void test5() {
        MethodSignature ms = new MethodSignature("(Ljava/util/List<-Ljava/lang/String;>;)V", false);
        assertThat(ms).isNotNull();
        assertThat(ms.getReturnType()).isNotNull();
        assertThat(ms.getParameters()).isNotNull();
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("java/util/List<? super java/lang/String>");
        assertThat(ms.getParameters().size()).isEqualTo(1);
    }

    @Test
    public void testMethodSignatureArrayPrimitives() {
        MethodSignature ms = new MethodSignature("([B[C[D[F[I[J[V[Z[S)I", false);
        assertThat(ms.getReturnType()).isNotNull();
        assertThat(ms.getParameters()).isNotNull();
        assertThat(ms.getReturnType().getType()).isEqualTo("int");
        assertThat(ms.getParameters().size()).isEqualTo(9);
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("byte[]");
        assertThat(ms.getParameters().get(1).getType()).isEqualTo("char[]");
        assertThat(ms.getParameters().get(2).getType()).isEqualTo("double[]");
        assertThat(ms.getParameters().get(3).getType()).isEqualTo("float[]");
        assertThat(ms.getParameters().get(4).getType()).isEqualTo("int[]");
        assertThat(ms.getParameters().get(5).getType()).isEqualTo("long[]");
        assertThat(ms.getParameters().get(6).getType()).isEqualTo("void[]");
        assertThat(ms.getParameters().get(7).getType()).isEqualTo("boolean[]");
        assertThat(ms.getParameters().get(8).getType()).isEqualTo("short[]");
        assertNotNull(ms.toString());
        assertNotNull(ms.hashCode());
    }

    @Test
    public void testMethodSignaturePrimitives() {
        MethodSignature ms = new MethodSignature("(BCDFIJVZS)I", false);
        assertThat(ms.getReturnType()).isNotNull();
        assertThat(ms.getParameters()).isNotNull();
        assertThat(ms.getReturnType().getType()).isEqualTo("int");
        assertThat(ms.getParameters().size()).isEqualTo(9);
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("byte");
        assertThat(ms.getParameters().get(1).getType()).isEqualTo("char");
        assertThat(ms.getParameters().get(2).getType()).isEqualTo("double");
        assertThat(ms.getParameters().get(3).getType()).isEqualTo("float");
        assertThat(ms.getParameters().get(4).getType()).isEqualTo("int");
        assertThat(ms.getParameters().get(5).getType()).isEqualTo("long");
        assertThat(ms.getParameters().get(6).getType()).isEqualTo("void");
        assertThat(ms.getParameters().get(7).getType()).isEqualTo("boolean");
        assertThat(ms.getParameters().get(8).getType()).isEqualTo("short");
        assertNotNull(ms.toString());
        assertNotNull(ms.hashCode());
    }

    @Test
    public void testMethodSignatureReferences() {
        MethodSignature ms = new MethodSignature("(ILjava/lang/Object;J)V", false);
        assertNotNull(ms.getReturnType());
        assertThat(ms.getReturnType().getType()).isEqualTo("void");
        assertThat(ms.getParameters().size()).isEqualTo(3);
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("int");
        assertThat(ms.getParameters().get(1).getType()).isEqualTo("java/lang/Object");
        assertThat(ms.getParameters().get(2).getType()).isEqualTo("long");
        assertNotNull(ms.toString());
        assertNotNull(ms.hashCode());
    }

    @Test
    public void testMethodSignatureReturnValue() {
        MethodSignature ms = new MethodSignature("()[Lcom/wade/decompiler/test/SimpleEnum;", false);
        assertNotNull(ms.getReturnType());
        assertThat(ms.getReturnType().getType()).isEqualTo("com/wade/decompiler/test/SimpleEnum[]");
        assertThat(ms.getParameters().size()).isEqualTo(0);
        assertNotNull(ms.toString());
        assertNotNull(ms.hashCode());
    }

    @Test
    public void testMethodSignatureWithTemplates1() {
        MethodSignature ms = new MethodSignature("()Ljava/util/List<Ljava/lang/String;>;", false);
        assertNotNull(ms.getReturnType());
        assertThat(ms.getReturnType().getType()).isEqualTo("java/util/List<java/lang/String>");
        assertThat(ms.getParameters().size()).isEqualTo(0);
        assertNotNull(ms.toString());
        assertNotNull(ms.hashCode());
    }

    @Test
    public void testMethodSignatureWithTemplates2() {
        MethodSignature ms = new MethodSignature("(Ljava/util/List<Ljava/lang/Object;>;Ljava/util/List<Ljava/lang/Object;>;Ljava/util/List<Ljava/lang/Object;>;)V", true);
        assertNotNull(ms.getReturnType());
        assertThat(ms.getReturnType().getType()).isEqualTo("void");
        assertThat(ms.getParameters().size()).isEqualTo(3);
        assertThat(ms.getParameters().get(0).getType()).isEqualTo("java/util/List<java/lang/Object>");
        assertThat(ms.getParameters().get(1).getType()).isEqualTo("java/util/List<java/lang/Object>");
        assertThat(ms.getParameters().get(2).getType()).isEqualTo("java/util/List<java/lang/Object>");
        assertNotNull(ms.toString());
        assertNotNull(ms.hashCode());
    }
}
