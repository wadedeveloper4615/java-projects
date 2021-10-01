package com.wade.decompiler.classfile.element;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.DataInput;
import java.util.ArrayList;

import org.junit.Test;

import com.wade.decompiler.classfile.attribute.AnnotationEntry;
import com.wade.pojotester.PojoVerifier;

@SuppressWarnings("unused")
public class ElementTest {
    @Test
    public void test1() {
        PojoVerifier.forClass(AnnotationElementValue.class).skipSetters().verified();
        PojoVerifier.forClass(ArrayElementValue.class).skipSetters().verified();
        PojoVerifier.forClass(ClassElementValue.class).skipSetters().verified();
        PojoVerifier.forClass(ElementValuePair.class).skipSetters().skipEquals().skipHashCode().verified();
        PojoVerifier.forClass(EnumElementValue.class).skipSetters().verified();
        PojoVerifier.forClass(SimpleElementValue.class).skipSetters().verified();
    }

    @Test
    public void test2() {
        AnnotationElementValue objectUnderTest1 = new AnnotationElementValue(ElementValue.ANNOTATION, new AnnotationEntry());
        ArrayElementValue objectUnderTest2 = new ArrayElementValue(ElementValue.ARRAY, new ArrayList<>());
        ClassElementValue objectUnderTest3 = new ClassElementValue(1, 1);
        ElementValuePair objectUnderTest4 = new ElementValuePair(1, new ClassElementValue(1, 1));
        EnumElementValue objectUnderTest5 = new EnumElementValue(ElementValue.ENUM_CONSTANT, 0, 0);
        SimpleElementValue objectUnderTest6 = new SimpleElementValue(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3Part1() {
        AnnotationElementValue objectUnderTest1 = new AnnotationElementValue(ElementValue.PRIMITIVE_INT, new AnnotationEntry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3Part2() {
        ArrayElementValue objectUnderTest2 = new ArrayElementValue(ElementValue.PRIMITIVE_INT, new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3Part3() {
        EnumElementValue objectUnderTest2 = new EnumElementValue(ElementValue.PRIMITIVE_INT, 0, 0);
    }

    @Test
    public void test4() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.ENUM_CONSTANT);
        when(is.readUnsignedShort()).thenReturn(0).thenReturn(0);
        EnumElementValue result = (EnumElementValue) ElementValue.readElementValue(is);
        assertThat(result).isNotNull();
        assertThat(result.getType()).isEqualTo(ElementValue.ENUM_CONSTANT);
        assertThat(result.getTypeIdx()).isEqualTo(0);
        assertThat(result.getValueIdx()).isEqualTo(0);
    }

    @Test
    public void test5() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.CLASS);
        when(is.readUnsignedShort()).thenReturn(0);
        ClassElementValue result = (ClassElementValue) ElementValue.readElementValue(is);
        assertThat(result).isNotNull();
        assertThat(result.getType()).isEqualTo(ElementValue.CLASS);
        assertThat(result.getIdx()).isEqualTo(0);
    }

    @Test
    public void test6() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.ANNOTATION).thenReturn(ElementValue.PRIMITIVE_INT);
        when(is.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(0).thenReturn(0);
        AnnotationElementValue result = (AnnotationElementValue) ElementValue.readElementValue(is);
        assertThat(result).isNotNull();
        assertThat(result.getType()).isEqualTo(ElementValue.ANNOTATION);
        assertThat(result.getAnnotationEntry()).isNotNull();
        assertThat(result.getAnnotationEntry().getTypeIndex()).isEqualTo(1);
    }

    @Test
    public void test7() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.ARRAY).thenReturn(ElementValue.PRIMITIVE_INT);
        when(is.readUnsignedShort()).thenReturn(1).thenReturn(2);
        ArrayElementValue result = (ArrayElementValue) ElementValue.readElementValue(is);
        assertThat(result).isNotNull();
        assertThat(result.getType()).isEqualTo(ElementValue.ARRAY);
        assertThat(result.getElementValues()).isNotNull();
        assertThat(result.getElementValues().size()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test8() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn((byte) 'A');
        ElementValue.readElementValue(is);
    }
}
