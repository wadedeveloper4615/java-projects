package com.wade.decompiler.classfile;

import org.junit.Test;

import com.wade.pojotester.PojoVerifier;

public class MethodTest {
    @Test
    public void test() {
        //@formatter:off
	PojoVerifier.forClass(Method.class)
	.skipSetters()
	.verified();
	//@formatter:on
    }
}
