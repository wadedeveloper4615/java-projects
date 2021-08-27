/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.instructions.base;

import java.io.IOException;
import java.util.List;

import com.wade.decompiler.classfile.instructions.*;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;
import com.wade.decompiler.util.ByteSequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A factory for creating Instruction objects.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class InstructionFactory {

    /**
     * Gets the instructions.
     *
     * @param opcode the opcode
     * @return the instructions
     */
    public static Instruction getInstructions(InstructionOpCodes opcode) {
        Instruction obj = switch (opcode) {
            case AALOAD -> new AALOAD();
            case AASTORE -> new AASTORE();
            case ACONST_NULL -> new ACONST_NULL();
            case ALOAD -> new ALOAD();
            case ALOAD_0 -> new ALOAD(0);
            case ALOAD_1 -> new ALOAD(1);
            case ALOAD_2 -> new ALOAD(2);
            case ALOAD_3 -> new ALOAD(3);
            case ANEWARRAY -> new ANEWARRAY();
            case ARETURN -> new ARETURN();
            case ARRAYLENGTH -> new ARRAYLENGTH();
            case ASTORE -> new ASTORE();
            case ASTORE_0 -> new ASTORE(0);
            case ASTORE_1 -> new ASTORE(1);
            case ASTORE_2 -> new ASTORE(2);
            case ASTORE_3 -> new ASTORE(3);
            case ATHROW -> new ATHROW();
            case BALOAD -> new BALOAD();
            case BASTORE -> new BASTORE();
            case BIPUSH -> new BIPUSH();
            case BREAKPOINT -> new BREAKPOINT();
            case CALOAD -> new CALOAD();
            case CASTORE -> new CASTORE();
            case CHECKCAST -> new CHECKCAST(-1);
            case D2F -> new D2F();
            case D2I -> new D2I();
            case D2L -> new D2L();
            case DADD -> new DADD();
            case DALOAD -> new DALOAD();
            case DASTORE -> new DASTORE();
            case DCMPG -> new DCMPG();
            case DCMPL -> new DCMPL();
            case DCONST_0 -> new DCONST(0);
            case DCONST_1 -> new DCONST(1);
            case DDIV -> new DDIV();
            case DLOAD -> new DLOAD();
            case DLOAD_0 -> new DLOAD(0);
            case DLOAD_1 -> new DLOAD(1);
            case DLOAD_2 -> new DLOAD(2);
            case DLOAD_3 -> new DLOAD(3);
            case DMUL -> new DMUL();
            case DNEG -> new DNEG();
            case DREM -> new DREM();
            case DRETURN -> new DRETURN();
            case DSTORE -> new DSTORE();
            case DSTORE_0 -> new DSTORE(0);
            case DSTORE_1 -> new DSTORE(1);
            case DSTORE_2 -> new DSTORE(2);
            case DSTORE_3 -> new DSTORE(3);
            case DSUB -> new DSUB();
            case DUP_X1 -> new DUP_X1();
            case DUP_X2 -> new DUP_X2();
            case DUP -> new DUP();
            case DUP2_X1 -> new DUP2_X1();
            case DUP2_X2 -> new DUP2_X2();
            case DUP2 -> new DUP2();
            case F2D -> new F2D();
            case F2I -> new F2I();
            case F2L -> new F2L();
            case FADD -> new FADD();
            case FALOAD -> new FALOAD();
            case FASTORE -> new FASTORE();
            case FCMPG -> new FCMPG();
            case FCMPL -> new FCMPL();
            case FCONST_0 -> new FCONST(0);
            case FCONST_1 -> new FCONST(1);
            case FCONST_2 -> new FCONST(2);
            case FDIV -> new FDIV();
            case FLOAD -> new FLOAD();
            case FLOAD_0 -> new FLOAD(0);
            case FLOAD_1 -> new FLOAD(1);
            case FLOAD_2 -> new FLOAD(2);
            case FLOAD_3 -> new FLOAD(3);
            case FMUL -> new FMUL();
            case FNEG -> new FNEG();
            case FREM -> new FREM();
            case FRETURN -> new FRETURN();
            case FSTORE -> new FSTORE();
            case FSTORE_0 -> new FSTORE(0);
            case FSTORE_1 -> new FSTORE(1);
            case FSTORE_2 -> new FSTORE(2);
            case FSTORE_3 -> new FSTORE(3);
            case FSUB -> new FSUB();
            case GETFIELD -> new GETFIELD();
            case GETSTATIC -> new GETSTATIC();
            case GOTO_W -> new GOTO_W();
            case GOTO -> new GOTO();
            case I2B -> new I2B();
            case I2C -> new I2C();
            case I2D -> new I2D();
            case I2F -> new I2F();
            case I2L -> new I2L();
            case I2S -> new I2S();
            case IADD -> new IADD();
            case IALOAD -> new IALOAD();
            case IAND -> new IAND();
            case IASTORE -> new IASTORE();
            case ICONST_M1 -> new ICONST(-1);
            case ICONST_0 -> new ICONST(0);
            case ICONST_1 -> new ICONST(1);
            case ICONST_2 -> new ICONST(2);
            case ICONST_3 -> new ICONST(3);
            case ICONST_4 -> new ICONST(4);
            case ICONST_5 -> new ICONST(5);
            case IDIV -> new IDIV();
            case IF_ACMPEQ -> new IF_ACMPEQ();
            case IF_ACMPNE -> new IF_ACMPNE();
            case IF_ICMPEQ -> new IF_ICMPEQ();
            case IF_ICMPGE -> new IF_ICMPGE();
            case IF_ICMPGT -> new IF_ICMPGT();
            case IF_ICMPLE -> new IF_ICMPLE();
            case IF_ICMPLT -> new IF_ICMPLT();
            case IF_ICMPNE -> new IF_ICMPNE();
            case IFEQ -> new IFEQ();
            case IFGE -> new IFGE();
            case IFGT -> new IFGT();
            case IFLE -> new IFLE();
            case IFLT -> new IFLT();
            case IFNE -> new IFNE();
            case IFNULL -> new IFNULL();
            case IFNONNULL -> new IFNONNULL();
            case IINC -> new IINC();
            case ILOAD -> new ILOAD();
            case ILOAD_0 -> new ILOAD(0);
            case ILOAD_1 -> new ILOAD(1);
            case ILOAD_2 -> new ILOAD(2);
            case ILOAD_3 -> new ILOAD(3);
            case IMPDEP1 -> new IMPDEP1();
            case IMPDEP2 -> new IMPDEP2();
            case IMUL -> new IMUL();
            case INEG -> new INEG();
            case INSTANCEOF -> new INSTANCEOF();
            case INVOKEDYNAMIC -> new INVOKEDYNAMIC();
            case INVOKEINTERFACE -> new INVOKEINTERFACE();
            case INVOKESPECIAL -> new INVOKESPECIAL();
            case INVOKESTATIC -> new INVOKESTATIC();
            case INVOKEVIRTUAL -> new INVOKEVIRTUAL();
            case IOR -> new IOR();
            case IREM -> new IREM();
            case IRETURN -> new IRETURN();
            case ISHL -> new ISHL();
            case ISHR -> new ISHR();
            case ISTORE -> new ISTORE();
            case ISTORE_0 -> new ISTORE(0);
            case ISTORE_1 -> new ISTORE(1);
            case ISTORE_2 -> new ISTORE(2);
            case ISTORE_3 -> new ISTORE(3);
            case ISUB -> new ISUB();
            case IUSHR -> new IUSHR();
            case IXOR -> new IXOR();
            case JSR_W -> new JSR_W();
            case JSR -> new JSR();
            case L2D -> new L2D();
            case L2F -> new L2F();
            case L2I -> new L2I();
            case LADD -> new LADD();
            case LALOAD -> new LALOAD();
            case LAND -> new LAND();
            case LASTORE -> new LASTORE();
            case LCMP -> new LCMP();
            case LCONST_0 -> new LCONST(0);
            case LCONST_1 -> new LCONST(1);
            case LDC_W -> new LDC_W();
            case LDC -> new LDC();
            case LDC2_W -> new LDC2_W();
            case LDIV -> new LDIV();
            case LLOAD -> new LLOAD();
            case LLOAD_0 -> new LLOAD(0);
            case LLOAD_1 -> new LLOAD(1);
            case LLOAD_2 -> new LLOAD(2);
            case LLOAD_3 -> new LLOAD(3);
            case LMUL -> new LMUL();
            case LNEG -> new LNEG();
            case LOOKUPSWITCH -> new LOOKUPSWITCH((List<Integer>) null);
            case LOR -> new LOR();
            case LREM -> new LREM();
            case LRETURN -> new LRETURN();
            case LSHL -> new LSHL();
            case LSHR -> new LSHR();
            case LSTORE -> new LSTORE();
            case LSTORE_0 -> new LSTORE(0);
            case LSTORE_1 -> new LSTORE(1);
            case LSTORE_2 -> new LSTORE(2);
            case LSTORE_3 -> new LSTORE(3);
            case LSUB -> new LSUB();
            case LUSHR -> new LUSHR();
            case LXOR -> new LXOR();
            case MONITORENTER -> new MONITORENTER();
            case MONITOREXIT -> new MONITOREXIT();
            case MULTIANEWARRAY -> new MULTIANEWARRAY();
            case NEW -> new NEW();
            case NEWARRAY -> new NEWARRAY();
            case NOP -> new NOP();
            case POP -> new POP();
            case POP2 -> new POP2();
            case PUTFIELD -> new PUTFIELD();
            case PUTSTATIC -> new PUTSTATIC();
            case RET -> new RET();
            case RETURN -> new RETURN();
            case SALOAD -> new SALOAD();
            case SASTORE -> new SASTORE();
            case SIPUSH -> new SIPUSH();
            case SWAP -> new SWAP();
            case TABLESWITCH -> new TABLESWITCH(null);
            default -> {
                throw new ClassGenException("Illegal opcode detected: " + opcode);
            }
        };
        return obj;
    }

    /**
     * Read instruction.
     *
     * @param bytes  the bytes
     * @param offset the offset
     * @return the instruction
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Instruction readInstruction(ByteSequence bytes, int offset) throws IOException {
        boolean wide = false;
        InstructionOpCodes opcode = InstructionOpCodes.read(bytes.readUnsignedByte());
        if (opcode == InstructionOpCodes.WIDE) {
            wide = true;
            opcode = InstructionOpCodes.read(bytes.readUnsignedByte());
        }
        Instruction obj = getInstructions(opcode);
        obj.wide = wide;
        obj.opcode = opcode;
        obj.offset = offset;
        obj.initFromFile(bytes);
        return obj;
    }
}
