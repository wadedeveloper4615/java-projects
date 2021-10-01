/*
 *
 */
package com.wade.decompiler.classfile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.wade.decompiler.generate.JavaClassGen;

/**
 * The Class ClassParserTest.
 */
public class ClassParserTest {
    private JavaClass load(Class<? extends ClassParserTest> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }

    /**
     * Test 1.
     *
     * @throws Exception the exception
     */

    @Test
    public void test1() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClass.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.toString());
        assertNotNull(clazz.getFields());
        assertEquals(8, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(1, clazz.getMethods().size());
        assertNotNull(clazz.getAttributes());
        assertEquals(1, clazz.getAttributes().size());
        assertNotNull(clazz.getAttributes().get(0));
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
        assertNotNull(jgen.getFields());
        assertEquals(8, jgen.getFields().size());
        assertNotNull(jgen.getMethods());
        assertEquals(1, jgen.getMethods().size());
        assertNotNull(jgen.getAttributes());
        assertEquals(1, jgen.getAttributes().size());
        assertNotNull(jgen.getAttributes().get(0));
    }

    @Test
    public void test1Compare1() throws Exception {
        JavaClass clazz1 = load(this.getClass(), "/com/wade/decompiler/test/SimpleClass.class", false);
        assertNotNull(clazz1);
        assertFalse(clazz1.equals(null));
        assertTrue(clazz1.equals(clazz1));
    }

    @Test
    public void test1Compare3() throws Exception {
        JavaClass clazz1 = load(this.getClass(), "/com/wade/decompiler/test/SimpleClass.class", false);
        JavaClassGen jgen1 = new JavaClassGen(clazz1, false);
        JavaClass clazz2 = load(this.getClass(), "/com/wade/decompiler/test/SimpleClass.class", false);
        JavaClassGen jgen2 = new JavaClassGen(clazz2, false);
        assertNotNull(clazz1);
        assertNotNull(clazz2);
        assertNotNull(jgen1);
        assertNotNull(jgen2);
        assertNotNull(clazz1.hashCode());
        assertNotNull(jgen1.hashCode());
        assertNotNull(clazz1.toString());
        assertNotNull(jgen1.toString());
    }

    @Test
    public void test2() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithConstantPool.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(9, clazz.getFields().size());
        assertNotNull(clazz.getFields().get(0).toString());
        assertNotNull(clazz.getMethods());
        assertEquals(3, clazz.getMethods().size());
        assertNotNull(clazz.getMethods().get(0).toString());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
    }

    @Test
    public void test3() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithInterfaces.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(15, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(2, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void test4() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithInitializedFields.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(3, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void test5() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SImpleNestedClass.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(1, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void test6() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithBlockStructures.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(9, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void testUnusual1() throws Exception {
        JavaClass clazz = load(this.getClass(), "/java/lang/Object.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(12, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void testUnusual2() throws Exception {
        JavaClass clazz = load(this.getClass(), "/module-info.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(0, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void testUnusual3() throws Exception {
        JavaClassGen jgen = new JavaClassGen(null, false);
        assertThat(jgen).isNotNull();
    }

    @Test
    public void testUnusual4() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/WideInstruction.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(1, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(7, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }

    @Test
    public void testUnusual5() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithAnnotation.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(3, clazz.getMethods().size());
        assertNotNull(clazz.toString());
        PrintStream out = System.out;
        clazz.toUsefulString(out);
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
    }
}
