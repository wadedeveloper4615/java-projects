package com.wade.decompiler.classfile.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.wade.decompiler.classfile.ClassParser;
import com.wade.decompiler.classfile.JavaClass;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.exceptions.ClassFormatException;
import com.wade.pojotester.PojoVerifier;

@RunWith(MockitoJUnitRunner.class)
public class ConstantTest {
    @Mock
    DataInput mockInput;

    private JavaClass load(Class<? extends ConstantTest> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() throws Exception {
        PojoVerifier.forClass(Constant.class).skipSetters().skipToString().verified();
        when(mockInput.readByte()).thenReturn(ClassFileConstants.CONSTANT_Dynamic.getTag());
        Constant objectUnderTest = Constant.readConstant(mockInput);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test10() throws Exception {
        PojoVerifier.forClass(ConstantInvokeDynamic.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readInt())
	.thenReturn(2);
	//@formatter:on
        ConstantInvokeDynamic objectUnderTest = new ConstantInvokeDynamic(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_InvokeDynamic);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getNameAndTypeIndex()).isNotNull();
    }

    @Test
    public void test11() throws Exception {
        PojoVerifier.forClass(ConstantMethodHandle.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedByte())
	.thenReturn(1);
	when(mockInput.readUnsignedShort())
	.thenReturn(2);
	//@formatter:on
        ConstantMethodHandle objectUnderTest = new ConstantMethodHandle(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_MethodHandle);
        assertThat(objectUnderTest.getReferenceKind()).isNotNull();
        assertThat(objectUnderTest.getReferenceIndex()).isNotNull();
    }

    @Test
    public void test12() throws Exception {
        PojoVerifier.forClass(ConstantMethodref.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedByte())
	.thenReturn(1);
	when(mockInput.readUnsignedShort())
	.thenReturn(2);
	//@formatter:on
        ConstantMethodref objectUnderTest = new ConstantMethodref(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Methodref);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getNameAndTypeIndex()).isNotNull();
    }

    @Test
    public void test13() throws Exception {
        PojoVerifier.forClass(ConstantMethodType.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1);
	//@formatter:on
        ConstantMethodType objectUnderTest = new ConstantMethodType(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_MethodType);
        assertThat(objectUnderTest.getDescriptorIndex()).isNotNull();
    }

    @Test
    public void test14() throws Exception {
        PojoVerifier.forClass(ConstantModule.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1);
	//@formatter:on
        ConstantModule objectUnderTest = new ConstantModule(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Module);
        assertThat(objectUnderTest.getNameIndex()).isNotNull();
    }

