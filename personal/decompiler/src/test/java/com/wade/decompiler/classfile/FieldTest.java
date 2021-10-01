package com.wade.decompiler.classfile;

import org.junit.Test;

import com.wade.pojotester.PojoVerifier;

public class FieldTest {
    @Test
    public void test() {
        //@formatter:off
	PojoVerifier.forClass(Field.class)
	.skipSetters()
	.verified();
	//@formatter:on
    }
}
