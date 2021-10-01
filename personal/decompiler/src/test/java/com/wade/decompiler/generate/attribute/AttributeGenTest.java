package com.wade.decompiler.generate.attribute;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.Test;

import com.wade.decompiler.classfile.ClassParser;
import com.wade.decompiler.classfile.JavaClass;
import com.wade.decompiler.classfile.attribute.AnnotationDefault;
import com.wade.decompiler.classfile.attribute.AnnotationEntry;
import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.attribute.BootstrapMethods;
import com.wade.decompiler.classfile.attribute.Code;
import com.wade.decompiler.classfile.attribute.ConstantValue;
import com.wade.decompiler.classfile.attribute.EnclosingMethod;
import com.wade.decompiler.classfile.attribute.InnerClasses;
import com.wade.decompiler.classfile.attribute.LineNumberTable;
import com.wade.decompiler.classfile.attribute.LocalVariableTable;
import com.wade.decompiler.classfile.attribute.LocalVariableTypeTable;
import com.wade.decompiler.classfile.attribute.MethodParameter;
import com.wade.decompiler.classfile.attribute.MethodParameters;
import com.wade.decompiler.classfile.attribute.Module;
import com.wade.decompiler.classfile.attribute.ModuleMainClass;
import com.wade.decompiler.classfile.attribute.ModuleOpens;
import com.wade.decompiler.classfile.attribute.ModuleProvides;
import com.wade.decompiler.classfile.attribute.ModuleRequires;
import com.wade.decompiler.classfile.attribute.NestHost;
import com.wade.decompiler.classfile.attribute.PMGClass;
import com.wade.decompiler.classfile.attribute.ParameterAnnotationEntry;
import com.wade.decompiler.classfile.attribute.StackMap;
import com.wade.decompiler.classfile.attribute.StackMapType;
import com.wade.decompiler.classfile.attribute.Synthetic;
import com.wade.decompiler.classfile.attribute.Unknown;
import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantClass;
import com.wade.decompiler.classfile.constant.ConstantDouble;
import com.wade.decompiler.classfile.constant.ConstantFloat;
import com.wade.decompiler.classfile.constant.ConstantInteger;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantNameAndType;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantString;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.element.AnnotationElementValue;
import com.wade.decompiler.classfile.element.ArrayElementValue;
import com.wade.decompiler.classfile.element.ClassElementValue;
import com.wade.decompiler.classfile.element.ElementValue;
import com.wade.decompiler.classfile.element.EnumElementValue;
import com.wade.decompiler.classfile.element.SimpleElementValue;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileAttributes;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.ItemNamesEnum;
import com.wade.decompiler.util.ByteArray;
import com.wade.decompiler.util.TestUtil;
import com.wade.pojotester.PojoVerifier;

@SuppressWarnings("unused")
public class AttributeGenTest {
    private JavaClass load(Class<? extends AttributeGenTest> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }

    @Test
    public void test_AnnotationDefaultGen() throws Exception {
        PojoVerifier.forClass(AnnotationDefaultGen.class).skipSetters().verified();

        AnnotationDefault attribute = mock(AnnotationDefault.class);
        when(attribute.getTag()).thenReturn(ClassFileAttributes.ATTR_ANNOTATION_DEFAULT);
        when(attribute.getNameIndex()).thenReturn(1);
        when(attribute.getLength()).thenReturn(2);
        when(attribute.getDefaultValue()).thenReturn(new SimpleElementValue(ElementValue.PRIMITIVE_INT, 3));

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant1);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        AnnotationDefaultGen objectUnderTest = (AnnotationDefaultGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(objectUnderTest).isNotNull();
        objectUnderTest.printUsefulData(mock(PrintStream.class));
        assertThat(objectUnderTest.getDefaultValue()).isNotNull();
    }

    @Test
    public void test_AnnotationElementValueGen_Part1() throws Exception {
        PojoVerifier.forClass(AnnotationElementValueGen.class).skipSetters().verified();

        AnnotationElementValue data = new AnnotationElementValue(ElementValue.ANNOTATION, new AnnotationEntry(1, false));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        AnnotationElementValueGen objectUnderTest = new AnnotationElementValueGen(ElementValue.ANNOTATION, data);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getAnnotationEntry()).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AnnotationElementValueGen_Part2() throws Exception {
        PojoVerifier.forClass(AnnotationElementValueGen.class).skipSetters().verified();

        AnnotationElementValue data = new AnnotationElementValue(ElementValue.ANNOTATION, new AnnotationEntry(1, false));

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        new AnnotationElementValueGen(ElementValue.PRIMITIVE_INT, data);
    }

