package com.wade.decompiler.generate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.wade.decompiler.classfile.ClassParser;
import com.wade.decompiler.classfile.JavaClass;
import com.wade.pojotester.PojoVerifier;

public class JavaClassGenTest {
    private JavaClass load(Class<? extends JavaClassGenTest> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }

    @Test
    public void test1() throws Exception {
        PojoVerifier.forClass(FieldGen.class).skipSetters().skipToString().verified();
        PojoVerifier.forClass(MethodGen.class).skipSetters().verified();
        PojoVerifier.forClass(JavaClassGen.class).skipToString().skipSetters().verified();
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleInterface.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.toString());
        assertNotNull(clazz.getFields());
        assertEquals(0, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(0, clazz.getMethods().size());
        assertNotNull(clazz.getAttributes());
        assertEquals(1, clazz.getAttributes().size());
        assertNotNull(clazz.getAttributes().get(0));
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
        assertNotNull(jgen.getFields());
        assertEquals(0, jgen.getFields().size());
        assertNotNull(jgen.getMethods());
        assertEquals(0, jgen.getMethods().size());
        assertNotNull(jgen.getAttributes());
        assertEquals(1, jgen.getAttributes().size());
        assertNotNull(jgen.getAttributes().get(0));
    }

    @Test
    public void test2() throws Exception {
        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithSimpleLambda.class", false);
        assertNotNull(clazz);
        assertNotNull(clazz.toString());
        assertNotNull(clazz.getFields());
        assertEquals(1, clazz.getFields().size());
        assertNotNull(clazz.getMethods());
        assertEquals(3, clazz.getMethods().size());
        assertNotNull(clazz.getAttributes());
        assertEquals(3, clazz.getAttributes().size());
        assertNotNull(clazz.getAttributes().get(0));
        JavaClassGen jgen = new JavaClassGen(clazz, false);
        assertNotNull(jgen);
        assertNotNull(jgen.toString());
        assertNotNull(jgen.getFields());
        assertEquals(1, jgen.getFields().size());
        assertNotNull(jgen.getMethods());
        assertEquals(3, jgen.getMethods().size());
        assertNotNull(jgen.getAttributes());
        assertEquals(3, jgen.getAttributes().size());
        assertNotNull(jgen.getAttributes().get(0));
        jgen.toUsefulString(mock(PrintStream.class));
    }
}
