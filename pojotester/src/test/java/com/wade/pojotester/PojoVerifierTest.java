/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.FullPojo;

class PojoVerifierTest {
    @Test
    void test1() {
	PojoVerifier.forClass(FullPojo.class).verified();
    }

    @Test
    void test2() {
	// PojoVerifier.forClass(FullPojoWiths.class).areWellImplemented();
    }
}
