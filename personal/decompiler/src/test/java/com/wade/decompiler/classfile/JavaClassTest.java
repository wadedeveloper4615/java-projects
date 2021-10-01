package com.wade.decompiler.classfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.wade.pojotester.PojoVerifier;

public class JavaClassTest {
    private JavaClass load(Class<? extends JavaClassTest> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }

    @Test
    public void test() throws Exception {
        //@formatter:off
	PojoVerifier.forClass(JavaClass.class)
	.skipHashCode()
	.skipToString()
	.skipSetters()
	.verified();
	//@formatter:on
        JavaClass objectUnderTest = load(this.getClass(), "/com/wade/decompiler/test/UnitTest1.class", false);
        PrintStream out = System.out;
        objectUnderTest.toUsefulString(out);
    }
}