    @Test
    public void test15() throws Exception {
        PojoVerifier.forClass(ConstantNameAndType.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ConstantNameAndType objectUnderTest = new ConstantNameAndType(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_NameAndType);
        assertThat(objectUnderTest.getNameIndex()).isNotNull();
        assertThat(objectUnderTest.getSignatureIndex()).isNotNull();
    }

    @Test
    public void test16() throws Exception {
        PojoVerifier.forClass(ConstantPackage.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ConstantPackage objectUnderTest = new ConstantPackage(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Package);
        assertThat(objectUnderTest.getNameIndex()).isNotNull();
    }

    @Test
    public void test17() throws Exception {
        PojoVerifier.forClass(ConstantString.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ConstantString objectUnderTest = new ConstantString(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_String);
        assertThat(objectUnderTest.getStringIndex()).isNotNull();
    }

    @Test
    public void test18() throws Exception {
        PojoVerifier.forClass(ConstantUtf8.class).skipSetters().verified();
        //@formatter:off
	when(mockInput.readUTF())
	.thenReturn("sjdksjhlshlhb");
	//@formatter:on
        ConstantUtf8 objectUnderTest = new ConstantUtf8(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Utf8);
        assertThat(objectUnderTest.getBytes()).isNotNull();
    }

    @Test(expected = ClassFormatException.class)
    public void test19() throws Exception {
        //@formatter:off
	when(mockInput.readInt())
	.thenReturn(2);
	//@formatter:on
        Constant.readConstant(mockInput, (byte) 100);
    }

    @Test
    public void test2() throws Exception {
        PojoVerifier.forClass(ConstantClass.class).skipSetters().verified();
        when(mockInput.readUnsignedShort()).thenReturn(1);
        ConstantClass objectUnderTest = new ConstantClass(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Class);
        assertThat(objectUnderTest.getNameIndex()).isEqualTo(1);
    }

    @Test
    public void test20() throws Exception {
        JavaClass result = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithInitializedFields.class", true);
        ConstantPool cp = result.getConstantPool();
        for (Constant entry : cp.getConstantPool()) {
            if (entry != null) {
                cp.constantToString(entry);
            }
        }
    }

    @Test(expected = ClassFormatException.class)
    public void test21part1() throws Exception {
        JavaClass result = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithInitializedFields.class", true);
        ConstantPool cp = result.getConstantPool();
        cp.getConstant(1000);
    }

    @Test(expected = ClassFormatException.class)
    public void test21part2() throws Exception {
        JavaClass result = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithInitializedFields.class", true);
        ConstantPool cp = result.getConstantPool();
        cp.getConstant(-5);
    }

    @Test(expected = Exception.class)
    public void test21part3() throws Exception {
        JavaClass result = load(this.getClass(), "/com/wade/decompiler/test/SimpleClassWithInitializedFields.class", true);
        ConstantPool cp = result.getConstantPool();
        assertThat(cp.constantToString(5)).isNotNull();
        Constant mock = mock(Constant.class);
        when(mock.getTag()).thenReturn(ClassFileConstants.CONSTANT_UNKNOWN);
        cp.constantToString(mock);
    }

    @Test
    public void test3() throws Exception {
        PojoVerifier.forClass(ConstantCP.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	    .thenReturn(1)
	    .thenReturn(2);
	//@formatter:on
        ConstantCP objectUnderTest = new ConstantCP(ClassFileConstants.CONSTANT_Integer, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Integer);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getNameAndTypeIndex()).isNotNull();
    }

    @Test
    public void test4() throws Exception {
        PojoVerifier.forClass(ConstantDouble.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ConstantDouble objectUnderTest = new ConstantDouble(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Double);
        assertThat(objectUnderTest.getBytes()).isNotNull();
    }

    @Test
    public void test5() throws Exception {
        PojoVerifier.forClass(ConstantDynamic.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ConstantDynamic objectUnderTest = new ConstantDynamic(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Dynamic);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getNameAndTypeIndex()).isNotNull();
    }

    @Test
    public void test6() throws Exception {
        PojoVerifier.forClass(ConstantFieldRef.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ConstantFieldRef objectUnderTest = new ConstantFieldRef(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Fieldref);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getNameAndTypeIndex()).isNotNull();
    }

    @Test
    public void test7() throws Exception {
        PojoVerifier.forClass(ConstantFloat.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readFloat())
	   .thenReturn((float) 2.0);
	//@formatter:on
        ConstantFloat objectUnderTest = new ConstantFloat(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Float);
        assertThat(objectUnderTest.getBytes()).isNotNull();
    }

    @Test
    public void test8() throws Exception {
        PojoVerifier.forClass(ConstantInteger.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readInt())
	.thenReturn(2);
	//@formatter:on
        ConstantInteger objectUnderTest = new ConstantInteger(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_Integer);
        assertThat(objectUnderTest.getBytes()).isNotNull();
    }

    @Test
    public void test9() throws Exception {
        PojoVerifier.forClass(ConstantInterfaceMethodRef.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readInt())
	.thenReturn(2);
	//@formatter:on
        ConstantInterfaceMethodRef objectUnderTest = new ConstantInterfaceMethodRef(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileConstants.CONSTANT_InterfaceMethodref);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getNameAndTypeIndex()).isNotNull();
    }
}
