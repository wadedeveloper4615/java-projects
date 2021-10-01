/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.*;
import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTypeTableGen;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class InstructionGen.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
@NoArgsConstructor
public class InstructionGen {
    /**
     * Read.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param lvt    the lvt
     * @param lvtt   the lvtt
     * @param cp     the cp
     * @return the instruction gen
     */
    public static InstructionGen read(int offset, Instruction instr, LocalVariableTableGen lvt, LocalVariableTypeTableGen lvtt, ConstantPool cp) {
        InstructionGen instrgen = switch (instr.getOpcode()) {
            case AALOAD -> new ArrayLoadGen(offset, (AALOAD) instr, cp);
            case AASTORE -> new ArrayStoreGen(offset, (AASTORE) instr, cp);
            case ACONST_NULL -> new ConstGen(offset, (ACONST_NULL) instr, cp);
            case ALOAD, ALOAD_0, ALOAD_1, ALOAD_2, ALOAD_3 -> new LoadGen(offset, (ALOAD) instr, lvt, lvtt, cp);
            case ANEWARRAY -> new NewGen(offset, (ANEWARRAY) instr, cp);
            case ARETURN -> new ReturnGen(offset, (ARETURN) instr, cp);
            case ARRAYLENGTH -> new ArrayLengthGen(offset, (ARRAYLENGTH) instr, cp);
            case ASTORE, ASTORE_0, ASTORE_1, ASTORE_2, ASTORE_3 -> new StoreGen(offset, (ASTORE) instr, lvt, lvtt, cp);
            case ATHROW -> new AThrowGen(offset, (ATHROW) instr, cp);
            case BALOAD -> new ArrayLoadGen(offset, (BALOAD) instr, cp);
            case BASTORE -> new ArrayStoreGen(offset, (BASTORE) instr, cp);
            case BIPUSH -> new ConstGen(offset, (BIPUSH) instr, cp);
            case BREAKPOINT -> new BreakPointGen(offset, (BREAKPOINT) instr, cp);
            case CALOAD -> new ArrayLoadGen(offset, (CALOAD) instr, cp);
            case CASTORE -> new ArrayStoreGen(offset, (CASTORE) instr, cp);
            case CHECKCAST -> new CheckCastGen(offset, (CHECKCAST) instr, cp);
            case D2F -> new ConversionGen(offset, (D2F) instr, cp);
            case D2I -> new ConversionGen(offset, (D2I) instr, cp);
            case D2L -> new ConversionGen(offset, (D2L) instr, cp);
            case DADD -> new ArithmeticGen(offset, (DADD) instr, cp);
            case DALOAD -> new ArrayLoadGen(offset, (DALOAD) instr, cp);
            case DASTORE -> new ArrayStoreGen(offset, (DASTORE) instr, cp);
            case DCMPG -> new CompareGen(offset, (DCMPG) instr, cp);
            case DCMPL -> new CompareGen(offset, (DCMPL) instr, cp);
            case DCONST_0, DCONST_1 -> new ConstGen(offset, (DCONST) instr, cp);
            case DDIV -> new ArithmeticGen(offset, (DDIV) instr, cp);
            case DLOAD, DLOAD_0, DLOAD_1, DLOAD_2, DLOAD_3 -> new LoadGen(offset, (DLOAD) instr, lvt, lvtt, cp);
            case DMUL -> new ArithmeticGen(offset, (DMUL) instr, cp);
            case DNEG -> new ArithmeticGen(offset, (DNEG) instr, cp);
            case DREM -> new ArithmeticGen(offset, (DREM) instr, cp);
            case DRETURN -> new ReturnGen(offset, (DRETURN) instr, cp);
            case DSTORE, DSTORE_0, DSTORE_1, DSTORE_2, DSTORE_3 -> new StoreGen(offset, (DSTORE) instr, lvt, lvtt, cp);
            case DSUB -> new ArithmeticGen(offset, (DSUB) instr, cp);
            case DUP_X1 -> new DuplicateGen(offset, (DUP_X1) instr, cp);
            case DUP_X2 -> new DuplicateGen(offset, (DUP_X2) instr, cp);
            case DUP -> new DuplicateGen(offset, (DUP) instr, cp);
            case DUP2_X1 -> new DuplicateGen(offset, (DUP2_X1) instr, cp);
            case DUP2_X2 -> new DuplicateGen(offset, (DUP2_X2) instr, cp);
            case DUP2 -> new DuplicateGen(offset, (DUP2) instr, cp);
            case F2D -> new ConversionGen(offset, (F2D) instr, cp);
            case F2I -> new ConversionGen(offset, (F2I) instr, cp);
            case F2L -> new ConversionGen(offset, (F2L) instr, cp);
            case FADD -> new ArithmeticGen(offset, (FADD) instr, cp);
            case FALOAD -> new ArrayLoadGen(offset, (FALOAD) instr, cp);
            case FASTORE -> new ArrayStoreGen(offset, (FASTORE) instr, cp);
            case FCMPG -> new CompareGen(offset, (FCMPG) instr, cp);
            case FCMPL -> new CompareGen(offset, (FCMPL) instr, cp);
            case FCONST_0, FCONST_1, FCONST_2 -> new ConstGen(offset, (FCONST) instr, cp);
            case FDIV -> new ArithmeticGen(offset, (FDIV) instr, cp);
            case FLOAD, FLOAD_0, FLOAD_1, FLOAD_2, FLOAD_3 -> new LoadGen(offset, (FLOAD) instr, lvt, lvtt, cp);
            case FMUL -> new ArithmeticGen(offset, (FMUL) instr, cp);
            case FNEG -> new ArithmeticGen(offset, (FNEG) instr, cp);
            case FREM -> new ArithmeticGen(offset, (FREM) instr, cp);
            case FRETURN -> new ReturnGen(offset, (FRETURN) instr, cp);
            case FSTORE, FSTORE_0, FSTORE_1, FSTORE_2, FSTORE_3 -> new StoreGen(offset, (FSTORE) instr, lvt, lvtt, cp);
            case FSUB -> new ArithmeticGen(offset, (FSUB) instr, cp);
            case GETFIELD -> new GetFieldGen(offset, (GETFIELD) instr, cp);
            case GETSTATIC -> new GetFieldGen(offset, (GETSTATIC) instr, cp);
            case GOTO_W -> new GotoGen(offset, (GOTO_W) instr, cp);
            case GOTO -> new GotoGen(offset, (GOTO) instr, cp);
            case I2B -> new ConversionGen(offset, (I2B) instr, cp);
            case I2C -> new ConversionGen(offset, (I2C) instr, cp);
            case I2D -> new ConversionGen(offset, (I2D) instr, cp);
            case I2F -> new ConversionGen(offset, (I2F) instr, cp);
            case I2L -> new ConversionGen(offset, (I2L) instr, cp);
            case I2S -> new ConversionGen(offset, (I2S) instr, cp);
            case IADD -> new ArithmeticGen(offset, (IADD) instr, cp);
            case IALOAD -> new ArrayLoadGen(offset, (IALOAD) instr, cp);
            case IAND -> new ArithmeticGen(offset, (IAND) instr, cp);
            case IASTORE -> new ArrayStoreGen(offset, (IASTORE) instr, cp);
            case ICONST_M1, ICONST_0, ICONST_1, ICONST_2, ICONST_3, ICONST_4, ICONST_5 -> new ConstGen(offset, (ICONST) instr, cp);
            case IDIV -> new ArithmeticGen(offset, (IDIV) instr, cp);
            case IF_ACMPEQ -> new CompareGen(offset, (IF_ACMPEQ) instr, cp);
            case IF_ACMPNE -> new CompareGen(offset, (IF_ACMPNE) instr, cp);
            case IF_ICMPEQ -> new CompareGen(offset, (IF_ICMPEQ) instr, cp);
            case IF_ICMPGE -> new CompareGen(offset, (IF_ICMPGE) instr, cp);
            case IF_ICMPGT -> new CompareGen(offset, (IF_ICMPGT) instr, cp);
            case IF_ICMPLE -> new CompareGen(offset, (IF_ICMPLE) instr, cp);
            case IF_ICMPLT -> new CompareGen(offset, (IF_ICMPLT) instr, cp);
            case IF_ICMPNE -> new CompareGen(offset, (IF_ICMPNE) instr, cp);
            case IFEQ -> new CompareGen(offset, (IFEQ) instr, cp);
            case IFGE -> new CompareGen(offset, (IFGE) instr, cp);
            case IFGT -> new CompareGen(offset, (IFGT) instr, cp);
            case IFLE -> new CompareGen(offset, (IFLE) instr, cp);
            case IFLT -> new CompareGen(offset, (IFLT) instr, cp);
            case IFNE -> new CompareGen(offset, (IFNE) instr, cp);
            case IFNULL -> new CompareGen(offset, (IFNULL) instr, cp);
            case IFNONNULL -> new CompareGen(offset, (IFNONNULL) instr, cp);
            case IINC -> new IncGen(offset, (IINC) instr, lvt, cp);
            case ILOAD, ILOAD_0, ILOAD_1, ILOAD_2, ILOAD_3 -> new LoadGen(offset, (ILOAD) instr, lvt, lvtt, cp);
            case IMPDEP1 -> new ImpDepGen(offset, (IMPDEP1) instr, cp);
            case IMPDEP2 -> new ImpDepGen(offset, (IMPDEP2) instr, cp);
            case IMUL -> new ArithmeticGen(offset, (IMUL) instr, cp);
            case INEG -> new ArithmeticGen(offset, (INEG) instr, cp);
            case INSTANCEOF -> new InstanceOfGen(offset, (INSTANCEOF) instr, cp);
            case INVOKEDYNAMIC -> new InvokeGen(offset, (INVOKEDYNAMIC) instr, cp);
            case INVOKEINTERFACE -> new InvokeGen(offset, (INVOKEINTERFACE) instr, cp);
            case INVOKESPECIAL -> new InvokeGen(offset, (INVOKESPECIAL) instr, cp);
            case INVOKESTATIC -> new InvokeGen(offset, (INVOKESTATIC) instr, cp);
            case INVOKEVIRTUAL -> new InvokeGen(offset, (INVOKEVIRTUAL) instr, cp);
            case IOR -> new ArithmeticGen(offset, (IOR) instr, cp);
            case IREM -> new ArithmeticGen(offset, (IREM) instr, cp);
            case IRETURN -> new ReturnGen(offset, (IRETURN) instr, cp);
            case ISHL -> new ArithmeticGen(offset, (ISHL) instr, cp);
            case ISHR -> new ArithmeticGen(offset, (ISHR) instr, cp);
            case ISTORE, ISTORE_0, ISTORE_1, ISTORE_2, ISTORE_3 -> new StoreGen(offset, (ISTORE) instr, lvt, lvtt, cp);
            case ISUB -> new ArithmeticGen(offset, (ISUB) instr, cp);
            case IUSHR -> new ArithmeticGen(offset, (IUSHR) instr, cp);
            case IXOR -> new ArithmeticGen(offset, (IXOR) instr, cp);
            case JSR_W -> new JsrGen(offset, (JSR_W) instr, cp);
            case JSR -> new JsrGen(offset, (JSR) instr, cp);
            case L2D -> new ConversionGen(offset, (L2D) instr, cp);
            case L2F -> new ConversionGen(offset, (L2F) instr, cp);
            case L2I -> new ConversionGen(offset, (L2I) instr, cp);
            case LADD -> new ArithmeticGen(offset, (LADD) instr, cp);
            case LALOAD -> new ArrayLoadGen(offset, (LALOAD) instr, cp);
            case LAND -> new ArithmeticGen(offset, (LAND) instr, cp);
            case LASTORE -> new ArrayStoreGen(offset, (LASTORE) instr, cp);
            case LCMP -> new CompareGen(offset, (LCMP) instr, cp);
            case LCONST_0, LCONST_1 -> new ConstGen(offset, (LCONST) instr, cp);
            case LDC_W -> new ConstGen(offset, (LDC_W) instr, cp);
            case LDC -> new ConstGen(offset, (LDC) instr, cp);
            case LDC2_W -> new ConstGen(offset, (LDC2_W) instr, cp);
            case LDIV -> new ArithmeticGen(offset, (LDIV) instr, cp);
            case LLOAD, LLOAD_0, LLOAD_1, LLOAD_3, LLOAD_2 -> new LoadGen(offset, (LLOAD) instr, lvt, lvtt, cp);
            case LMUL -> new ArithmeticGen(offset, (LMUL) instr, cp);
            case LNEG -> new ArithmeticGen(offset, (LNEG) instr, cp);
            case LOOKUPSWITCH -> new LookupSwitchGen(offset, (LOOKUPSWITCH) instr, cp);
            case LOR -> new ArithmeticGen(offset, (LOR) instr, cp);
            case LREM -> new ArithmeticGen(offset, (LREM) instr, cp);
            case LRETURN -> new ReturnGen(offset, (LRETURN) instr, cp);
            case LSHL -> new ArithmeticGen(offset, (LSHL) instr, cp);
            case LSHR -> new ArithmeticGen(offset, (LSHR) instr, cp);
            case LSTORE, LSTORE_0, LSTORE_1, LSTORE_2, LSTORE_3 -> new StoreGen(offset, (LSTORE) instr, lvt, lvtt, cp);
            case LSUB -> new ArithmeticGen(offset, (LSUB) instr, cp);
            case LUSHR -> new ArithmeticGen(offset, (LUSHR) instr, cp);
            case LXOR -> new ArithmeticGen(offset, (LXOR) instr, cp);
            case MONITORENTER -> new MonitorGen(offset, (MONITORENTER) instr, cp);
            case MONITOREXIT -> new MonitorGen(offset, (MONITOREXIT) instr, cp);
            case MULTIANEWARRAY -> new NewGen(offset, (MULTIANEWARRAY) instr, cp);
            case NEW -> new NewGen(offset, (NEW) instr, cp);
            case NEWARRAY -> new NewGen(offset, (NEWARRAY) instr, cp);
            case NOP -> new NopGen(offset, (NOP) instr, cp);
            case POP -> new PopGen(offset, (POP) instr, cp);
            case POP2 -> new PopGen(offset, (POP2) instr, cp);
            case PUTFIELD -> new PutFieldGen(offset, (PUTFIELD) instr, cp);
            case PUTSTATIC -> new PutFieldGen(offset, (PUTSTATIC) instr, cp);
            case RET -> new ReturnGen(offset, (RET) instr, cp);
            case RETURN -> new ReturnGen(offset, (RETURN) instr, cp);
            case SALOAD -> new ArrayLoadGen(offset, (SALOAD) instr, cp);
            case SASTORE -> new ArrayStoreGen(offset, (SASTORE) instr, cp);
            case SIPUSH -> new ConstGen(offset, (SIPUSH) instr, cp);
            case SWAP -> new SwapGen(offset, (SWAP) instr, cp);
            case TABLESWITCH -> new TableSwitchGen(offset, (TABLESWITCH) instr, cp);
            default -> {
                System.out.println(instr);
                yield null;
            }
        };
        return instrgen;
    }

    protected boolean ifStatement;
    protected boolean endIfStatement;

    /** The offset. */
    protected int offset;
    /** The length. */
    protected int length;

    /** The constant pool. */
    @ToString.Exclude
    protected ConstantPool constantPool;

    /**
     * Instantiates a new instruction gen.
     *
     * @param offset the offset
     * @param length the length
     */
    public InstructionGen(int offset, int length) {
        this.offset = offset;
        this.length = length;
        ifStatement = false;
        endIfStatement = false;
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    public Statement decompile(Stack<Statement> stack) {
        return new Statement().comment("Unhandled " + getClass().getName());
    }
}
