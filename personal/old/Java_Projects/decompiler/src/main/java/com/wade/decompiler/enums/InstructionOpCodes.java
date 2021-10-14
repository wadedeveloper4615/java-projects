package com.wade.decompiler.enums;

public enum InstructionOpCodes {
    //@formatter:off
    NOP(0), ACONST_NULL(1), ICONST_M1(2), ICONST_0(3), ICONST_1(4), ICONST_2(5), ICONST_3(6), ICONST_4(7), ICONST_5(8), LCONST_0(9), LCONST_1(10), FCONST_0(11), FCONST_1(12), FCONST_2(13), DCONST_0(14), DCONST_1(15), BIPUSH(16), SIPUSH(17), LDC(18), LDC_W(19), LDC2_W(20), ILOAD(21), LLOAD(22), FLOAD(23), DLOAD(24), ALOAD(25), ILOAD_0(26), ILOAD_1(27), ILOAD_2(28), ILOAD_3(29), LLOAD_0(30), LLOAD_1(31), LLOAD_2(32), LLOAD_3(33), FLOAD_0(34), FLOAD_1(35), FLOAD_2(36), FLOAD_3(37), DLOAD_0(38), DLOAD_1(39), DLOAD_2(40), DLOAD_3(41), ALOAD_0(42), ALOAD_1(43), ALOAD_2(44), ALOAD_3(45), IALOAD(46), LALOAD(47), FALOAD(48), DALOAD(49), AALOAD(50), BALOAD(51), CALOAD(52), SALOAD(53), ISTORE(54), LSTORE(55), FSTORE(56), DSTORE(57), ASTORE(58), ISTORE_0(59), ISTORE_1(60), ISTORE_2(61), ISTORE_3(62), LSTORE_0(63), LSTORE_1(64), LSTORE_2(65), LSTORE_3(66), FSTORE_0(67), FSTORE_1(68), FSTORE_2(69), FSTORE_3(70), DSTORE_0(71), DSTORE_1(72), DSTORE_2(73), DSTORE_3(74), ASTORE_0(75), ASTORE_1(76), ASTORE_2(77), ASTORE_3(78), IASTORE(79), LASTORE(80), FASTORE(81), DASTORE(82), AASTORE(83), BASTORE(84), CASTORE(85), SASTORE(86), POP(87), POP2(88), DUP(89), DUP_X1(90), DUP_X2(91), DUP2(92), DUP2_X1(93), DUP2_X2(94), SWAP(95), IADD(96), LADD(97), FADD(98), DADD(99), ISUB(100), LSUB(101), FSUB(102), DSUB(103), IMUL(104), LMUL(105), FMUL(106), DMUL(107), IDIV(108), LDIV(109), FDIV(110), DDIV(111), IREM(112), LREM(113), FREM(114), DREM(115), INEG(116), LNEG(117), FNEG(118), DNEG(119), ISHL(120), LSHL(121), ISHR(122), LSHR(123), IUSHR(124), LUSHR(125), IAND(126), LAND(127), IOR(128), LOR(129), IXOR(130), LXOR(131), IINC(132), I2L(133), I2F(134), I2D(135), L2I(136), L2F(137), L2D(138), F2I(139), F2L(140), F2D(141), D2I(142), D2L(143), D2F(144), I2B(145), INT2BYTE(145), // Old notation
    I2C(146), INT2CHAR(146), // Old notation
    I2S(147), INT2SHORT(147), // Old notation
    LCMP(148), FCMPL(149), FCMPG(150), DCMPL(151), DCMPG(152), IFEQ(153), IFNE(154), IFLT(155), IFGE(156), IFGT(157), IFLE(158), IF_ICMPEQ(159), IF_ICMPNE(160), IF_ICMPLT(161), IF_ICMPGE(162), IF_ICMPGT(163), IF_ICMPLE(164), IF_ACMPEQ(165), IF_ACMPNE(166), GOTO(167), JSR(168), RET(169), TABLESWITCH(170), LOOKUPSWITCH(171), IRETURN(172), LRETURN(173), FRETURN(174), DRETURN(175), ARETURN(176), RETURN(177), GETSTATIC(178), PUTSTATIC(179), GETFIELD(180), PUTFIELD(181), INVOKEVIRTUAL(182), INVOKESPECIAL(183), INVOKENONVIRTUAL(183), // Old name in JDK 1.0
    INVOKESTATIC(184), INVOKEINTERFACE(185), INVOKEDYNAMIC(186), NEW(187), NEWARRAY(188), ANEWARRAY(189), ARRAYLENGTH(190), ATHROW(191), CHECKCAST(192), INSTANCEOF(193), MONITORENTER(194), MONITOREXIT(195), WIDE(196), MULTIANEWARRAY(197), IFNULL(198), IFNONNULL(199), GOTO_W(200), JSR_W(201), BREAKPOINT(202), LDC_QUICK(203), LDC_W_QUICK(204), LDC2_W_QUICK(205), GETFIELD_QUICK(206), PUTFIELD_QUICK(207), GETFIELD2_QUICK(208), PUTFIELD2_QUICK(209), GETSTATIC_QUICK(210), PUTSTATIC_QUICK(211), GETSTATIC2_QUICK(212), PUTSTATIC2_QUICK(213), INVOKEVIRTUAL_QUICK(214), INVOKENONVIRTUAL_QUICK(215), INVOKESUPER_QUICK(216), INVOKESTATIC_QUICK(217), INVOKEINTERFACE_QUICK(218), INVOKEVIRTUALOBJECT_QUICK(219), NEW_QUICK(221), ANEWARRAY_QUICK(222), MULTIANEWARRAY_QUICK(223), CHECKCAST_QUICK(224), INSTANCEOF_QUICK(225), INVOKEVIRTUAL_QUICK_W(226), GETFIELD_QUICK_W(227), PUTFIELD_QUICK_W(228), IMPDEP1(254), IMPDEP2(255);
    public short UNDEFINED = -1;
    public short UNPREDICTABLE = -2;
    public short RESERVED = -3;
    public String ILLEGAL_OPCODE = "<illegal opcode>";
    public String ILLEGAL_TYPE = "<illegal type>";
    private TypeEnum[][] TYPE_OF_OPERANDS = {{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_BYTE, TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT, TypeEnum.T_BYTE, TypeEnum.T_BYTE}, {TypeEnum.T_SHORT, TypeEnum.T_BYTE, TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {}, {}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {}, {}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT, TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_INTEGER}, {TypeEnum.T_INTEGER}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
    private int[] CONSUME_STACK = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 3, 4, 3, 4, 3, 3, 3, 3, 1, 2, 1, 2, 3, 2, 3, 4, 2, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1, 2, 1, 2, 2, 3, 2, 3, 2, 3, 2, 4, 2, 4, 2, 4, 0, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 4, 2, 2, 4, 4, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 1, 1, 1, 2, 1, 2, 1, 0, 0, UNPREDICTABLE, 1, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, UNPREDICTABLE, 1, 1, 0, 0, 0, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNPREDICTABLE, UNPREDICTABLE};
    private int[] PRODUCE_STACK = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 4, 5, 6, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0, 2, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, UNPREDICTABLE, 0, UNPREDICTABLE, 0, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNPREDICTABLE, UNPREDICTABLE};

    private short[] NO_OF_OPERANDS = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, UNPREDICTABLE, UNPREDICTABLE, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 4, 4, 2, 1, 2, 0, 0, 2, 2, 0, 0, UNPREDICTABLE, 3, 2, 2, 4, 4, 0, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, RESERVED, RESERVED};
    private String[] OPCODE_NAMES = {"nop", "aconst_null", "iconst_m1", "iconst_0", "iconst_1", "iconst_2", "iconst_3", "iconst_4", "iconst_5", "lconst_0", "lconst_1", "fconst_0", "fconst_1", "fconst_2", "dconst_0", "dconst_1", "bipush", "sipush", "ldc", "ldc_w", "ldc2_w", "iload", "lload", "fload", "dload", "aload", "iload_0", "iload_1", "iload_2", "iload_3", "lload_0", "lload_1", "lload_2", "lload_3", "fload_0", "fload_1", "fload_2", "fload_3", "dload_0", "dload_1", "dload_2", "dload_3", "aload_0", "aload_1", "aload_2", "aload_3", "iaload", "laload", "faload", "daload", "aaload", "baload", "caload", "saload", "istore", "lstore", "fstore", "dstore", "astore", "istore_0", "istore_1", "istore_2", "istore_3", "lstore_0", "lstore_1", "lstore_2", "lstore_3", "fstore_0", "fstore_1", "fstore_2", "fstore_3", "dstore_0", "dstore_1", "dstore_2", "dstore_3", "astore_0", "astore_1", "astore_2", "astore_3", "iastore", "lastore", "fastore", "dastore", "aastore", "bastore", "castore", "sastore", "pop", "pop2", "dup", "dup_x1", "dup_x2", "dup2", "dup2_x1", "dup2_x2", "swap", "iadd", "ladd", "fadd", "dadd", "isub", "lsub", "fsub", "dsub", "imul", "lmul", "fmul", "dmul", "idiv", "ldiv", "fdiv", "ddiv", "irem", "lrem", "frem", "drem", "ineg", "lneg", "fneg", "dneg", "ishl", "lshl", "ishr", "lshr", "iushr", "lushr", "iand", "land", "ior", "lor", "ixor", "lxor", "iinc", "i2l", "i2f", "i2d", "l2i", "l2f", "l2d", "f2i", "f2l", "f2d", "d2i", "d2l", "d2f", "i2b", "i2c", "i2s", "lcmp", "fcmpl", "fcmpg", "dcmpl", "dcmpg", "ifeq", "ifne", "iflt", "ifge", "ifgt", "ifle", "if_icmpeq", "if_icmpne", "if_icmplt", "if_icmpge", "if_icmpgt", "if_icmple", "if_acmpeq", "if_acmpne", "goto", "jsr", "ret", "tableswitch", "lookupswitch", "ireturn", "lreturn", "freturn", "dreturn", "areturn", "return", "getstatic", "putstatic", "getfield", "putfield", "invokevirtual", "invokespecial", "invokestatic", "invokeinterface", "invokedynamic", "new", "newarray", "anewarray", "arraylength", "athrow", "checkcast", "instanceof", "monitorenter", "monitorexit", "wide", "multianewarray", "ifnull", "ifnonnull", "goto_w", "jsr_w", "breakpoint", ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, "impdep1", "impdep2"};
    //@formatter:on
    private int opcode;
    private String name;
    private short numberOfOperands;
    private int consumeStack;
    private int produceStack;
    private TypeEnum[] typeOfOperands;

    InstructionOpCodes(int tag) {
        this.opcode = tag;
        this.name = OPCODE_NAMES[tag];
        this.numberOfOperands = NO_OF_OPERANDS[tag];
        this.consumeStack = CONSUME_STACK[tag];
        this.produceStack = PRODUCE_STACK[tag];
        this.typeOfOperands = TYPE_OF_OPERANDS[tag];
    }

    public static InstructionOpCodes read(int i) {
        for (InstructionOpCodes flag : InstructionOpCodes.values()) {
            if (i == flag.getOpcode()) {
                return flag;
            }
        }
        return null;
    }

    public InstructionOpCodes add(int n) {
        return read(opcode + n);
    }

    public int getConsumeStack() {
        return consumeStack;
    }

    public String getName() {
        return name;
    }

    public short getNumberOfOperands() {
        return numberOfOperands;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getProduceStack() {
        return produceStack;
    }

    public TypeEnum[] getTypeOfOperands() {
        return typeOfOperands;
    }
}
