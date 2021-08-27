package com.wade.decompiler.generate.instructions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.DataInput;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.wade.decompiler.classfile.attribute.LocalVariableTable;
import com.wade.decompiler.classfile.constant.ConstantClass;
import com.wade.decompiler.classfile.constant.ConstantDouble;
import com.wade.decompiler.classfile.constant.ConstantFieldRef;
import com.wade.decompiler.classfile.constant.ConstantInvokeDynamic;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantMethodref;
import com.wade.decompiler.classfile.constant.ConstantNameAndType;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.instructions.AALOAD;
import com.wade.decompiler.classfile.instructions.AASTORE;
import com.wade.decompiler.classfile.instructions.ACONST_NULL;
import com.wade.decompiler.classfile.instructions.ARRAYLENGTH;
import com.wade.decompiler.classfile.instructions.BALOAD;
import com.wade.decompiler.classfile.instructions.BASTORE;
import com.wade.decompiler.classfile.instructions.BIPUSH;
import com.wade.decompiler.classfile.instructions.BREAKPOINT;
import com.wade.decompiler.classfile.instructions.CALOAD;
import com.wade.decompiler.classfile.instructions.CASTORE;
import com.wade.decompiler.classfile.instructions.CHECKCAST;
import com.wade.decompiler.classfile.instructions.D2F;
import com.wade.decompiler.classfile.instructions.D2I;
import com.wade.decompiler.classfile.instructions.D2L;
import com.wade.decompiler.classfile.instructions.DADD;
import com.wade.decompiler.classfile.instructions.DALOAD;
import com.wade.decompiler.classfile.instructions.DASTORE;
import com.wade.decompiler.classfile.instructions.DCONST;
import com.wade.decompiler.classfile.instructions.DDIV;
import com.wade.decompiler.classfile.instructions.DMUL;
import com.wade.decompiler.classfile.instructions.DNEG;
import com.wade.decompiler.classfile.instructions.DREM;
import com.wade.decompiler.classfile.instructions.DSUB;
import com.wade.decompiler.classfile.instructions.DUP;
import com.wade.decompiler.classfile.instructions.DUP2;
import com.wade.decompiler.classfile.instructions.DUP2_X1;
import com.wade.decompiler.classfile.instructions.DUP2_X2;
import com.wade.decompiler.classfile.instructions.DUP_X1;
import com.wade.decompiler.classfile.instructions.DUP_X2;
import com.wade.decompiler.classfile.instructions.F2D;
import com.wade.decompiler.classfile.instructions.F2I;
import com.wade.decompiler.classfile.instructions.F2L;
import com.wade.decompiler.classfile.instructions.FADD;
import com.wade.decompiler.classfile.instructions.FALOAD;
import com.wade.decompiler.classfile.instructions.FASTORE;
import com.wade.decompiler.classfile.instructions.FCONST;
import com.wade.decompiler.classfile.instructions.FDIV;
import com.wade.decompiler.classfile.instructions.FMUL;
import com.wade.decompiler.classfile.instructions.FNEG;
import com.wade.decompiler.classfile.instructions.FREM;
import com.wade.decompiler.classfile.instructions.FSUB;
import com.wade.decompiler.classfile.instructions.GETSTATIC;
import com.wade.decompiler.classfile.instructions.I2B;
import com.wade.decompiler.classfile.instructions.I2C;
import com.wade.decompiler.classfile.instructions.I2D;
import com.wade.decompiler.classfile.instructions.I2F;
import com.wade.decompiler.classfile.instructions.I2L;
import com.wade.decompiler.classfile.instructions.I2S;
import com.wade.decompiler.classfile.instructions.IADD;
import com.wade.decompiler.classfile.instructions.IALOAD;
import com.wade.decompiler.classfile.instructions.IAND;
import com.wade.decompiler.classfile.instructions.IASTORE;
import com.wade.decompiler.classfile.instructions.ICONST;
import com.wade.decompiler.classfile.instructions.IDIV;
import com.wade.decompiler.classfile.instructions.IMPDEP1;
import com.wade.decompiler.classfile.instructions.IMPDEP2;
import com.wade.decompiler.classfile.instructions.IMUL;
import com.wade.decompiler.classfile.instructions.INEG;
import com.wade.decompiler.classfile.instructions.INSTANCEOF;
import com.wade.decompiler.classfile.instructions.INVOKEVIRTUAL;
import com.wade.decompiler.classfile.instructions.IOR;
import com.wade.decompiler.classfile.instructions.IREM;
import com.wade.decompiler.classfile.instructions.ISHL;
import com.wade.decompiler.classfile.instructions.ISHR;
import com.wade.decompiler.classfile.instructions.ISUB;
import com.wade.decompiler.classfile.instructions.IXOR;
import com.wade.decompiler.classfile.instructions.JSR;
import com.wade.decompiler.classfile.instructions.JSR_W;
import com.wade.decompiler.classfile.instructions.L2D;
import com.wade.decompiler.classfile.instructions.L2F;
import com.wade.decompiler.classfile.instructions.L2I;
import com.wade.decompiler.classfile.instructions.LADD;
import com.wade.decompiler.classfile.instructions.LALOAD;
import com.wade.decompiler.classfile.instructions.LAND;
import com.wade.decompiler.classfile.instructions.LASTORE;
import com.wade.decompiler.classfile.instructions.LCONST;
import com.wade.decompiler.classfile.instructions.LDC;
import com.wade.decompiler.classfile.instructions.LDC2_W;
import com.wade.decompiler.classfile.instructions.LDIV;
import com.wade.decompiler.classfile.instructions.LMUL;
import com.wade.decompiler.classfile.instructions.LNEG;
import com.wade.decompiler.classfile.instructions.LOR;
import com.wade.decompiler.classfile.instructions.LREM;
import com.wade.decompiler.classfile.instructions.LSHL;
import com.wade.decompiler.classfile.instructions.LSHR;
import com.wade.decompiler.classfile.instructions.LSUB;
import com.wade.decompiler.classfile.instructions.LUSHR;
import com.wade.decompiler.classfile.instructions.LXOR;
import com.wade.decompiler.classfile.instructions.MONITORENTER;
import com.wade.decompiler.classfile.instructions.MONITOREXIT;
import com.wade.decompiler.classfile.instructions.NOP;
import com.wade.decompiler.classfile.instructions.POP;
import com.wade.decompiler.classfile.instructions.POP2;
import com.wade.decompiler.classfile.instructions.PUTSTATIC;
import com.wade.decompiler.classfile.instructions.SALOAD;
import com.wade.decompiler.classfile.instructions.SASTORE;
import com.wade.decompiler.classfile.instructions.SIPUSH;
import com.wade.decompiler.classfile.instructions.SWAP;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTypeTableGen;
import com.wade.pojotester.PojoVerifier;