    @Test
    public void test_AnnotationEntryGen() {
        PojoVerifier.forClass(AnnotationEntryGen.class).skipSetters().verified();
    }

    @Test
    public void test_AnnotationsGen() {
        PojoVerifier.forClass(AnnotationsGen.class).skipSetters().verified();
        new AnnotationsGen().printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ArrayElementValueGen() {
        PojoVerifier.forClass(ArrayElementValueGen.class).skipSetters().verified();
    }

    @Test
    public void test_AttributeGen() throws Exception {
        PojoVerifier.forClass(AttributeGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Unknown data = new Unknown(1, 1, mockInput);

        ConstantUtf8 constant = mock(ConstantUtf8.class);
        when(constant.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant);
        cp = TestUtil.add(cp, constant);

        AttributeGen objectUnderTest = new AttributeGen(data, cp);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_BootstrapMethodGen() {
        PojoVerifier.forClass(BootstrapMethodGen.class).skipSetters().verified();
    }

    @Test
    public void test_BootstrapMethodsGen() throws Exception {
        PojoVerifier.forClass(BootstrapMethodsGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(1).thenReturn(3);
        BootstrapMethods data = new BootstrapMethods(2, 10, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME2");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        BootstrapMethodsGen objectUnderTest = new BootstrapMethodsGen(data, cp);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ClassElementValueGen() throws Exception {
        PojoVerifier.forClass(ClassElementValueGen.class).skipSetters().verified();

        ClassElementValue data = new ClassElementValue(ElementValue.PRIMITIVE_INT, 1);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        ClassElementValueGen objectUnderTest = new ClassElementValueGen(ElementValue.ENUM_CONSTANT, data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getIndex()).isNotNull();
        assertThat(objectUnderTest.getIndex()).isEqualTo("NAME1");
    }

    @Test
    public void test_CodeExceptionGen() {
        PojoVerifier.forClass(CodeExceptionGen.class).skipSetters().verified();
    }

    @Test
    public void test_CodeGen() throws Exception {
        PojoVerifier.forClass(CodeGen.class).skipSetters().verified();

        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClass.class", false);
        Code code = (Code) clazz.getMethods().get(0).getAttributes().get(0);
        code.printUsefulData(mock(PrintStream.class));

        CodeGen objectUnderTest = new CodeGen(code, clazz.getConstantPool(), false);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test(expected = IllegalStateException.class)
    public void test_ConstantValueGen_Exception() throws Exception {
        PojoVerifier.forClass(ConstantValueGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ConstantValue data = new ConstantValue(1, 2, mockInput);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME2");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ConstantValueGen objectUnderTest = new ConstantValueGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ConstantValueGen_Part1() throws Exception {
        PojoVerifier.forClass(ConstantValueGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ConstantValue data = new ConstantValue(1, 2, mockInput);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME");

        ConstantLong constant2 = mock(ConstantLong.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Long);
        when(constant2.getBytes()).thenReturn(5);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ConstantValueGen objectUnderTest = new ConstantValueGen(data, cp);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getValue()).isNotNull();
    }

    @Test
    public void test_ConstantValueGen_Part2() throws Exception {
        PojoVerifier.forClass(ConstantValueGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ConstantValue data = new ConstantValue(1, 2, mockInput);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME");

        ConstantFloat constant2 = mock(ConstantFloat.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Float);
        when(constant2.getBytes()).thenReturn(BigDecimal.valueOf(5.0f));

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ConstantValueGen objectUnderTest = new ConstantValueGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getValue()).isNotNull();
    }

    @Test
    public void test_ConstantValueGen_Part3() throws Exception {
        PojoVerifier.forClass(ConstantValueGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ConstantValue data = new ConstantValue(1, 2, mockInput);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME");

        ConstantDouble constant2 = mock(ConstantDouble.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Double);
        when(constant2.getBytes()).thenReturn(BigDecimal.valueOf(5.0));

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ConstantValueGen objectUnderTest = new ConstantValueGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getValue()).isNotNull();
    }

    @Test
    public void test_ConstantValueGen_Part4() throws Exception {
        PojoVerifier.forClass(ConstantValueGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ConstantValue data = new ConstantValue(1, 2, mockInput);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME");

        ConstantInteger constant2 = mock(ConstantInteger.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Integer);
        when(constant2.getBytes()).thenReturn(BigDecimal.valueOf(5));

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ConstantValueGen objectUnderTest = new ConstantValueGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getValue()).isNotNull();
    }

    @Test
    public void test_ConstantValueGen_Part5() throws Exception {
        PojoVerifier.forClass(ConstantValueGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ConstantValue data = new ConstantValue(1, 2, mockInput);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");

        ConstantString constant2 = mock(ConstantString.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_String);
        when(constant2.getStringIndex()).thenReturn(3);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("NAME2");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ConstantValueGen objectUnderTest = new ConstantValueGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getValue()).isNotNull();
    }

    @Test
    public void test_DeprecatedGen() {
        PojoVerifier.forClass(DeprecatedGen.class).skipSetters().verified();
        new DeprecatedGen().printUsefulData(mock(PrintStream.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ElementValue_Exception() throws Exception {
        DataInput is = mock(DataInput.class);
        ElementValue mockElement = mock(ElementValue.class);
        when(mockElement.getType()).thenReturn((int) 'A');

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        ElementValueGen.readElementValue(mockElement, cp);
    }

    @Test
    public void test_ElementValue_Part1() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.ENUM_CONSTANT);
        when(is.readUnsignedShort()).thenReturn(1).thenReturn(2);
        EnumElementValue result = (EnumElementValue) ElementValue.readElementValue(is);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ElementValueGen objectUnderTest = ElementValueGen.readElementValue(result, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ElementValue_Part2() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.CLASS);
        when(is.readUnsignedShort()).thenReturn(1);
        ClassElementValue result = (ClassElementValue) ElementValue.readElementValue(is);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ElementValueGen objectUnderTest = ElementValueGen.readElementValue(result, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ElementValue_Part3() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.ANNOTATION).thenReturn(ElementValue.PRIMITIVE_INT);
        when(is.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(0).thenReturn(0);
        AnnotationElementValue result = (AnnotationElementValue) ElementValue.readElementValue(is);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ElementValueGen objectUnderTest = ElementValueGen.readElementValue(result, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ElementValue_Part4() throws Exception {
        DataInput is = mock(DataInput.class);
        when(is.readByte()).thenReturn(ElementValue.ARRAY).thenReturn(ElementValue.PRIMITIVE_INT);
        when(is.readUnsignedShort()).thenReturn(1).thenReturn(2);
        ArrayElementValue result = (ArrayElementValue) ElementValue.readElementValue(is);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ElementValueGen objectUnderTest = ElementValueGen.readElementValue(result, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ElementValuePairGen() {
        PojoVerifier.forClass(ElementValuePairGen.class).skipSetters().verified();
    }

    @Test
    public void test_EnclosingMethodGen() throws Exception {
        PojoVerifier.forClass(EnclosingMethodGen.class).skipSetters().verified();

        EnclosingMethod attribute = mock(EnclosingMethod.class);
        when(attribute.getTag()).thenReturn(ClassFileAttributes.ATTR_ENCLOSING_METHOD);
        when(attribute.getLength()).thenReturn(5);
        when(attribute.getNameIndex()).thenReturn(1);
        when(attribute.getClassIndex()).thenReturn(2);
        when(attribute.getMethodIndex()).thenReturn(3);

        Constant constant0 = null;

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME");

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getNameIndex()).thenReturn(4);

        ConstantNameAndType constant3 = mock(ConstantNameAndType.class);
        when(constant3.getNameIndex()).thenReturn(5);
        when(constant3.getSignatureIndex()).thenReturn(6);

        ConstantUtf8 constant4 = mock(ConstantUtf8.class);
        when(constant4.getBytes()).thenReturn("STRING1");

        ConstantUtf8 constant5 = mock(ConstantUtf8.class);
        when(constant5.getBytes()).thenReturn("STRING2");

        ConstantUtf8 constant6 = mock(ConstantUtf8.class);
        when(constant6.getBytes()).thenReturn("STRING3");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);
        cp = TestUtil.add(cp, constant4);
        cp = TestUtil.add(cp, constant5);
        cp = TestUtil.add(cp, constant6);

        EnclosingMethodGen result = (EnclosingMethodGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(result).isNotNull();
        result.printUsefulData(mock(PrintStream.class));
        assertThat(result.getSuperName()).isEqualTo("STRING1");
        assertThat(result.getMethodName()).isEqualTo("STRING2");
        assertThat(result.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_EnumElementValueGen() throws Exception {
        PojoVerifier.forClass(EnumElementValueGen.class).skipSetters().verified();

        EnumElementValue data = new EnumElementValue(ElementValue.ENUM_CONSTANT, 1, 2);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME2");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        EnumElementValueGen objectUnderTest = new EnumElementValueGen(ElementValue.ENUM_CONSTANT, data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTypeName()).isNotNull();
        assertThat(objectUnderTest.getValueName()).isNotNull();
        assertThat(objectUnderTest.getTypeName()).isEqualTo("NAME1");
        assertThat(objectUnderTest.getValueName()).isEqualTo("NAME2");
    }

    @Test
    public void test_ExceptionTableGen() {
        PojoVerifier.forClass(ExceptionTableGen.class).skipSetters().verified();
        new ExceptionTableGen().printUsefulData(mock(PrintStream.class));
    }

    @Test(expected = IllegalStateException.class)
    public void test_IllegalAttribute() throws Exception {
        Attribute attribute = mock(Attribute.class);
        when(attribute.getTag()).thenReturn(ClassFileAttributes.ATTR_ILLEGAL);
        when(attribute.getNameIndex()).thenReturn(1);

        ConstantUtf8 constant = mock(ConstantUtf8.class);
        when(constant.getBytes()).thenReturn("STRING");
        ConstantPool cp = TestUtil.createConstantPool(constant);
        cp = TestUtil.add(cp, constant);

        AttributeGen.readAttribute(attribute, cp, false);
    }

    @Test
    public void test_InnerClassesGen() throws Exception {
        PojoVerifier.forClass(InnerClassesGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        ConstantPool mockConstantPool = mock(ConstantPool.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5);
        InnerClasses data = new InnerClasses(1, 2, mockInput, mockConstantPool, false);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME2");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        InnerClassesGen objectUnderTest = new InnerClassesGen(data, cp, false);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_InnerClassGen() {
        PojoVerifier.forClass(InnerClassGen.class).skipSetters().verified();
    }

    @Test
    public void test_LineNumberGen() {
        PojoVerifier.forClass(LineNumberGen.class).skipSetters().verified();
    }

    @Test
    public void test_LineNumberTableGen() throws Exception {
        PojoVerifier.forClass(LineNumberTableGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2);
        LineNumberTable data = new LineNumberTable(3, 4, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME2");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        LineNumberTableGen objectUnderTest = new LineNumberTableGen(data, cp);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_LocalVariableGen() {
        PojoVerifier.forClass(LocalVariableGen.class).skipSetters().verified();
    }

    @Test
    public void test_LocalVariableTableGen() throws Exception {
        PojoVerifier.forClass(LocalVariableTableGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(4).thenReturn(5);
        LocalVariableTable data = new LocalVariableTable(3, 4, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME2");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        LocalVariableTableGen objectUnderTest = new LocalVariableTableGen(data, cp);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_LocalVariableTypeTableGen() throws Exception {
        PojoVerifier.forClass(LocalVariableTypeTableGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6);
        LocalVariableTypeTable data = new LocalVariableTypeTable(1, 2, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME1");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        LocalVariableTypeTableGen objectUnderTest = new LocalVariableTypeTableGen(data, cp);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_MethodParameterGen() throws Exception {
        PojoVerifier.forClass(MethodParameterGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2).thenReturn(3);
        MethodParameter data = new MethodParameter(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME1");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        MethodParameterGen objectUnderTest = new MethodParameterGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_MethodParametersGen() throws Exception {
        PojoVerifier.forClass(MethodParametersGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedByte()).thenReturn(1);
        when(mockInput.readUnsignedShort()).thenReturn(2).thenReturn(3);
        MethodParameters attribute = new MethodParameters(1, 2, mockInput);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant1);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        MethodParametersGen result = (MethodParametersGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(result).isNotNull();
        result.printUsefulData(mock(PrintStream.class));
        assertThat(result.getParameters()).isNotNull();
        assertThat(result.getParameters().size()).isEqualTo(1);
    }

    @Test
    public void test_ModuleExportsGen() {
        PojoVerifier.forClass(ModuleExportsGen.class).skipSetters().verified();
    }

    @Test
    public void test_ModuleGen() throws Exception {
        PojoVerifier.forClass(ModuleGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(1).thenReturn(1);
        Module data = new Module(1, 2, mockInput);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);
        when(constant2.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant1);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);

        ModuleGen objectUnderTest = new ModuleGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ModuleMainClassGen() throws Exception {
        PojoVerifier.forClass(ModuleMainClassGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        ModuleMainClass attribute = new ModuleMainClass(1, 5, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME");

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getNameIndex()).thenReturn(3);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ModuleMainClassGen result = (ModuleMainClassGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(result).isNotNull();
        result.printUsefulData(mock(PrintStream.class));
        assertThat(result.getName()).isEqualTo("NAME");
        assertThat(result.getNameIndex()).isEqualTo(1);
        assertThat(result.getLength()).isEqualTo(5);
        assertThat(result.getClassName()).isEqualTo("STRING");
    }

    @Test
    public void test_ModuleOpensGen() throws Exception {
        PojoVerifier.forClass(ModuleOpensGen.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(1).thenReturn(3);
        ModuleOpens data = new ModuleOpens(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getNameIndex()).thenReturn(3);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("NAME2");
        when(constant3.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ModuleOpensGen attribute = new ModuleOpensGen(data, cp);
        assertThat(attribute).isNotNull();
        assertThat(attribute.getOpensFlags()).isEqualTo(new ClassAccessFlagsList(2));
        assertThat(attribute.getOpensToIndex()).isNotNull();
        assertThat(attribute.getPackage_name()).isEqualTo("NAME1");
    }

    @Test
    public void test_ModulePackagesGen() {
        PojoVerifier.forClass(ModulePackagesGen.class).skipSetters().verified();
        new ModulePackagesGen().printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ModuleProvidesGen() throws Exception {
        PojoVerifier.forClass(ModuleProvidesGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3);
        ModuleProvides data = new ModuleProvides(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getNameIndex()).thenReturn(3);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("NAME2");
        when(constant3.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ModuleProvidesGen attribute = new ModuleProvidesGen(data, cp);
        assertThat(attribute).isNotNull();
        assertThat(attribute.getProvidesIndex()).isNotNull();
        assertThat(attribute.getInterfaceName()).isEqualTo("NAME1");
    }

    @Test
    public void test_ModuleRequiresGen() throws Exception {
        PojoVerifier.forClass(ModuleRequiresGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3);
        ModuleRequires data = new ModuleRequires(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getNameIndex()).thenReturn(3);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("NAME2");
        when(constant3.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ModuleRequiresGen objectUnderTest = new ModuleRequiresGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_NestHostGen() throws Exception {
        PojoVerifier.forClass(NestHostGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        NestHost attribute = new NestHost(1, 2, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getNameIndex()).thenReturn(3);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        NestHostGen result = (NestHostGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(result).isNotNull();
        result.printUsefulData(mock(PrintStream.class));
        assertThat(result.getHostClassName()).isEqualTo("STRING");
    }

    @Test
    public void test_NestMembersGen() {
        PojoVerifier.forClass(NestMembersGen.class).skipSetters().verified();
        new NestMembersGen().printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ParameterAnnotationEntryGen() throws Exception {
        PojoVerifier.forClass(ParameterAnnotationEntryGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        ParameterAnnotationEntry data = new ParameterAnnotationEntry(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("NAME2");
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("NAME3");
        when(constant3.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        ParameterAnnotationEntryGen objectUnderTest = new ParameterAnnotationEntryGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_ParameterAnnotationsGen() {
        PojoVerifier.forClass(ParameterAnnotationsGen.class).skipSetters().verified();
        new ParameterAnnotationsGen().printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_PMGClassGen() throws Exception {
        PojoVerifier.forClass(PMGClassGen.class).skipSetters().verified();

        PMGClass attribute = mock(PMGClass.class);
        when(attribute.getTag()).thenReturn(ClassFileAttributes.ATTR_PMG);
        when(attribute.getNameIndex()).thenReturn(1);
        when(attribute.getPmgIndex()).thenReturn(2);
        when(attribute.getPmgClassIndex()).thenReturn(3);
        when(attribute.getLength()).thenReturn(4);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING1");

        ConstantUtf8 constant2 = mock(ConstantUtf8.class);
        when(constant2.getBytes()).thenReturn("STRING2");

        ConstantPool cp = TestUtil.createConstantPool(constant1);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant2);

        PMGClassGen result = (PMGClassGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(result).isNotNull();
        result.printUsefulData(mock(PrintStream.class));
        assertThat(result.getPmg()).isEqualTo("STRING1");
        assertThat(result.getPmgClass()).isEqualTo("STRING2");
        assertThat(result).isNotNull();
    }

    @Test
    public void test_RuntimeInvisibleAnnotationsGen() {
        PojoVerifier.forClass(RuntimeInvisibleAnnotationsGen.class).skipSetters().verified();
    }

    @Test
    public void test_RuntimeInvisibleParameterAnnotationsGen() {
        PojoVerifier.forClass(RuntimeInvisibleParameterAnnotationsGen.class).skipSetters().verified();
    }

    @Test
    public void test_RuntimeVisibleAnnotationsGen() {
        PojoVerifier.forClass(RuntimeVisibleAnnotationsGen.class).skipSetters().verified();
    }

    @Test
    public void test_RuntimeVisibleParameterAnnotationsGen() {
        PojoVerifier.forClass(RuntimeVisibleParameterAnnotationsGen.class).skipSetters().verified();
    }

    @Test
    public void test_SignatureGen() {
        PojoVerifier.forClass(SignatureGen.class).skipSetters().verified();
        new SignatureGen().printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_SimpleElementValueGen() throws Exception {
        PojoVerifier.forClass(SimpleElementValueGen.class).skipSetters().verified();

        SimpleElementValue data = new SimpleElementValue(ElementValue.ANNOTATION, 1);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        SimpleElementValueGen objectUnderTest = new SimpleElementValueGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_SourceFileGen() {
        PojoVerifier.forClass(SourceFileGen.class).skipSetters().verified();
        new SourceFileGen().printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_StackMapEntryGen() {
        PojoVerifier.forClass(StackMapEntryGen.class).skipSetters().verified();
    }

    @Test
    public void test_StackMapGen() throws Exception {
        PojoVerifier.forClass(StackMapGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6);
        when(mockInput.readByte()).thenReturn((byte) 0);
        StackMap data = new StackMap(1, 1, mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("NAME1");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        StackMapGen objectUnderTest = new StackMapGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getMap()).isNotNull();
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_StackMapTypeGenPart1() throws Exception {
        PojoVerifier.forClass(StackMapTypeGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
        StackMapType data = new StackMapType(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        StackMapTypeGen objectUnderTest = new StackMapTypeGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getName()).isEqualTo("unknown(-1)");
    }

    @Test
    public void test_StackMapTypeGenPart2() throws Exception {
        PojoVerifier.forClass(StackMapTypeGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn((byte) ItemNamesEnum.ITEM_Object.getTag());
        when(mockInput.readShort()).thenReturn((short) 2);
        StackMapType data = new StackMapType(mockInput);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("STRING");

        ConstantClass constant2 = mock(ConstantClass.class);
        when(constant2.getTag()).thenReturn(ClassFileConstants.CONSTANT_Class);
        when(constant2.getNameIndex()).thenReturn(3);

        ConstantUtf8 constant3 = mock(ConstantUtf8.class);
        when(constant3.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);
        cp = TestUtil.add(cp, constant2);
        cp = TestUtil.add(cp, constant3);

        StackMapTypeGen objectUnderTest = new StackMapTypeGen(data, cp);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getName()).isEqualTo("STRING");
    }

    @Test
    public void test_SyntheticGen() throws Exception {
        PojoVerifier.forClass(SyntheticGen.class).skipSetters().verified();

        Synthetic attribute = mock(Synthetic.class);
        when(attribute.getBytes()).thenReturn(new ByteArray());
        when(attribute.getTag()).thenReturn(ClassFileAttributes.ATTR_SYNTHETIC);
        when(attribute.getNameIndex()).thenReturn(1);
        when(attribute.getLength()).thenReturn(1);

        ConstantUtf8 constant = mock(ConstantUtf8.class);
        when(constant.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant);
        cp = TestUtil.add(cp, constant);

        SyntheticGen objectUnderTest = (SyntheticGen) AttributeGen.readAttribute(attribute, cp, false);
        assertThat(objectUnderTest).isNotNull();
        objectUnderTest.printUsefulData(mock(PrintStream.class));
        assertThat(objectUnderTest.getBytes()).isNotNull();
    }

    @Test
    public void test_UnknownGen() throws Exception {
        PojoVerifier.forClass(StackMapTypeGen.class).skipSetters().verified();

        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Unknown data = new Unknown(1, 1, mockInput);

        ConstantUtf8 constant = mock(ConstantUtf8.class);
        when(constant.getBytes()).thenReturn("STRING");

        ConstantPool cp = TestUtil.createConstantPool(constant);
        cp = TestUtil.add(cp, constant);

        UnknownGen objectUnderTest = new UnknownGen(data, cp);
        assertThat(objectUnderTest).isNotNull();

        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }
}
