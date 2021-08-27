package com.wade.decompiler.classfile.attribute;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.DataInput;
import java.io.PrintStream;

import org.junit.Test;

import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.element.ElementValue;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.util.TestUtil;

public class AttributeTest {
    @Test
    public void test_AnnotationDefault() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2);
        when(mockInput.readInt()).thenReturn(5);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("AnnotationDefault");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        AnnotationDefault objectUnderTest = (AnnotationDefault) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_Code() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
        when(mockInput.readUnsignedShort())
          .thenReturn(1)
          .thenReturn(1)
          .thenReturn(1)
          .thenReturn(1)
          .thenReturn(2)
          ;
        //@formatter:on
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("Code");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("LineNumber");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        Code objectUnderTest = (Code) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
    }

    @Test
    public void test_ConstantValue() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("ConstantValue");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        ConstantValue objectUnderTest = (ConstantValue) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
    }

    @Test
    public void test_EnclosingMethod() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(3).thenReturn(4);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("EnclosingMethod");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        EnclosingMethod objectUnderTest = (EnclosingMethod) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_MethodParameters() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedByte()).thenReturn(1);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("MethodParameters");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        MethodParameters objectUnderTest = (MethodParameters) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ModuleMainClass() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedByte()).thenReturn(1);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("ModuleMainClass");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        ModuleMainClass objectUnderTest = (ModuleMainClass) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_NestHost() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedByte()).thenReturn(1);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NestHost");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        NestHost objectUnderTest = (NestHost) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_PMGClass() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(2);
        when(mockInput.readInt()).thenReturn(5);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("PMGClass");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        PMGClass objectUnderTest = (PMGClass) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_SourceFile() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("SourceFile");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        SourceFile objectUnderTest = (SourceFile) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
    }

    @Test
    public void test_StackMap() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(2).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6);
        when(mockInput.readInt()).thenReturn(5);
        when(mockInput.readByte()).thenReturn((byte) 0);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("StackMap");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        StackMap objectUnderTest = (StackMap) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_Synthetic() throws Exception {
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        when(mockInput.readUnsignedShort()).thenReturn(1);
        when(mockInput.readInt()).thenReturn(5);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("Synthetic");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        Synthetic objectUnderTest = (Synthetic) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }
}
