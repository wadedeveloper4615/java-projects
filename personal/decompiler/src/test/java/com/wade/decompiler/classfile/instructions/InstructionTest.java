package com.wade.decompiler.classfile.instructions;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;
import com.wade.decompiler.util.ByteSequence;
import com.wade.pojotester.PojoVerifier;

public class InstructionTest {
    @Test
    public void test_AALOAD() {
        PojoVerifier.forClass(AALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_AASTORE() {
        PojoVerifier.forClass(AASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_ACONST_NULL() {
        PojoVerifier.forClass(ACONST_NULL.class).skipSetters().verified();
    }

    @Test
    public void test_ALOAD_NONWIDE_NoException() throws Exception {
        PojoVerifier.forClass(ALOAD.class).skipSetters().verified();

        ALOAD instr = new ALOAD(0);
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new ALOAD(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new ALOAD(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new ALOAD(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new ALOAD();
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_ALOAD_WIDE() throws Exception {
        PojoVerifier.forClass(ALOAD.class).skipSetters().verified();
        ALOAD instr = new ALOAD();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_ANEWARRAY() throws Exception {
        PojoVerifier.forClass(ANEWARRAY.class).skipSetters().verified();
        ANEWARRAY instr = new ANEWARRAY();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_ARETURN() {
        PojoVerifier.forClass(ARETURN.class).skipSetters().verified();
    }

    @Test
    public void test_ARRAYLENGTH() {
        PojoVerifier.forClass(ARRAYLENGTH.class).skipSetters().verified();
    }

    @Test
    public void test_ASTORE_NONWIDE() throws Exception {
        PojoVerifier.forClass(ASTORE.class).skipSetters().verified();

        ASTORE instr = new ASTORE();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new ASTORE(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new ASTORE(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new ASTORE(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new ASTORE(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new ASTORE(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_ASTORE_WIDE() throws Exception {
        PojoVerifier.forClass(ASTORE.class).skipSetters().verified();
        ASTORE instr = new ASTORE(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_ATHROW() {
        PojoVerifier.forClass(ATHROW.class).skipSetters().verified();
    }

    @Test
    public void test_BALOAD() {
        PojoVerifier.forClass(BALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_BASTORE() {
        PojoVerifier.forClass(BASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_BIPUSH() {
        PojoVerifier.forClass(BIPUSH.class).skipEquals().skipHashCode().skipSetters().verified();
    }

    @Test
    public void test_BREAKPOINT() {
        PojoVerifier.forClass(BREAKPOINT.class).skipSetters().verified();
    }

    @Test
    public void test_CALOAD() {
        PojoVerifier.forClass(CALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_CASTORE() {
        PojoVerifier.forClass(CASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_CHECKCAST() throws Exception {
        PojoVerifier.forClass(CHECKCAST.class).skipSetters().verified();
        CHECKCAST instr = new CHECKCAST();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_D2F() {
        PojoVerifier.forClass(D2F.class).skipSetters().verified();
    }

    @Test
    public void test_D2I() {
        PojoVerifier.forClass(D2I.class).skipSetters().verified();
    }

    @Test
    public void test_D2L() {
        PojoVerifier.forClass(D2L.class).skipSetters().verified();
    }

    @Test
    public void test_DADD() {
        PojoVerifier.forClass(DADD.class).skipSetters().verified();
    }

    @Test
    public void test_DALOAD() {
        PojoVerifier.forClass(DALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_DASTORE() {
        PojoVerifier.forClass(DASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_DCMPG() {
        PojoVerifier.forClass(DCMPG.class).skipSetters().verified();
        assertThat(new DCMPG().negate()).isNotNull();
    }

    @Test
    public void test_DCMPL() {
        PojoVerifier.forClass(DCMPL.class).skipSetters().verified();
        assertThat(new DCMPL().negate()).isNotNull();
    }

    @Test(expected = ClassGenException.class)
    public void test_DCONST_Exception() {
        PojoVerifier.forClass(DCONST.class).skipSetters().verified();
        new DCONST(2.0);
    }

    @Test
    public void test_DDIV() {
        PojoVerifier.forClass(DDIV.class).skipSetters().verified();
    }

    @Test
    public void test_DLOAD_NONWIDE() throws Exception {
        PojoVerifier.forClass(DLOAD.class).skipSetters().verified();

        DLOAD instr = new DLOAD();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new DLOAD(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new DLOAD(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new DLOAD(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new DLOAD(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new DLOAD(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_DLOAD_WIDE() throws Exception {
        PojoVerifier.forClass(DLOAD.class).skipSetters().verified();
        DLOAD instr = new DLOAD(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_DMUL() {
        PojoVerifier.forClass(DMUL.class).skipSetters().verified();
    }

    @Test
    public void test_DNEG() {
        PojoVerifier.forClass(DNEG.class).skipSetters().verified();
    }

    @Test
    public void test_DREM() {
        PojoVerifier.forClass(DREM.class).skipSetters().verified();
    }

    @Test
    public void test_DRETURN() {
        PojoVerifier.forClass(DRETURN.class).skipSetters().verified();
    }

    @Test
    public void test_DSTORE_Part2() throws Exception {
        PojoVerifier.forClass(DSTORE.class).skipSetters().verified();
        DSTORE instr = new DSTORE(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_DSTOREPart1() throws Exception {
        PojoVerifier.forClass(DSTORE.class).skipSetters().verified();

        DSTORE instr = new DSTORE();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new DSTORE(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new DSTORE(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new DSTORE(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new DSTORE(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new DSTORE(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_DSUB() {
        PojoVerifier.forClass(DSUB.class).skipSetters().verified();
    }

    @Test
    public void test_DUP() {
        PojoVerifier.forClass(DUP.class).skipSetters().verified();
    }

    @Test
    public void test_DUP_X1() {
        PojoVerifier.forClass(DUP_X1.class).skipSetters().verified();
    }

    @Test
    public void test_DUP2() {
        PojoVerifier.forClass(DUP2.class).skipSetters().verified();
    }

    @Test
    public void test_DUP2_X1() {
        PojoVerifier.forClass(DUP2_X1.class).skipSetters().verified();
    }

    @Test
    public void test_DUP2X2() {
        PojoVerifier.forClass(DUP2_X2.class).skipSetters().verified();
    }

    @Test
    public void test_DUPX2() {
        PojoVerifier.forClass(DUP_X2.class).skipSetters().verified();
    }

    @Test
    public void test_F2D() {
        PojoVerifier.forClass(F2D.class).skipSetters().verified();
    }

    @Test
    public void test_F2I() {
        PojoVerifier.forClass(F2I.class).skipSetters().verified();
    }

    @Test
    public void test_F2L() {
        PojoVerifier.forClass(F2L.class).skipSetters().verified();
    }

    @Test
    public void test_FADD() {
        PojoVerifier.forClass(FADD.class).skipSetters().verified();
    }

    @Test
    public void test_FALOAD() {
        PojoVerifier.forClass(FALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_FALOAD_Part2() throws IOException {
        PojoVerifier.forClass(FLOAD.class).skipSetters().verified();

        FLOAD instr = new FLOAD(0);
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new FLOAD(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new FLOAD(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new FLOAD(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new FLOAD(4);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_FASTORE() {
        PojoVerifier.forClass(FASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_FCMPG() {
        PojoVerifier.forClass(FCMPG.class).skipSetters().verified();
        FCMPG instr = new FCMPG();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_FCMPL() {
        PojoVerifier.forClass(FCMPL.class).skipSetters().verified();
        FCMPL instr = new FCMPL();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.negate()).isNotNull();
    }

    @Test(expected = ClassGenException.class)
    public void test_FCONST_EXCEPTION() {
        PojoVerifier.forClass(FCONST.class).skipEquals().skipHashCode().skipSetters().verified();
        FCONST instr = new FCONST(0);
        assertThat(instr.getOpcode()).isEqualTo(InstructionOpCodes.FCONST_0);
        instr = new FCONST(1);
        assertThat(instr.getOpcode()).isEqualTo(InstructionOpCodes.FCONST_1);
        instr = new FCONST(2);
        assertThat(instr.getOpcode()).isEqualTo(InstructionOpCodes.FCONST_2);
        new FCONST(3);
    }

    @Test
    public void test_FDIV() {
        PojoVerifier.forClass(FDIV.class).skipSetters().verified();
    }

    @Test
    public void test_FLOAD_Part1() throws IOException {
        PojoVerifier.forClass(FLOAD.class).skipSetters().verified();
        FLOAD instr = new FLOAD(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_FLOAD_Part2() throws IOException {
        PojoVerifier.forClass(FLOAD.class).skipSetters().verified();

        FLOAD instr = new FLOAD();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new FLOAD(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new FLOAD(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new FLOAD(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new FLOAD(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);
    }

    @Test
    public void test_FMUL() {
        PojoVerifier.forClass(FMUL.class).skipSetters().verified();
    }

    @Test
    public void test_FNEG() {
        PojoVerifier.forClass(FNEG.class).skipSetters().verified();
    }

    @Test
    public void test_FREM() {
        PojoVerifier.forClass(FREM.class).skipSetters().verified();
    }

    @Test
    public void test_FRETURN() {
        PojoVerifier.forClass(FRETURN.class).skipSetters().verified();
    }

    @Test
    public void test_FSTORE_Part1() throws Exception {
        PojoVerifier.forClass(FSTORE.class).skipSetters().verified();

        FSTORE instr = new FSTORE();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new FSTORE(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new FSTORE(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new FSTORE(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new FSTORE(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new FSTORE(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_FSTORE_Part2() throws Exception {
        PojoVerifier.forClass(FSTORE.class).skipSetters().verified();
        FSTORE instr = new FSTORE(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_FSUB() {
        PojoVerifier.forClass(FSUB.class).skipSetters().verified();
    }

    @Test
    public void test_GETFIELD() {
        PojoVerifier.forClass(GETFIELD.class).skipSetters().verified();
    }

    @Test
    public void test_GETSTATIC() throws Exception {
        PojoVerifier.forClass(GETSTATIC.class).skipSetters().verified();
        GETSTATIC instr = new GETSTATIC();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
    }

    @Test
    public void test_GOTO() {
        PojoVerifier.forClass(GOTO.class).skipSetters().verified();
    }

    @Test
    public void test_GOTO_W() throws Exception {
        PojoVerifier.forClass(GOTO_W.class).skipSetters().verified();
        GOTO_W instr = new GOTO_W();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 0, 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(5);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_I2B() {
        PojoVerifier.forClass(I2B.class).skipSetters().verified();
    }

    @Test
    public void test_I2C() {
        PojoVerifier.forClass(I2C.class).skipSetters().verified();
    }

    @Test
    public void test_I2D() {
        PojoVerifier.forClass(I2D.class).skipSetters().verified();
    }

    @Test
    public void test_I2F() {
        PojoVerifier.forClass(I2F.class).skipSetters().verified();
    }

    @Test
    public void test_I2L() {
        PojoVerifier.forClass(I2L.class).skipSetters().verified();
    }

    @Test
    public void test_I2S() {
        PojoVerifier.forClass(I2S.class).skipSetters().verified();
    }

    @Test
    public void test_IADD() {
        PojoVerifier.forClass(IADD.class).skipSetters().verified();
    }

    @Test
    public void test_IALOAD() {
        PojoVerifier.forClass(IALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_IAND() {
        PojoVerifier.forClass(IAND.class).skipSetters().verified();
    }

    @Test
    public void test_IASTORE() {
        PojoVerifier.forClass(IASTORE.class).skipSetters().verified();
    }

    @Test(expected = ClassGenException.class)
    public void test_ICONST_Exception1() {
        PojoVerifier.forClass(ICONST.class).skipSetters().verified();
        new ICONST(-2);
    }

    @Test(expected = ClassGenException.class)
    public void test_ICONST_Exception2() {
        PojoVerifier.forClass(ICONST.class).skipSetters().verified();
        new ICONST(6);
    }

    @Test
    public void test_IDIV() {
        PojoVerifier.forClass(IDIV.class).skipSetters().verified();
    }

    @Test
    public void test_IF_ACMPEQ() throws Exception {
        PojoVerifier.forClass(IF_ACMPEQ.class).skipSetters().verified();
        IF_ACMPEQ instr = new IF_ACMPEQ();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ACMPNE() throws Exception {
        PojoVerifier.forClass(IF_ACMPNE.class).skipSetters().verified();
        IF_ACMPNE instr = new IF_ACMPNE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ICMPEQ() throws Exception {
        PojoVerifier.forClass(IF_ICMPEQ.class).skipSetters().verified();
        IF_ICMPEQ instr = new IF_ICMPEQ();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ICMPGE() throws Exception {
        PojoVerifier.forClass(IF_ICMPGE.class).skipSetters().verified();
        IF_ICMPGE instr = new IF_ICMPGE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ICMPGT() throws Exception {
        PojoVerifier.forClass(IF_ICMPGT.class).skipSetters().verified();
        IF_ICMPGT instr = new IF_ICMPGT();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ICMPLE() throws Exception {
        PojoVerifier.forClass(IF_ICMPLE.class).skipSetters().verified();
        IF_ICMPLE instr = new IF_ICMPLE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ICMPLT() throws Exception {
        PojoVerifier.forClass(IF_ICMPLT.class).skipSetters().verified();
        IF_ICMPLT instr = new IF_ICMPLT();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IF_ICMPNE() throws Exception {
        PojoVerifier.forClass(IF_ICMPNE.class).skipSetters().verified();
        IF_ICMPNE instr = new IF_ICMPNE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFEQ() throws Exception {
        PojoVerifier.forClass(IFEQ.class).skipSetters().verified();
        IFEQ instr = new IFEQ();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFGE() throws Exception {
        PojoVerifier.forClass(IFGE.class).skipSetters().verified();
        IFGE instr = new IFGE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFGT() throws Exception {
        PojoVerifier.forClass(IFGT.class).skipSetters().verified();
        IFGT instr = new IFGT();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFLE() throws Exception {
        PojoVerifier.forClass(IFLE.class).skipSetters().verified();
        IFLE instr = new IFLE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFLT() throws Exception {
        PojoVerifier.forClass(IFLT.class).skipSetters().verified();
        IFLT instr = new IFLT();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFNE() throws Exception {
        PojoVerifier.forClass(IFNE.class).skipSetters().verified();
        IFNE instr = new IFNE();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFNONNULL() {
        PojoVerifier.forClass(IFNONNULL.class).skipSetters().verified();
    }

    @Test
    public void test_IFNONNULL_Part2() throws Exception {
        PojoVerifier.forClass(IFNONNULL.class).skipSetters().verified();
        IFNONNULL instr = new IFNONNULL();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IFNULL() throws Exception {
        PojoVerifier.forClass(IFNULL.class).skipSetters().verified();
        IFNULL instr = new IFNULL();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
        assertThat(instr.negate()).isNotNull();
    }

    @Test
    public void test_IINC_Part1() throws Exception {
        PojoVerifier.forClass(IINC.class).skipEquals().skipHashCode().skipSetters().verified();
        IINC instr = new IINC();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5, 0, 6 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(6);
        assertThat(instr.getIndex()).isEqualTo(5);
        assertThat(instr.getIncrement()).isEqualTo((short) 6);
    }

    @Test
    public void test_IINC_Part2() throws Exception {
        PojoVerifier.forClass(IINC.class).skipEquals().skipHashCode().skipSetters().verified();
        IINC instr = new IINC();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5, 6 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo(5);
        assertThat(instr.getIncrement()).isEqualTo((short) 6);
    }

    @Test
    public void test_ILOAD_Part1() throws Exception {
        PojoVerifier.forClass(ILOAD.class).skipSetters().verified();
        ILOAD instr = new ILOAD(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_ILOAD_Part2() throws Exception {
        PojoVerifier.forClass(ILOAD.class).skipSetters().verified();

        ILOAD instr = new ILOAD();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new ILOAD(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new ILOAD(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new ILOAD(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new ILOAD(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new ILOAD(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_IMPDEP1() {
        PojoVerifier.forClass(IMPDEP1.class).skipSetters().verified();
    }

    @Test
    public void test_IMPDEP2() {
        PojoVerifier.forClass(IMPDEP2.class).skipSetters().verified();
    }

    @Test
    public void test_IMUL() {
        PojoVerifier.forClass(IMUL.class).skipSetters().verified();
    }

    @Test
    public void test_INEG() {
        PojoVerifier.forClass(INEG.class).skipSetters().verified();
    }

    @Test
    public void test_INSTANCOF() throws Exception {
        PojoVerifier.forClass(INSTANCEOF.class).skipSetters().verified();
        INSTANCEOF instr = new INSTANCEOF();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
    }

    @Test
    public void test_INVOKEDYNAMIC() throws Exception {
        PojoVerifier.forClass(INVOKEDYNAMIC.class).skipSetters().verified();
        INVOKEDYNAMIC instr = new INVOKEDYNAMIC();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5, 0, 0 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(5);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_INVOKEINTERFACE() {
        PojoVerifier.forClass(INVOKEINTERFACE.class).skipSetters().verified();
    }

    @Test
    public void test_INVOKESPECIAL() {
        PojoVerifier.forClass(INVOKESPECIAL.class).skipSetters().verified();
    }

    @Test
    public void test_INVOKESTATIC() {
        PojoVerifier.forClass(INVOKESTATIC.class).skipSetters().verified();
    }

    @Test
    public void test_INVOKEVIRTUAL() {
        PojoVerifier.forClass(INVOKEVIRTUAL.class).skipSetters().verified();
    }

    @Test
    public void test_IOR() {
        PojoVerifier.forClass(IOR.class).skipSetters().verified();
    }

    @Test
    public void test_IREM() {
        PojoVerifier.forClass(IREM.class).skipSetters().verified();
    }

    @Test
    public void test_IRETURN() {
        PojoVerifier.forClass(IRETURN.class).skipSetters().verified();
    }

    @Test
    public void test_ISHL() {
        PojoVerifier.forClass(ISHL.class).skipSetters().verified();
    }

    @Test
    public void test_ISHR() {
        PojoVerifier.forClass(ISHR.class).skipSetters().verified();
    }

    @Test
    public void test_ISTORE_Part1() throws Exception {
        PojoVerifier.forClass(ISTORE.class).skipSetters().verified();

        ISTORE instr = new ISTORE(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_ISTORE_Part2() throws Exception {
        PojoVerifier.forClass(ISTORE.class).skipSetters().verified();

        ISTORE instr = new ISTORE();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new ISTORE(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new ISTORE(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new ISTORE(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new ISTORE(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new ISTORE(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_ISUB() {
        PojoVerifier.forClass(ISUB.class).skipSetters().verified();
    }

    @Test
    public void test_IUSHR() {
        PojoVerifier.forClass(IUSHR.class).skipSetters().verified();
    }

    @Test
    public void test_IXOR() {
        PojoVerifier.forClass(IXOR.class).skipSetters().verified();
    }

    @Test
    public void test_JSR() {
        PojoVerifier.forClass(JSR.class).skipSetters().verified();
    }

    @Test
    public void test_JSR_W() throws Exception {
        PojoVerifier.forClass(JSR_W.class).skipSetters().verified();
        JSR_W instr = new JSR_W();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 0, 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(5);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
    }

    @Test
    public void test_L2D() {
        PojoVerifier.forClass(L2D.class).skipSetters().verified();
    }

    @Test
    public void test_L2F() {
        PojoVerifier.forClass(L2F.class).skipSetters().verified();
    }

    @Test
    public void test_L2I() {
        PojoVerifier.forClass(L2I.class).skipSetters().verified();
    }

    @Test
    public void test_LADD() {
        PojoVerifier.forClass(LADD.class).skipSetters().verified();
    }

    @Test
    public void test_LALOAD() {
        PojoVerifier.forClass(LALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_LAND() {
        PojoVerifier.forClass(LAND.class).skipSetters().verified();
    }

    @Test
    public void test_LASTORE() {
        PojoVerifier.forClass(LASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_LCMP() {
        PojoVerifier.forClass(LCMP.class).skipSetters().verified();
    }

    @Test(expected = ClassGenException.class)
    public void test_LCONST() throws Exception {
        PojoVerifier.forClass(LCONST.class).skipEquals().skipHashCode().skipSetters().verified();
        new LCONST(2);
    }

    @Test
    public void test_LDC() throws Exception {
        PojoVerifier.forClass(LDC.class).skipSetters().verified();
        LDC instr = new LDC();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_LDC_W() throws Exception {
        PojoVerifier.forClass(LDC_W.class).skipSetters().verified();
        LDC_W instr = new LDC_W();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_LDC2_W() throws Exception {
        PojoVerifier.forClass(LDC2_W.class).skipSetters().verified();
        LDC2_W instr = new LDC2_W();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_LDIV() {
        PojoVerifier.forClass(LDIV.class).skipSetters().verified();
    }

    @Test
    public void test_LLOAD_Part1() throws Exception {
        PojoVerifier.forClass(LLOAD.class).skipSetters().verified();

        LLOAD instr = new LLOAD();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new LLOAD(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new LLOAD(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new LLOAD(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new LLOAD(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new LLOAD(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_LLOAD_Part2() throws Exception {
        PojoVerifier.forClass(LLOAD.class).skipSetters().verified();
        LLOAD instr = new LLOAD(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_LMUL() {
        PojoVerifier.forClass(LMUL.class).skipSetters().verified();
    }

    @Test
    public void test_LNEG() {
        PojoVerifier.forClass(LNEG.class).skipSetters().verified();
    }

    @Test
    public void test_LOOKUPSWITCH() throws Exception {
        PojoVerifier.forClass(LOOKUPSWITCH.class).skipSetters().verified();
        LOOKUPSWITCH instr = new LOOKUPSWITCH();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 7 });
        mock.readByte();
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(26);
        assertThat(instr.getPadding()).isEqualTo(3);
        assertThat(instr.getMatch()).isNotNull();
        assertThat(instr.getOffsets()).isNotNull();
        assertThat(instr.getMatch()).isNotNull();
        assertThat(instr.getOffsets()).isNotNull();
        assertThat(instr.getMatch().size()).isEqualTo(2);
        assertThat(instr.getOffsets().length).isEqualTo(2);
        assertThat(instr.getDefaultOffset()).isEqualTo(2);
    }

    @Test
    public void test_LOR() {
        PojoVerifier.forClass(LOR.class).skipSetters().verified();
    }

    @Test
    public void test_LREM() {
        PojoVerifier.forClass(LREM.class).skipSetters().verified();
    }

    @Test
    public void test_LRETURN() {
        PojoVerifier.forClass(LRETURN.class).skipSetters().verified();
    }

    @Test
    public void test_LSHL() {
        PojoVerifier.forClass(LSHL.class).skipSetters().verified();
    }

    @Test
    public void test_LSHR() {
        PojoVerifier.forClass(LSHR.class).skipSetters().verified();
    }

    @Test
    public void test_LSTORE_Part1() throws Exception {
        PojoVerifier.forClass(LSTORE.class).skipSetters().verified();
        LSTORE instr = new LSTORE(2);
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_LSTORE_Part2() throws Exception {
        PojoVerifier.forClass(LSTORE.class).skipSetters().verified();

        LSTORE instr = new LSTORE();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);

        instr = new LSTORE(0);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(0);

        instr = new LSTORE(1);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(1);

        instr = new LSTORE(2);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(2);

        instr = new LSTORE(3);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(1);
        assertThat(instr.getIndex()).isEqualTo(3);

        instr = new LSTORE(5);
        instr.setWide(false);
        mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isNull();
        assertThat(instr.getIndex()).isNull();
    }

    @Test
    public void test_LSUB9() {
        PojoVerifier.forClass(LSUB.class).skipSetters().verified();
    }

    @Test
    public void test_LUSHR() {
        PojoVerifier.forClass(LUSHR.class).skipSetters().verified();
    }

    @Test
    public void test_LXOR() {
        PojoVerifier.forClass(LXOR.class).skipSetters().verified();
    }

    @Test
    public void test_MONITORENTER() {
        PojoVerifier.forClass(MONITORENTER.class).skipSetters().verified();
    }

    @Test
    public void test_MONITOREXIT() {
        PojoVerifier.forClass(MONITOREXIT.class).skipSetters().verified();
    }

    @Test
    public void test_MULTIANEWARRAY_Part1() throws Exception {
        PojoVerifier.forClass(MULTIANEWARRAY.class).skipSetters().verified();
        MULTIANEWARRAY instr = new MULTIANEWARRAY();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5, 6 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
        assertThat(instr.getDimensions()).isEqualTo((byte) 6);
    }

    @Test(expected = ClassGenException.class)
    public void test_MULTIANEWARRAY_Part2() throws Exception {
        PojoVerifier.forClass(MULTIANEWARRAY.class).skipSetters().verified();
        MULTIANEWARRAY instr = new MULTIANEWARRAY();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5, -1 });
        instr.initFromFile(mock);
    }

    @Test
    public void test_NEW() {
        PojoVerifier.forClass(NEW.class).skipSetters().verified();
    }

    @Test
    public void test_NEWARRAY() throws IOException {
        PojoVerifier.forClass(NEWARRAY.class).skipSetters().verified();
        NEWARRAY instr = new NEWARRAY(null);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
    }

    @Test
    public void test_NOP() {
        PojoVerifier.forClass(NOP.class).skipSetters().verified();
    }

    @Test
    public void test_POP() {
        PojoVerifier.forClass(POP.class).skipSetters().verified();
    }

    @Test
    public void test_POP2() {
        PojoVerifier.forClass(POP2.class).skipSetters().verified();
    }

    @Test
    public void test_PUSTATIC() throws Exception {
        PojoVerifier.forClass(PUTSTATIC.class).skipSetters().verified();
        PUTSTATIC instr = new PUTSTATIC();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getIndex()).isEqualTo((short) 5);
    }

    @Test
    public void test_PUTFIELD() {
        PojoVerifier.forClass(PUTFIELD.class).skipSetters().verified();
    }

    @Test
    public void test_RET_Part2() throws Exception {
        PojoVerifier.forClass(RET.class).skipSetters().verified();
        RET instr = new RET();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_RET_Part3() throws Exception {
        PojoVerifier.forClass(RET.class).skipSetters().verified();
        RET instr = new RET();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        instr.setIndex(260);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(4);
        assertThat(instr.getIndex()).isEqualTo(260);
    }

    @Test(expected = ClassGenException.class)
    public void test_RET_Part4() throws Exception {
        PojoVerifier.forClass(RET.class).skipSetters().verified();
        RET instr = new RET();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        instr.setIndex(-1);
    }

    @Test
    public void test_RETPart1() throws Exception {
        PojoVerifier.forClass(RET.class).skipSetters().verified();
        RET instr = new RET();
        instr.setWide(false);
        ByteSequence mock = new ByteSequence(new byte[] { 5 });
        instr.initFromFile(mock);
        instr.setIndex(5);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(2);
        assertThat(instr.getIndex()).isEqualTo(5);
    }

    @Test
    public void test_RETURN() {
        PojoVerifier.forClass(RETURN.class).skipSetters().verified();
    }

    @Test
    public void test_SALOAD() {
        PojoVerifier.forClass(SALOAD.class).skipSetters().verified();
    }

    @Test
    public void test_SASTORE() {
        PojoVerifier.forClass(SASTORE.class).skipSetters().verified();
    }

    @Test
    public void test_SIPUSH() throws Exception {
        PojoVerifier.forClass(SIPUSH.class).skipSetters().verified();
        SIPUSH instr = new SIPUSH();
        ByteSequence mock = new ByteSequence(new byte[] { 0, 5 });
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(3);
        assertThat(instr.getValue()).isEqualTo((short) 5);
    }

    @Test
    public void test_SWAP() {
        PojoVerifier.forClass(SWAP.class).skipSetters().verified();
    }

    @Test
    public void test_TABLESWITCH() throws Exception {
        PojoVerifier.forClass(TABLESWITCH.class).skipSetters().verified();
        TABLESWITCH instr = new TABLESWITCH();
        instr.setWide(true);
        ByteSequence mock = new ByteSequence(new byte[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 5 });
        mock.readByte();
        instr.initFromFile(mock);
        assertThat(instr).isNotNull();
        assertThat(instr.getLength()).isEqualTo(24);
        assertThat(instr.getPadding()).isEqualTo(3);
        assertThat(instr.getMatch()).isNotNull();
        assertThat(instr.getOffsets()).isNotNull();
        assertThat(instr.getMatch().length).isEqualTo(2);
        assertThat(instr.getOffsets().length).isEqualTo(2);
        assertThat(instr.getDefaultOffset()).isEqualTo(1);
    }
}
