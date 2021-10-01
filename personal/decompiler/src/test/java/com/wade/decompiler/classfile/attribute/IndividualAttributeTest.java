package com.wade.decompiler.classfile.attribute;

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
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.wade.decompiler.classfile.ClassParser;
import com.wade.decompiler.classfile.JavaClass;
import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.element.ElementValue;
import com.wade.decompiler.constants.Const;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileAttributes;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.ItemNamesEnum;
import com.wade.decompiler.exceptions.ClassFormatException;
import com.wade.decompiler.util.TestUtil;
import com.wade.pojotester.PojoVerifier;

public class IndividualAttributeTest {
    private JavaClass load(Class<? extends IndividualAttributeTest> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }

    @Test
    public void test_AnnotationDefault() throws Exception {
        PojoVerifier.forClass(AnnotationDefault.class).skipHashCode().skipEquals().skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        when(mockInput.readUnsignedShort()).thenReturn(2);
        AnnotationDefault objectUnderTest = new AnnotationDefault(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileAttributes.ATTR_ANNOTATION_DEFAULT);
        assertThat(objectUnderTest.getNameIndex()).isEqualTo(1);
        assertThat(objectUnderTest.getLength()).isEqualTo(2);
        assertThat(objectUnderTest.getDefaultValue()).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_AnnotationEntry() throws Exception {
        PojoVerifier.forClass(AnnotationEntry.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        AnnotationEntry objectUnderTest = AnnotationEntry.read(mockInput, false);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Annotations_Part1() throws Exception {
        PojoVerifier.forClass(Annotations.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2)
	.thenReturn(3)
	.thenReturn(4)
	.thenReturn(5)
	.thenReturn(6);
	when(mockInput.readByte())
	.thenReturn(ElementValue.PRIMITIVE_INT);
	//@formatter:on
        Annotations objectUnderTest = new Annotations(ClassFileAttributes.ATTR_CODE, 1, 1, mockInput, false);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Annotations_Part2() throws Exception {
        PojoVerifier.forClass(Annotations.class).skipSetters().verified();
        Annotations objectUnderTest = new Annotations(ClassFileAttributes.ATTR_CODE, 1, 1, new ArrayList<>(), false);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Attribute() {
        PojoVerifier.forClass(Attribute.class).skipSetters().verified();
        PrintStream out = System.out;
        new Attribute(ClassFileAttributes.ATTR_ANNOTATION_DEFAULT, 1, 2).printUsefulData(out);
    }

    @Test
    public void test_BootstrapMethod() throws Exception {
        PojoVerifier.forClass(BootstrapMethod.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2).thenReturn(1).thenReturn(3);
        BootstrapMethod objectUnderTest = new BootstrapMethod(mockInput);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_BootstrapMethods() throws Exception {
        PojoVerifier.forClass(BootstrapMethods.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(1).thenReturn(3);
        BootstrapMethods objectUnderTest = new BootstrapMethods(9, 10, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
    }

    @Test
    public void test_Code() throws Exception {
        PojoVerifier.forClass(Code.class).skipToString().skipSetters().skipEquals().skipHashCode().verified();

        JavaClass clazz = load(this.getClass(), "/com/wade/decompiler/test/SimpleClass.class", false);
        Code code = (Code) clazz.getMethods().get(0).getAttributes().get(0);
        code.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_CodeException() throws Exception {
        PojoVerifier.forClass(CodeException.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2)
	.thenReturn(3)
	.thenReturn(4);
	//@formatter:on
        CodeException objectUnderTest = new CodeException(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getFrom()).isNotNull();
        assertThat(objectUnderTest.getTo()).isNotNull();
        assertThat(objectUnderTest.getTarget()).isNotNull();
        assertThat(objectUnderTest.getType()).isNotNull();
    }

    @Test
    public void test_ConstantValue() {
        PojoVerifier.forClass(ConstantValue.class).skipSetters().verified();
    }

    @Test
    public void test_Deprecated_GreaterThenZero() throws Exception {
        PojoVerifier.forClass(Deprecated.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Deprecated objectUnderTest = new Deprecated(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Deprecated_LessThenZero() throws Exception {
        PojoVerifier.forClass(Deprecated.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Deprecated objectUnderTest = new Deprecated(1, 0, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_EnclosingMethod() throws Exception {
        PojoVerifier.forClass(EnclosingMethod.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(3);
        when(mockInput.readUnsignedShort()).thenReturn(4);
        EnclosingMethod objectUnderTest = new EnclosingMethod(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileAttributes.ATTR_ENCLOSING_METHOD);
        assertThat(objectUnderTest.getNameIndex()).isEqualTo(1);
        assertThat(objectUnderTest.getLength()).isEqualTo(2);
        assertThat(objectUnderTest.getClassIndex()).isNotNull();
        assertThat(objectUnderTest.getMethodIndex()).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_ExceptionTable() throws Exception {
        PojoVerifier.forClass(ExceptionTable.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(4);
        ExceptionTable objectUnderTest = new ExceptionTable(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.getExceptionIndexTable()).isNotNull();
        assertThat(objectUnderTest.getExceptionIndexTable().size()).isEqualTo(1);
        assertThat(objectUnderTest.getExceptionIndexTable().get(0)).isEqualTo(4);
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Illegal() throws Exception {
        PojoVerifier.forClass(Unknown.class).skipSetters().skipHashCode().skipEquals().verified();

        DataInput mockInput = mock(DataInput.class);

        when(mockInput.readUnsignedShort()).thenReturn(1);
        when(mockInput.readInt()).thenReturn(5);

        Constant constant0 = mock(Constant.class);

        ConstantUtf8 constant1 = mock(ConstantUtf8.class);
        when(constant1.getBytes()).thenReturn("Unknown");
        when(constant1.getTag()).thenReturn(ClassFileConstants.CONSTANT_Utf8);

        ConstantPool cp = TestUtil.createConstantPool(constant0);
        cp = TestUtil.add(cp, constant1);

        Unknown objectUnderTest = (Unknown) Attribute.readAttribute(mockInput, cp, false);
        assertThat(objectUnderTest).isNotNull();
    }

    @Test
    public void test_InnerClass_Constructor1() throws Exception {
        PojoVerifier.forClass(InnerClass.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        ConstantPool mockConstantPool = mock(ConstantPool.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(4);
        InnerClass objectUnderTest = new InnerClass(mockInput, mockConstantPool, false);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getInnerClassIndex()).isNotNull();
        assertThat(objectUnderTest.getOuterClassIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerNameIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerAccessFlags()).isNotNull();
    }

    @Test
    public void test_InnerClass_Constructor2() throws Exception {
        PojoVerifier.forClass(InnerClass.class).skipSetters().verified();
        ConstantPool mockConstantPool = mock(ConstantPool.class);
        InnerClass objectUnderTest = new InnerClass(1, 2, 3, 4, mockConstantPool, false);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getInnerClassIndex()).isNotNull();
        assertThat(objectUnderTest.getOuterClassIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerNameIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerAccessFlags()).isNotNull();
    }

    @Test
    public void test_InnerClass_Constructor3() throws Exception {
        PojoVerifier.forClass(InnerClass.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(4);
        InnerClass objectUnderTest = new InnerClass(1, 2, 3, new ClassAccessFlagsList(1));
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getInnerClassIndex()).isNotNull();
        assertThat(objectUnderTest.getOuterClassIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerNameIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerAccessFlags()).isNotNull();
    }

    @Test
    public void test_InnerClasses() throws Exception {
        PojoVerifier.forClass(InnerClasses.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        ConstantPool mockConstantPool = mock(ConstantPool.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5);
        InnerClasses objectUnderTest = new InnerClasses(1, 2, mockInput, mockConstantPool, false);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getInnerClasses()).isNotNull();
        assertThat(objectUnderTest.getInnerClasses().size()).isEqualTo(1);
        assertThat(objectUnderTest.getInnerClasses().get(0)).isNotNull();
        assertThat(objectUnderTest.getInnerClasses().get(0).getInnerClassIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerClasses().get(0).getOuterClassIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerClasses().get(0).getInnerNameIndex()).isNotNull();
        assertThat(objectUnderTest.getInnerClasses().get(0).getInnerAccessFlags()).isNotNull();
    }

    @Test
    public void test_LineNumber() throws Exception {
        PojoVerifier.forClass(LineNumber.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5);
        LineNumber objectUnderTest = new LineNumber(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getStartPc()).isNotNull();
        assertThat(objectUnderTest.getLineNumber()).isNotNull();
    }

    @Test
    public void test_LineNumberTable() throws Exception {
        PojoVerifier.forClass(LineNumberTable.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2);
        LineNumberTable objectUnderTest = new LineNumberTable(3, 4, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getLineNumberTable()).isNotNull();
        assertThat(objectUnderTest.getLineNumberTable().size()).isEqualTo(1);
        assertThat(objectUnderTest.getLineNumberTable().get(0).getStartPc()).isNotNull();
        assertThat(objectUnderTest.getLineNumberTable().get(0).getLineNumber()).isNotNull();
    }

    @Test
    public void test_LocalVariable() throws Exception {
        PojoVerifier.forClass(LocalVariable.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5);
        LocalVariable objectUnderTest = new LocalVariable(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getLength()).isEqualTo(2);
        assertThat(objectUnderTest.getStart()).isEqualTo(1);
        assertThat(objectUnderTest.getSlot()).isEqualTo(5);
        assertThat(objectUnderTest.getNameIndex()).isEqualTo(3);
        assertThat(objectUnderTest.getSignatureIndex()).isEqualTo(4);
    }

    @Test
    public void test_LocalVariableTable() throws Exception {
        PojoVerifier.forClass(LocalVariableTable.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(4).thenReturn(5);
        LocalVariableTable objectUnderTest = new LocalVariableTable(3, 4, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        Map<Integer, LocalVariable> localVariableTable = objectUnderTest.getLocalVariableTable();
        assertThat(localVariableTable).isNotNull();
        assertThat(localVariableTable.size()).isEqualTo(1);
    }

    @Test
    public void test_LocalVariableTypeTable() throws Exception {
        PojoVerifier.forClass(LocalVariableTypeTable.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6);
        LocalVariableTypeTable objectUnderTest = new LocalVariableTypeTable(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getLocalVariableTypeTable()).isNotNull();
        assertThat(objectUnderTest.getLocalVariableTypeTable().size()).isEqualTo(1);
    }

    @Test
    public void test_MethodParameter() throws Exception {
        PojoVerifier.forClass(MethodParameter.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(2).thenReturn(3);
        MethodParameter objectUnderTest = new MethodParameter(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getNameIndex()).isNotNull();
        assertThat(objectUnderTest.getAccessFlags()).isNotNull();
    }

    @Test
    public void test_MethodParameters() throws Exception {
        PojoVerifier.forClass(MethodParameters.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedByte()).thenReturn(1);
        when(mockInput.readUnsignedShort()).thenReturn(2).thenReturn(3);
        MethodParameters objectUnderTest = new MethodParameters(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getParameters()).isNotNull();
        assertThat(objectUnderTest.getParameters().size()).isEqualTo(1);
        assertThat(objectUnderTest.getParameters().get(0)).isNotNull();
        assertThat(objectUnderTest.getParameters().get(0).getNameIndex()).isNotNull();
        assertThat(objectUnderTest.getParameters().get(0).getAccessFlags()).isNotNull();
    }

    @Test
    public void test_Module() throws Exception {
        PojoVerifier.forClass(Module.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	   .thenReturn(1)
	   .thenReturn(1)
	   .thenReturn(1)
	   .thenReturn(1);
	//@formatter:on
        Module objectUnderTest = new Module(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getModuleNameIndex()).isNotNull();
        assertThat(objectUnderTest.getModuleFlags()).isNotNull();
        assertThat(objectUnderTest.getModuleVersionIndex()).isNotNull();
        assertThat(objectUnderTest.getRequiresTable()).isNotNull();
        assertThat(objectUnderTest.getExportsTable()).isNotNull();
        assertThat(objectUnderTest.getOpensTable()).isNotNull();
        assertThat(objectUnderTest.getUsesIndex()).isNotNull();
        assertThat(objectUnderTest.getProvidesTable()).isNotNull();
    }

    @Test
    public void test_ModuleExports() throws Exception {
        PojoVerifier.forClass(ModuleExports.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(1)
	.thenReturn(1)
	.thenReturn(1);
	//@formatter:on
        ModuleExports objectUnderTest = new ModuleExports(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getExportsIndex()).isNotNull();
        assertThat(objectUnderTest.getExportsFlags()).isNotNull();
        assertThat(objectUnderTest.getExportsToCount()).isNotNull();
        assertThat(objectUnderTest.getExportsToIndex()).isNotNull();
        assertThat(objectUnderTest.getExportsToIndex().size()).isEqualTo(1);
        assertThat(objectUnderTest.getExportsToIndex().get(0)).isEqualTo(1);
    }

    @Test
    public void test_ModuleMainClass() throws Exception {
        PojoVerifier.forClass(ModuleMainClass.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readUnsignedShort()).thenReturn(1);
        ModuleMainClass objectUnderTest = new ModuleMainClass(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getMainClassIndex()).isEqualTo(1);
    }

    @Test
    public void test_ModuleOpens() throws Exception {
        PojoVerifier.forClass(ModuleOpens.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2)
	.thenReturn(1)
	.thenReturn(3);
	//@formatter:on
        ModuleOpens objectUnderTest = new ModuleOpens(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getOpensIndex()).isNotNull();
        assertThat(objectUnderTest.getOpensFlags()).isNotNull();
        assertThat(objectUnderTest.getOpensToCount()).isNotNull();
        assertThat(objectUnderTest.getOpensToIndex()).isNotNull();
        assertThat(objectUnderTest.getOpensToIndex().get(0)).isNotNull();
        assertThat(objectUnderTest.getOpensToIndex().get(0)).isEqualTo(3);
    }

    @Test
    public void test_ModulePackages() throws Exception {
        PojoVerifier.forClass(ModulePackages.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        ModulePackages objectUnderTest = new ModulePackages(3, 4, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getPackageIndexTable()).isNotNull();
        assertThat(objectUnderTest.getPackageIndexTable().get(0)).isNotNull();
        assertThat(objectUnderTest.getPackageIndexTable().get(0)).isEqualTo(2);
        assertThat(objectUnderTest.getNameIndex()).isNotNull();
        assertThat(objectUnderTest.getLength()).isNotNull();
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ModuleProvides() throws Exception {
        PojoVerifier.forClass(ModuleProvides.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2)
	.thenReturn(3);
	//@formatter:on
        ModuleProvides objectUnderTest = new ModuleProvides(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getProvidesIndex()).isNotNull();
        assertThat(objectUnderTest.getProvidesWithCount()).isNotNull();
        assertThat(objectUnderTest.getProvidesWithIndex()).isNotNull();
        assertThat(objectUnderTest.getProvidesWithIndex().get(0)).isNotNull();
        assertThat(objectUnderTest.getProvidesWithIndex().get(0)).isEqualTo(3);
    }

    @Test
    public void test_ModuleRequires() throws Exception {
        PojoVerifier.forClass(ModuleRequires.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2)
	.thenReturn(3);
	//@formatter:on
        ModuleRequires objectUnderTest = new ModuleRequires(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getRequiresIndex()).isNotNull();
        assertThat(objectUnderTest.getRequiresFlags()).isNotNull();
        assertThat(objectUnderTest.getRequiresVersionIndex()).isNotNull();
    }

    @Test
    public void test_NestHost() throws Exception {
        PojoVerifier.forClass(NestHost.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1);
	//@formatter:on
        NestHost objectUnderTest = new NestHost(1, 2, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_NestMembers() throws Exception {
        PojoVerifier.forClass(NestMembers.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        NestMembers objectUnderTest = new NestMembers(3, 4, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getClasses()).isNotNull();
        assertThat(objectUnderTest.getClasses().get(0)).isNotNull();
        assertThat(objectUnderTest.getClasses().get(0)).isEqualTo(2);
        assertThat(objectUnderTest.getNameIndex()).isEqualTo(3);
        assertThat(objectUnderTest.getLength()).isEqualTo(4);
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileAttributes.ATTR_NEST_MEMBERS);
        objectUnderTest.printUsefulData(mock(PrintStream.class));
    }

    @Test
    public void test_ParameterAnnotationEntry() throws Exception {
        PojoVerifier.forClass(ParameterAnnotationEntry.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	   .thenReturn(1)
	   .thenReturn(1)
	   .thenReturn(1)
	   .thenReturn(2)
	   .thenReturn(3)
	   .thenReturn(4);
	when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
	//@formatter:on
        ParameterAnnotationEntry objectUnderTest = new ParameterAnnotationEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getAnnotationTable()).isNotNull();
        assertThat(objectUnderTest.getAnnotationTable().size()).isEqualTo(1);
        assertThat(objectUnderTest.getAnnotationTable().get(0)).isNotNull();
    }

    @Test
    public void test_PMGClass() throws Exception {
        PojoVerifier.forClass(PMGClass.class).skipSetters().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2);
	//@formatter:on
        PMGClass objectUnderTest = new PMGClass(3, 4, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getPmgIndex()).isEqualTo(1);
        assertThat(objectUnderTest.getPmgClassIndex()).isEqualTo(2);
        assertThat(objectUnderTest.getNameIndex()).isEqualTo(3);
        assertThat(objectUnderTest.getLength()).isEqualTo(4);
        assertThat(objectUnderTest.getTag()).isEqualTo(ClassFileAttributes.ATTR_PMG);
    }

    @Test
    public void test_RuntimeInvisibleAnnotations() {
        PojoVerifier.forClass(RuntimeInvisibleAnnotations.class).skipSetters().skipHashCode().skipEquals().verified();
    }

    @Test
    public void test_RuntimeInvisibleParameterAnnotations() {
        PojoVerifier.forClass(RuntimeInvisibleParameterAnnotations.class).skipSetters().skipHashCode().skipEquals().verified();
    }

    @Test
    public void test_RuntimeVisibleAnnotations() {
        PojoVerifier.forClass(RuntimeVisibleAnnotations.class).skipSetters().skipHashCode().skipEquals().verified();
    }

    @Test
    public void test_RuntimeVisibleParameterAnnotations() {
        PojoVerifier.forClass(RuntimeVisibleParameterAnnotations.class).skipSetters().skipHashCode().skipEquals().verified();
    }

    @Test
    public void test_Signature() {
        PojoVerifier.forClass(Signature.class).skipSetters().skipHashCode().skipEquals().verified();
    }

    @Test
    public void test_SourceFile() {
        PojoVerifier.forClass(SourceFile.class).skipSetters().skipHashCode().skipEquals().verified();
    }

    @Test
    public void test_StackMap() throws Exception {
        PojoVerifier.forClass(StackMap.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readUnsignedShort())
	.thenReturn(1)
	.thenReturn(2)
	.thenReturn(3)
	.thenReturn(4)
	.thenReturn(5)
	.thenReturn(6);
	when(mockInput.readByte())
	.thenReturn((byte) 0);
	//@formatter:on
        StackMap objectUnderTest = new StackMap(1, 1, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_StackMapEntry_Part1() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.SAME_FRAME);
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.SAME_FRAME);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(0);
        assertThat(objectUnderTest.getTypesOfLocals()).isNull();
        assertThat(objectUnderTest.getTypesOfStackItems()).isNull();
    }

    @Test
    public void test_StackMapEntry_Part2() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.SAME_LOCALS_1_STACK_ITEM_FRAME)
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.SAME_LOCALS_1_STACK_ITEM_FRAME);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(0);
        assertThat(objectUnderTest.getTypesOfLocals()).isNull();
        assertThat(objectUnderTest.getTypesOfStackItems()).isNotNull();
        assertThat(objectUnderTest.getTypesOfStackItems().size()).isEqualTo(1);
    }

    @Test
    public void test_StackMapEntry_Part3() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED)
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
	when(mockInput.readShort())
	.thenReturn((short) 1);
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfLocals()).isNull();
        assertThat(objectUnderTest.getTypesOfStackItems()).isNotNull();
        assertThat(objectUnderTest.getTypesOfStackItems().size()).isEqualTo(1);
    }

    @Test
    public void test_StackMapEntry_Part4() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.CHOP_FRAME)
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
	when(mockInput.readShort())
	.thenReturn((short) 1);
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.CHOP_FRAME);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfLocals()).isNull();
        assertThat(objectUnderTest.getTypesOfStackItems()).isNull();
    }

    @Test
    public void test_StackMapEntry_Part5() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.SAME_FRAME_EXTENDED)
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
	when(mockInput.readShort())
	.thenReturn((short) 1);
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.SAME_FRAME_EXTENDED);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfLocals()).isNull();
        assertThat(objectUnderTest.getTypesOfStackItems()).isNull();
    }

    @Test
    public void test_StackMapEntry_Part6() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.APPEND_FRAME)
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
	when(mockInput.readShort())
	.thenReturn((short) 1);
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.APPEND_FRAME);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfLocals()).isNotNull();
        assertThat(objectUnderTest.getTypesOfLocals().size()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfStackItems()).isNull();
    }

    @Test
    public void test_StackMapEntry_Part7() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
	when(mockInput.readByte())
	.thenReturn((byte) Const.FULL_FRAME)
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag())
	.thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
	when(mockInput.readShort())
	.thenReturn((short) 1)
	.thenReturn((short) 1);
	//@formatter:on
        StackMapEntry objectUnderTest = new StackMapEntry(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getFrameType()).isEqualTo(Const.FULL_FRAME);
        assertThat(objectUnderTest.getByteCodeOffset()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfLocals()).isNotNull();
        assertThat(objectUnderTest.getTypesOfLocals().size()).isEqualTo(1);
        assertThat(objectUnderTest.getTypesOfStackItems()).isNotNull();
        assertThat(objectUnderTest.getTypesOfStackItems().size()).isEqualTo(1);
    }

    @Test(expected = ClassFormatException.class)
    public void test_StackMapEntry_Part8() throws Exception {
        PojoVerifier.forClass(StackMapEntry.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        //@formatter:off
        when(mockInput.readByte())
        .thenReturn((byte) 999)
        .thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag())
        .thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());
        when(mockInput.readShort())
        .thenReturn((short) 1)
        .thenReturn((short) 1);
        //@formatter:on
        new StackMapEntry(mockInput);
    }

    @Test
    public void test_StackMapType_Part1() throws Exception {
        DataInput mockInput = mock(DataInput.class);

        when(mockInput.readByte()).thenReturn((byte) ItemNamesEnum.ITEM_Integer.getTag());

        StackMapType objectUnderTest = new StackMapType(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getIndex()).isEqualTo(-1);
        assertThat(objectUnderTest.getType()).isEqualTo((byte) ItemNamesEnum.ITEM_Integer.getTag());
    }

    @Test
    public void test_StackMapType_Part2() throws Exception {
        DataInput mockInput = mock(DataInput.class);

        when(mockInput.readByte()).thenReturn((byte) ItemNamesEnum.ITEM_NewObject.getTag());
        when(mockInput.readShort()).thenReturn((short) 5);

        StackMapType objectUnderTest = new StackMapType(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getIndex()).isEqualTo(5);
        assertThat(objectUnderTest.getType()).isEqualTo((byte) ItemNamesEnum.ITEM_NewObject.getTag());
    }

    @Test
    public void test_StackMapType_Part3() throws Exception {
        DataInput mockInput = mock(DataInput.class);

        when(mockInput.readByte()).thenReturn((byte) ItemNamesEnum.ITEM_Object.getTag());
        when(mockInput.readShort()).thenReturn((short) 5);

        StackMapType objectUnderTest = new StackMapType(mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
        assertThat(objectUnderTest.getIndex()).isEqualTo(5);
        assertThat(objectUnderTest.getType()).isEqualTo((byte) ItemNamesEnum.ITEM_Object.getTag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_StackMapType_Part4() throws Exception {
        DataInput mockInput = mock(DataInput.class);

        when(mockInput.readByte()).thenReturn((byte) -1);

        new StackMapType(mockInput);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_StackMapType_Part5() throws Exception {
        DataInput mockInput = mock(DataInput.class);

        when(mockInput.readByte()).thenReturn((byte) 10);

        new StackMapType(mockInput);
    }

    @Test
    public void test_Synthetic_Part1() throws Exception {
        PojoVerifier.forClass(Synthetic.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Synthetic objectUnderTest = new Synthetic(1, 0, mockInput);
        assertThat(objectUnderTest).isNotNull();
        PrintStream out = System.out;
        objectUnderTest.printUsefulData(out);
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Synthetic_Part2() throws Exception {
        PojoVerifier.forClass(Synthetic.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Synthetic objectUnderTest = new Synthetic(1, 1, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Unknown_Part1() throws Exception {
        PojoVerifier.forClass(Unknown.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Unknown objectUnderTest = new Unknown(1, 1, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }

    @Test
    public void test_Unknown_Part2() throws Exception {
        PojoVerifier.forClass(Unknown.class).skipSetters().skipHashCode().skipEquals().verified();
        DataInput mockInput = mock(DataInput.class);
        when(mockInput.readByte()).thenReturn(ElementValue.PRIMITIVE_INT);
        doNothing().when(mockInput).readFully(any(byte[].class), eq(0), eq(2));
        Unknown objectUnderTest = new Unknown(1, 0, mockInput);
        assertThat(objectUnderTest).isNotNull();
        assertThat(objectUnderTest.toString()).isNotNull();
    }
}