@RunWith(MockitoJUnitRunner.class)
public class InstructionGenTest {
    @Mock
    DataInput mockInput;
    @Mock
    ConstantPool cp;
    @Mock
    LocalVariableTable lvt;
    @Mock
    LocalVariableTableGen lvtg;
    @Mock
    LocalVariableTypeTableGen lvttg;
    @Mock
    ConstantMethodref c1;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_ArithmeticGen() {
        PojoVerifier.forClass(ArithmeticGen.class).skipSetters().verified();
        ArithmeticGen instr = new ArithmeticGen(0, new DADD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new DDIV(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new DMUL(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new DNEG(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new DREM(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new DSUB(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new FADD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new FDIV(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new FMUL(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new FNEG(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new FREM(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new FSUB(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IADD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IDIV(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IMUL(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new INEG(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IREM(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new ISUB(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IAND(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IOR(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new ISHL(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new ISHR(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new IXOR(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LADD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LDIV(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LMUL(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LNEG(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LREM(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LSUB(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LAND(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LOR(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LSHL(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LSHR(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LUSHR(), cp);
        assertThat(instr).isNotNull();
        instr = new ArithmeticGen(0, new LXOR(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_ArrayLengthGen() {
        PojoVerifier.forClass(ArrayLengthGen.class).skipSetters().verified();
        ArrayLengthGen instr = new ArrayLengthGen(0, new ARRAYLENGTH(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_ArrayLoadGen() {
        PojoVerifier.forClass(ArrayLoadGen.class).skipSetters().verified();
        ArrayLoadGen instr = new ArrayLoadGen(0, new AALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new BALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new CALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new DALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new FALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new IALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new LALOAD(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayLoadGen(0, new SALOAD(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_ArrayStoreGen() {
        PojoVerifier.forClass(ArrayStoreGen.class).skipSetters().verified();
        ArrayStoreGen instr = new ArrayStoreGen(0, new AASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new BASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new CASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new DASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new FASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new IASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new LASTORE(), cp);
        assertThat(instr).isNotNull();
        instr = new ArrayStoreGen(0, new SASTORE(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_BreakPointGen() {
        PojoVerifier.forClass(BreakPointGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        BreakPointGen instr = new BreakPointGen(0, new BREAKPOINT(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_CheckCastGen() {
        PojoVerifier.forClass(CheckCastGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        CheckCastGen instr = new CheckCastGen(0, new CHECKCAST(0), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_ConstGen() {
        PojoVerifier.forClass(ConstGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        ConstGen instr = new ConstGen(0, new ACONST_NULL(), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNull();
        instr = new ConstGen(0, new BIPUSH(), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNull();
        instr = new ConstGen(0, new DCONST(0.0), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNotNull();
        instr = new ConstGen(0, new FCONST(0.0f), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNotNull();
        instr = new ConstGen(0, new ICONST(1), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNotNull();
        instr = new ConstGen(0, new LCONST(1l), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNotNull();
        instr = new ConstGen(0, new LDC(), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNull();
        instr = new ConstGen(0, new LDC2_W(), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNull();
        instr = new ConstGen(0, new SIPUSH(), cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getValue()).isNull();
    }

    @Test
    public void test_ConversionGen() {
        PojoVerifier.forClass(ConversionGen.class).skipSetters().verified();
        ConversionGen instr = new ConversionGen(0, new D2F(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new D2I(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new D2L(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new F2D(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new F2I(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new F2L(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new I2B(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new I2C(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new I2D(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new I2F(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new I2L(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new I2S(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new L2D(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new L2F(), cp);
        assertThat(instr).isNotNull();
        instr = new ConversionGen(0, new L2I(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_DuplicateGen() {
        PojoVerifier.forClass(DuplicateGen.class).skipSetters().verified();
        DuplicateGen instr = new DuplicateGen(0, new DUP(), cp);
        assertThat(instr).isNotNull();
        instr = new DuplicateGen(0, new DUP_X1(), cp);
        assertThat(instr).isNotNull();
        instr = new DuplicateGen(0, new DUP_X2(), cp);
        assertThat(instr).isNotNull();
        instr = new DuplicateGen(0, new DUP2(), cp);
        assertThat(instr).isNotNull();
        instr = new DuplicateGen(0, new DUP2_X1(), cp);
        assertThat(instr).isNotNull();
        instr = new DuplicateGen(0, new DUP2_X2(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_GetFieldGen_Part1() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperName()).isEqualTo("STRING1");
        assertThat(instr.getMethodName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_GetFieldGen_Part2() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        ConstantFieldRef c1 = mock(ConstantFieldRef.class);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperName()).isEqualTo("STRING1");
        assertThat(instr.getMethodName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_GetFieldGen_Part3() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        ConstantClass c1 = mock(ConstantClass.class);
        when(c1.getNameIndex()).thenReturn(1);
        ConstantUtf8 mockUTF = mock(ConstantUtf8.class);
        when(mockUTF.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantValue()).isNotNull();
    }

    @Test
    public void test_GetFieldGen_Part4() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        ConstantUtf8 c1 = mock(ConstantUtf8.class);
        when(c1.getBytes()).thenReturn("STRING1");

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantString()).isNotNull();
    }

    @Test
    public void test_GetFieldGen_Part5() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        ConstantNameAndType c1 = mock(ConstantNameAndType.class);
        when(c1.getNameIndex()).thenReturn(1);
        when(c1.getSignatureIndex()).thenReturn(2);
        when(cp.constantToString(eq(1), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn("STRING2");
        when(cp.constantToString(eq(2), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn("STRING3");

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getMethodName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_GetFieldGen_Part6() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        ConstantLong c1 = mock(ConstantLong.class);
        when(c1.getBytes()).thenReturn(2);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantValue()).isEqualTo(2L);
    }

    @Test
    public void test_GetFieldGen_Part7() {
        PojoVerifier.forClass(GetFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        GetFieldGen instr = new GetFieldGen(0, new GETSTATIC(), cp);
        ConstantDouble c1 = mock(ConstantDouble.class);
        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_ImpDepGen() {
        PojoVerifier.forClass(ImpDepGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        ImpDepGen instr = new ImpDepGen(0, new IMPDEP1(), cp);
        assertThat(instr).isNotNull();
        instr = new ImpDepGen(0, new IMPDEP2(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_InstanceOfGen() {
        PojoVerifier.forClass(InstanceOfGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InstanceOfGen instr = new InstanceOfGen(0, new INSTANCEOF(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_InstructionGen() {
// TDOD FIX-ME
//        PojoVerifier.forClass(InstructionGen.class).skipToString().skipSetters().verified();
//        for (InstructionOpCodes opcode : InstructionOpCodes.values()) {
//            if (opcode != InstructionOpCodes.PUTFIELD2_QUICK && opcode != InstructionOpCodes.GETFIELD2_QUICK && opcode != InstructionOpCodes.PUTFIELD_QUICK && opcode != InstructionOpCodes.GETFIELD_QUICK && opcode != InstructionOpCodes.LDC2_W_QUICK && opcode != InstructionOpCodes.LDC_W_QUICK && opcode != InstructionOpCodes.LDC_QUICK && opcode != InstructionOpCodes.WIDE && opcode != InstructionOpCodes.INVOKENONVIRTUAL && opcode != InstructionOpCodes.INT2BYTE && opcode != InstructionOpCodes.INT2CHAR
//                    && opcode != InstructionOpCodes.INVOKEINTERFACE_QUICK && opcode != InstructionOpCodes.INVOKESTATIC_QUICK && opcode != InstructionOpCodes.INVOKESUPER_QUICK && opcode != InstructionOpCodes.INVOKEVIRTUAL_QUICK && opcode != InstructionOpCodes.INVOKENONVIRTUAL_QUICK && opcode != InstructionOpCodes.PUTSTATIC2_QUICK && opcode != InstructionOpCodes.PUTSTATIC_QUICK && opcode != InstructionOpCodes.GETSTATIC_QUICK && opcode != InstructionOpCodes.GETSTATIC2_QUICK
//                    && opcode != InstructionOpCodes.PUTFIELD_QUICK_W && opcode != InstructionOpCodes.GETFIELD_QUICK_W && opcode != InstructionOpCodes.INVOKEVIRTUAL_QUICK_W && opcode != InstructionOpCodes.INSTANCEOF_QUICK && opcode != InstructionOpCodes.CHECKCAST_QUICK && opcode != InstructionOpCodes.MULTIANEWARRAY_QUICK && opcode != InstructionOpCodes.ANEWARRAY_QUICK && opcode != InstructionOpCodes.NEW_QUICK && opcode != InstructionOpCodes.INVOKEVIRTUALOBJECT_QUICK
//                    && opcode != InstructionOpCodes.INT2SHORT) {
//                InstructionGen.read(0, InstructionFactory.getInstructions(opcode), lvtg, lvttg, cp);
//            }
//        }
//        InstructionGen.read(0, InstructionFactory.getInstructions(InstructionOpCodes.LDC_W), lvtg, lvttg, cp);
//        Instruction instr = new Instruction();
//        instr.setOpcode(InstructionOpCodes.INT2SHORT);
//        InstructionGen.read(0, instr, lvtg, lvttg, cp);
    }

    @Test
    public void test_InvokeGen_Part1() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantMethodref c1 = mock(ConstantMethodref.class);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperClassName()).isEqualTo("STRING1");
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_InvokeGen_Part2() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantFieldRef c1 = mock(ConstantFieldRef.class);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperClassName()).isEqualTo("STRING1");
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_InvokeGen_Part2b() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantInvokeDynamic c1 = mock(ConstantInvokeDynamic.class);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperClassName()).isEqualTo("STRING1");
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_InvokeGen_Part3() {
        PojoVerifier.forClass(SwapGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantClass c1 = mock(ConstantClass.class);
        when(c1.getNameIndex()).thenReturn(1);
        ConstantUtf8 mockUTF = mock(ConstantUtf8.class);
        when(mockUTF.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantValue()).isNotNull();
    }

    @Test
    public void test_InvokeGen_Part4() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantUtf8 c1 = mock(ConstantUtf8.class);
        when(c1.getBytes()).thenReturn("STRING1");

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantString()).isNotNull();
    }

    @Test
    public void test_InvokeGen_Part5() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantNameAndType c1 = mock(ConstantNameAndType.class);
        when(c1.getNameIndex()).thenReturn(1);
        when(c1.getSignatureIndex()).thenReturn(2);
        when(cp.constantToString(eq(1), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn("STRING2");
        when(cp.constantToString(eq(2), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn("STRING3");

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_InvokeGen_Part6() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantLong c1 = mock(ConstantLong.class);
        when(c1.getBytes()).thenReturn(2);

        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantValue()).isEqualTo(2L);
    }

    @Test
    public void test_InvokeGen_Part7() {
        PojoVerifier.forClass(InvokeGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        InvokeGen instr = new InvokeGen(0, new INVOKEVIRTUAL(), cp);
        ConstantDouble c1 = mock(ConstantDouble.class);
        instr.extractConstantPoolInfo(c1);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_JsrGen() {
        PojoVerifier.forClass(JsrGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        JsrGen instr = new JsrGen(0, new JSR(), cp);
        assertThat(instr).isNotNull();
        instr = new JsrGen(0, new JSR_W(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_MonitorGen() {
        PojoVerifier.forClass(MonitorGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        MonitorGen instr = new MonitorGen(0, new MONITORENTER(), cp);
        assertThat(instr).isNotNull();
        instr = new MonitorGen(0, new MONITOREXIT(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_NopGen() {
        PojoVerifier.forClass(NopGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        NopGen instr = new NopGen(0, new NOP(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_PopGen() {
        PojoVerifier.forClass(PopGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PopGen instr = new PopGen(0, new POP(), cp);
        assertThat(instr).isNotNull();
        instr = new PopGen(0, new POP2(), cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_PutFieldGen_Part1() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantMethodref c1 = mock(ConstantMethodref.class);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperName()).isEqualTo("STRING1");
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_PutFieldGen_Part2() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantFieldRef c1 = mock(ConstantFieldRef.class);
        when(c1.getClassIndex()).thenReturn(1);
        when(c1.getNameAndTypeIndex()).thenReturn(2);
        ConstantClass mockCC = mock(ConstantClass.class);
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Class))).thenReturn(mockCC);
        ConstantNameAndType mockCNT = mock(ConstantNameAndType.class);
        when(cp.getConstant(eq(2), eq(ClassFileConstants.CONSTANT_NameAndType))).thenReturn(mockCNT);

        when(mockCC.getNameIndex()).thenReturn(3);
        when(mockCNT.getNameIndex()).thenReturn(4);
        when(mockCNT.getSignatureIndex()).thenReturn(5);

        ConstantUtf8 mockUTF1 = mock(ConstantUtf8.class);
        when(mockUTF1.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(3), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF1);

        ConstantUtf8 mockUTF2 = mock(ConstantUtf8.class);
        when(mockUTF2.getBytes()).thenReturn("STRING2");
        when(cp.getConstant(eq(4), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF2);

        ConstantUtf8 mockUTF3 = mock(ConstantUtf8.class);
        when(mockUTF3.getBytes()).thenReturn("STRING3");
        when(cp.getConstant(eq(5), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF3);

        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getSuperName()).isEqualTo("STRING1");
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_PutFieldGen_Part3() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantClass c1 = mock(ConstantClass.class);
        when(c1.getNameIndex()).thenReturn(1);
        ConstantUtf8 mockUTF = mock(ConstantUtf8.class);
        when(mockUTF.getBytes()).thenReturn("STRING1");
        when(cp.getConstant(eq(1), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn(mockUTF);

        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantValue()).isNotNull();
    }

    @Test
    public void test_PutFieldGen_Part4() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantUtf8 c1 = mock(ConstantUtf8.class);
        when(c1.getBytes()).thenReturn("STRING1");

        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantString()).isNotNull();
    }

    @Test
    public void test_PutFieldGen_Part5() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantNameAndType c1 = mock(ConstantNameAndType.class);
        when(c1.getNameIndex()).thenReturn(1);
        when(c1.getSignatureIndex()).thenReturn(2);
        when(cp.constantToString(eq(1), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn("STRING2");
        when(cp.constantToString(eq(2), eq(ClassFileConstants.CONSTANT_Utf8))).thenReturn("STRING3");

        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getName()).isEqualTo("STRING2");
        assertThat(instr.getSignature()).isEqualTo("STRING3");
    }

    @Test
    public void test_PutFieldGen_Part6() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantLong c1 = mock(ConstantLong.class);
        when(c1.getBytes()).thenReturn(2);

        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
        assertThat(instr.getConstantValue()).isEqualTo(2L);
    }

    @Test
    public void test_PutFieldGen_Part7() {
        PojoVerifier.forClass(PutFieldGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        PutFieldGen instr = new PutFieldGen(0, new PUTSTATIC(), cp);
        ConstantDouble c1 = mock(ConstantDouble.class);
        instr.extractConstantPoolInfo(c1, cp);
        assertThat(instr).isNotNull();
    }

    @Test
    public void test_SwapGen() {
        PojoVerifier.forClass(SwapGen.class).skipSetters().verified();
        ConstantPool cp = mock(ConstantPool.class);
        SwapGen instr = new SwapGen(0, new SWAP(), cp);
        assertThat(instr).isNotNull();
    }
}
