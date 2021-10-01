package com.wade.decompiler.classfile.instructions.base;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.wade.decompiler.classfile.instructions.ALOAD;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;
import com.wade.pojotester.PojoVerifier;

public class InstructionTest {
    @Test
    public void test1() {
        PojoVerifier.forClass(Instruction.class).skipSetters().verified();
    }

    @Test
    public void test10() {
        Instruction result = InstructionFactory.getInstructions(InstructionOpCodes.ALOAD_3);
        assertThat(result).isInstanceOf(ALOAD.class);
    }

    @Test
    public void test2() {
        PojoVerifier.forClass(InstructionList.class).skipSetters().verified();
    }

    @Test
    public void test3() {
        PojoVerifier.forClass(InstructionFactory.class).skipSetters().verified();
        for (InstructionOpCodes opcode : InstructionOpCodes.values()) {
            if (opcode != InstructionOpCodes.PUTFIELD2_QUICK && opcode != InstructionOpCodes.GETFIELD2_QUICK && opcode != InstructionOpCodes.PUTFIELD_QUICK && opcode != InstructionOpCodes.GETFIELD_QUICK && opcode != InstructionOpCodes.LDC2_W_QUICK && opcode != InstructionOpCodes.LDC_W_QUICK && opcode != InstructionOpCodes.LDC_QUICK && opcode != InstructionOpCodes.WIDE && opcode != InstructionOpCodes.INVOKENONVIRTUAL && opcode != InstructionOpCodes.INT2BYTE && opcode != InstructionOpCodes.INT2CHAR
                    && opcode != InstructionOpCodes.INVOKEINTERFACE_QUICK && opcode != InstructionOpCodes.INVOKESTATIC_QUICK && opcode != InstructionOpCodes.INVOKESUPER_QUICK && opcode != InstructionOpCodes.INVOKEVIRTUAL_QUICK && opcode != InstructionOpCodes.INVOKENONVIRTUAL_QUICK && opcode != InstructionOpCodes.PUTSTATIC2_QUICK && opcode != InstructionOpCodes.PUTSTATIC_QUICK && opcode != InstructionOpCodes.GETSTATIC_QUICK && opcode != InstructionOpCodes.GETSTATIC2_QUICK
                    && opcode != InstructionOpCodes.PUTFIELD_QUICK_W && opcode != InstructionOpCodes.GETFIELD_QUICK_W && opcode != InstructionOpCodes.INVOKEVIRTUAL_QUICK_W && opcode != InstructionOpCodes.INSTANCEOF_QUICK && opcode != InstructionOpCodes.CHECKCAST_QUICK && opcode != InstructionOpCodes.MULTIANEWARRAY_QUICK && opcode != InstructionOpCodes.ANEWARRAY_QUICK && opcode != InstructionOpCodes.NEW_QUICK && opcode != InstructionOpCodes.INVOKEVIRTUALOBJECT_QUICK
                    && opcode != InstructionOpCodes.INT2SHORT) {
                InstructionFactory.getInstructions(opcode);
            }
        }
    }

    @Test(expected = ClassGenException.class)
    public void test4() {
        InstructionFactory.getInstructions(InstructionOpCodes.PUTFIELD2_QUICK);
    }
}
