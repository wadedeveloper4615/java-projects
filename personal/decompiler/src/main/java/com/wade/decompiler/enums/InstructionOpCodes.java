package com.wade.decompiler.enums;

/**
 * The Enum InstructionOpCodes.
 */
public enum InstructionOpCodes {
    /** The nop. */
    //@formatter:off
    NOP(0),
 /** The aconst null. */
 ACONST_NULL(1),
 /** The iconst m1. */
 ICONST_M1(2),
 /** The iconst 0. */
 ICONST_0(3),
 /** The iconst 1. */
 ICONST_1(4),
 /** The iconst 2. */
 ICONST_2(5),
 /** The iconst 3. */
 ICONST_3(6),
 /** The iconst 4. */
 ICONST_4(7),
 /** The iconst 5. */
 ICONST_5(8),
 /** The lconst 0. */
 LCONST_0(9),
 /** The lconst 1. */
 LCONST_1(10),
 /** The fconst 0. */
 FCONST_0(11),
 /** The fconst 1. */
 FCONST_1(12),
 /** The fconst 2. */
 FCONST_2(13),
 /** The dconst 0. */
 DCONST_0(14),
 /** The dconst 1. */
 DCONST_1(15),
 /** The bipush. */
 BIPUSH(16),
 /** The sipush. */
 SIPUSH(17),
 /** The ldc. */
 LDC(18),
 /** The ldc w. */
 LDC_W(19),
 /** The ldc2 w. */
 LDC2_W(20),
 /** The iload. */
 ILOAD(21),
 /** The lload. */
 LLOAD(22),
 /** The fload. */
 FLOAD(23),
 /** The dload. */
 DLOAD(24),
 /** The aload. */
 ALOAD(25),
 /** The iload 0. */
 ILOAD_0(26),
 /** The iload 1. */
 ILOAD_1(27),
 /** The iload 2. */
 ILOAD_2(28),
 /** The iload 3. */
 ILOAD_3(29),
 /** The lload 0. */
 LLOAD_0(30),
 /** The lload 1. */
 LLOAD_1(31),
 /** The lload 2. */
 LLOAD_2(32),
 /** The lload 3. */
 LLOAD_3(33),
 /** The fload 0. */
 FLOAD_0(34),
 /** The fload 1. */
 FLOAD_1(35),
 /** The fload 2. */
 FLOAD_2(36),
 /** The fload 3. */
 FLOAD_3(37),
 /** The dload 0. */
 DLOAD_0(38),
 /** The dload 1. */
 DLOAD_1(39),
 /** The dload 2. */
 DLOAD_2(40),
 /** The dload 3. */
 DLOAD_3(41),
 /** The aload 0. */
 ALOAD_0(42),
 /** The aload 1. */
 ALOAD_1(43),
 /** The aload 2. */
 ALOAD_2(44),
 /** The aload 3. */
 ALOAD_3(45),
 /** The iaload. */
 IALOAD(46),
 /** The laload. */
 LALOAD(47),
 /** The faload. */
 FALOAD(48),
 /** The daload. */
 DALOAD(49),
 /** The aaload. */
 AALOAD(50),
 /** The baload. */
 BALOAD(51),
 /** The caload. */
 CALOAD(52),
 /** The saload. */
 SALOAD(53),
 /** The istore. */
 ISTORE(54),
 /** The lstore. */
 LSTORE(55),
 /** The fstore. */
 FSTORE(56),
 /** The dstore. */
 DSTORE(57),
 /** The astore. */
 ASTORE(58),
 /** The istore 0. */
 ISTORE_0(59),
 /** The istore 1. */
 ISTORE_1(60),
 /** The istore 2. */
 ISTORE_2(61),
 /** The istore 3. */
 ISTORE_3(62),
 /** The lstore 0. */
 LSTORE_0(63),
 /** The lstore 1. */
 LSTORE_1(64),
 /** The lstore 2. */
 LSTORE_2(65),
 /** The lstore 3. */
 LSTORE_3(66),
 /** The fstore 0. */
 FSTORE_0(67),
 /** The fstore 1. */
 FSTORE_1(68),
 /** The fstore 2. */
 FSTORE_2(69),
 /** The fstore 3. */
 FSTORE_3(70),
 /** The dstore 0. */
 DSTORE_0(71),
 /** The dstore 1. */
 DSTORE_1(72),
 /** The dstore 2. */
 DSTORE_2(73),
 /** The dstore 3. */
 DSTORE_3(74),
 /** The astore 0. */
 ASTORE_0(75),
 /** The astore 1. */
 ASTORE_1(76),
 /** The astore 2. */
 ASTORE_2(77),
 /** The astore 3. */
 ASTORE_3(78),
 /** The iastore. */
 IASTORE(79),
 /** The lastore. */
 LASTORE(80),
 /** The fastore. */
 FASTORE(81),
 /** The dastore. */
 DASTORE(82),
 /** The aastore. */
 AASTORE(83),
 /** The bastore. */
 BASTORE(84),
 /** The castore. */
 CASTORE(85),
 /** The sastore. */
 SASTORE(86),
 /** The pop. */
 POP(87),
 /** The pop2. */
 POP2(88),
 /** The dup. */
 DUP(89),
 /** The dup x1. */
 DUP_X1(90),
 /** The dup x2. */
 DUP_X2(91),
 /** The dup2. */
 DUP2(92),
 /** The dup2 x1. */
 DUP2_X1(93),
 /** The dup2 x2. */
 DUP2_X2(94),
 /** The swap. */
 SWAP(95),
 /** The iadd. */
 IADD(96),
 /** The ladd. */
 LADD(97),
 /** The fadd. */
 FADD(98),
 /** The dadd. */
 DADD(99),
 /** The isub. */
 ISUB(100),
 /** The lsub. */
 LSUB(101),
 /** The fsub. */
 FSUB(102),
 /** The dsub. */
 DSUB(103),
 /** The imul. */
 IMUL(104),
 /** The lmul. */
 LMUL(105),
 /** The fmul. */
 FMUL(106),
 /** The dmul. */
 DMUL(107),
 /** The idiv. */
 IDIV(108),
 /** The ldiv. */
 LDIV(109),
 /** The fdiv. */
 FDIV(110),
 /** The ddiv. */
 DDIV(111),
 /** The irem. */
 IREM(112),
 /** The lrem. */
 LREM(113),
 /** The frem. */
 FREM(114),
 /** The drem. */
 DREM(115),
 /** The ineg. */
 INEG(116),
 /** The lneg. */
 LNEG(117),
 /** The fneg. */
 FNEG(118),
 /** The dneg. */
 DNEG(119),
 /** The ishl. */
 ISHL(120),
 /** The lshl. */
 LSHL(121),
 /** The ishr. */
 ISHR(122),
 /** The lshr. */
 LSHR(123),
 /** The iushr. */
 IUSHR(124),
 /** The lushr. */
 LUSHR(125),
 /** The iand. */
 IAND(126),
 /** The land. */
 LAND(127),
 /** The ior. */
 IOR(128),
 /** The lor. */
 LOR(129),
 /** The ixor. */
 IXOR(130),
 /** The lxor. */
 LXOR(131),
 /** The iinc. */
 IINC(132),
 /** The i2l. */
 I2L(133),
 /** The i2f. */
 I2F(134),
 /** The i2d. */
 I2D(135),
 /** The l2i. */
 L2I(136),
 /** The l2f. */
 L2F(137),
 /** The l2d. */
 L2D(138),
 /** The f2i. */
 F2I(139),
 /** The f2l. */
 F2L(140),
 /** The f2d. */
 F2D(141),
 /** The d2i. */
 D2I(142),
 /** The d2l. */
 D2L(143),
 /** The d2f. */
 D2F(144),
 /** The i2b. */
 I2B(145),
 /** The int2byte. */
 INT2BYTE(145),
 /** The i2c. */
 // Old notation
    I2C(146),
 /** The int2char. */
 INT2CHAR(146),
 /** The i2s. */
 // Old notation
    I2S(147),
 /** The int2short. */
 INT2SHORT(147),
 /** The lcmp. */
 // Old notation
    LCMP(148),
 /** The fcmpl. */
 FCMPL(149),
 /** The fcmpg. */
 FCMPG(150),
 /** The dcmpl. */
 DCMPL(151),
 /** The dcmpg. */
 DCMPG(152),
 /** The ifeq. */
 IFEQ(153),
 /** The ifne. */
 IFNE(154),
 /** The iflt. */
 IFLT(155),
 /** The ifge. */
 IFGE(156),
 /** The ifgt. */
 IFGT(157),
 /** The ifle. */
 IFLE(158),
 /** The if icmpeq. */
 IF_ICMPEQ(159),
 /** The if icmpne. */
 IF_ICMPNE(160),
 /** The if icmplt. */
 IF_ICMPLT(161),
 /** The if icmpge. */
 IF_ICMPGE(162),
 /** The if icmpgt. */
 IF_ICMPGT(163),
 /** The if icmple. */
 IF_ICMPLE(164),
 /** The if acmpeq. */
 IF_ACMPEQ(165),
 /** The if acmpne. */
 IF_ACMPNE(166),
 /** The goto. */
 GOTO(167),
 /** The jsr. */
 JSR(168),
 /** The ret. */
 RET(169),
 /** The tableswitch. */
 TABLESWITCH(170),
 /** The lookupswitch. */
 LOOKUPSWITCH(171),
 /** The ireturn. */
 IRETURN(172),
 /** The lreturn. */
 LRETURN(173),
 /** The freturn. */
 FRETURN(174),
 /** The dreturn. */
 DRETURN(175),
 /** The areturn. */
 ARETURN(176),
 /** The return. */
 RETURN(177),
 /** The getstatic. */
 GETSTATIC(178),
 /** The putstatic. */
 PUTSTATIC(179),
 /** The getfield. */
 GETFIELD(180),
 /** The putfield. */
 PUTFIELD(181),
 /** The invokevirtual. */
 INVOKEVIRTUAL(182),
 /** The invokespecial. */
 INVOKESPECIAL(183),
 /** The invokenonvirtual. */
 INVOKENONVIRTUAL(183),
 /** The invokestatic. */
 // Old name in JDK 1.0
    INVOKESTATIC(184),
 /** The invokeinterface. */
 INVOKEINTERFACE(185),
 /** The invokedynamic. */
 INVOKEDYNAMIC(186),
 /** The new. */
 NEW(187),
 /** The newarray. */
 NEWARRAY(188),
 /** The anewarray. */
 ANEWARRAY(189),
 /** The arraylength. */
 ARRAYLENGTH(190),
 /** The athrow. */
 ATHROW(191),
 /** The checkcast. */
 CHECKCAST(192),
 /** The instanceof. */
 INSTANCEOF(193),
 /** The monitorenter. */
 MONITORENTER(194),
 /** The monitorexit. */
 MONITOREXIT(195),
 /** The wide. */
 WIDE(196),
 /** The multianewarray. */
 MULTIANEWARRAY(197),
 /** The ifnull. */
 IFNULL(198),
 /** The ifnonnull. */
 IFNONNULL(199),
 /** The goto w. */
 GOTO_W(200),
 /** The jsr w. */
 JSR_W(201),
 /** The breakpoint. */
 BREAKPOINT(202),
 /** The ldc quick. */
 LDC_QUICK(203),
 /** The ldc w quick. */
 LDC_W_QUICK(204),
 /** The ldc2 w quick. */
 LDC2_W_QUICK(205),
 /** The getfield quick. */
 GETFIELD_QUICK(206),
 /** The putfield quick. */
 PUTFIELD_QUICK(207),
 /** The getfield2 quick. */
 GETFIELD2_QUICK(208),
 /** The putfield2 quick. */
 PUTFIELD2_QUICK(209),
 /** The getstatic quick. */
 GETSTATIC_QUICK(210),
 /** The putstatic quick. */
 PUTSTATIC_QUICK(211),
 /** The getstatic2 quick. */
 GETSTATIC2_QUICK(212),
 /** The putstatic2 quick. */
 PUTSTATIC2_QUICK(213),
 /** The invokevirtual quick. */
 INVOKEVIRTUAL_QUICK(214),
 /** The invokenonvirtual quick. */
 INVOKENONVIRTUAL_QUICK(215),
 /** The invokesuper quick. */
 INVOKESUPER_QUICK(216),
 /** The invokestatic quick. */
 INVOKESTATIC_QUICK(217),
 /** The invokeinterface quick. */
 INVOKEINTERFACE_QUICK(218),
 /** The invokevirtualobject quick. */
 INVOKEVIRTUALOBJECT_QUICK(219),
 /** The new quick. */
 NEW_QUICK(221),
 /** The anewarray quick. */
 ANEWARRAY_QUICK(222),
 /** The multianewarray quick. */
 MULTIANEWARRAY_QUICK(223),
 /** The checkcast quick. */
 CHECKCAST_QUICK(224),
 /** The instanceof quick. */
 INSTANCEOF_QUICK(225),
 /** The invokevirtual quick w. */
 INVOKEVIRTUAL_QUICK_W(226),
 /** The getfield quick w. */
 GETFIELD_QUICK_W(227),
 /** The putfield quick w. */
 PUTFIELD_QUICK_W(228),
 /** The impdep1. */
 IMPDEP1(254),
 /** The impdep2. */
 IMPDEP2(255);

    /**
     * Read.
     *
     * @param i the i
     * @return the instruction op codes
     */
    public static InstructionOpCodes read(int i) {
	for (InstructionOpCodes flag : InstructionOpCodes.values()) {
	    if (i == flag.getOpcode()) {
		return flag;
	    }
	}
	return null;
    }

    /** The undefined. */
    public short UNDEFINED = -1;

    /** The unpredictable. */
    public short UNPREDICTABLE = -2;

    /** The reserved. */
    public short RESERVED = -3;

    /** The illegal opcode. */
    public String ILLEGAL_OPCODE = "<illegal opcode>";

    /** The illegal type. */
    public String ILLEGAL_TYPE = "<illegal type>";

    /** The type of operands. */
    private TypeEnum[][] TYPE_OF_OPERANDS = {{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_BYTE, TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {}, {}, {}, {}, {}, {}, {}, {}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT, TypeEnum.T_BYTE, TypeEnum.T_BYTE}, {TypeEnum.T_SHORT, TypeEnum.T_BYTE, TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {}, {}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {}, {}, {TypeEnum.T_BYTE}, {TypeEnum.T_SHORT, TypeEnum.T_BYTE}, {TypeEnum.T_SHORT}, {TypeEnum.T_SHORT}, {TypeEnum.T_INTEGER}, {TypeEnum.T_INTEGER}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    /** The consume stack. */
    private int[] CONSUME_STACK = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 3, 4, 3, 4, 3, 3, 3, 3, 1, 2, 1, 2, 3, 2, 3, 4, 2, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1, 2, 1, 2, 2, 3, 2, 3, 2, 3, 2, 4, 2, 4, 2, 4, 0, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 4, 2, 2, 4, 4, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 1, 1, 1, 2, 1, 2, 1, 0, 0, UNPREDICTABLE, 1, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, UNPREDICTABLE, 1, 1, 0, 0, 0, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNPREDICTABLE, UNPREDICTABLE};

    /** The produce stack. */
    private int[] PRODUCE_STACK = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 4, 5, 6, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0, 2, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, UNPREDICTABLE, 0, UNPREDICTABLE, 0, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNPREDICTABLE, UNPREDICTABLE};

    /** The no of operands. */
    private short[] NO_OF_OPERANDS = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, UNPREDICTABLE, UNPREDICTABLE, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 4, 4, 2, 1, 2, 0, 0, 2, 2, 0, 0, UNPREDICTABLE, 3, 2, 2, 4, 4, 0, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, RESERVED, RESERVED};

    /** The opcode names. */
    private String[] OPCODE_NAMES = {"nop", "aconst_null", "iconst_m1", "iconst_0", "iconst_1", "iconst_2", "iconst_3", "iconst_4", "iconst_5", "lconst_0", "lconst_1", "fconst_0", "fconst_1", "fconst_2", "dconst_0", "dconst_1", "bipush", "sipush", "ldc", "ldc_w", "ldc2_w", "iload", "lload", "fload", "dload", "aload", "iload_0", "iload_1", "iload_2", "iload_3", "lload_0", "lload_1", "lload_2", "lload_3", "fload_0", "fload_1", "fload_2", "fload_3", "dload_0", "dload_1", "dload_2", "dload_3", "aload_0", "aload_1", "aload_2", "aload_3", "iaload", "laload", "faload", "daload", "aaload", "baload", "caload", "saload", "istore", "lstore", "fstore", "dstore", "astore", "istore_0", "istore_1", "istore_2", "istore_3", "lstore_0", "lstore_1", "lstore_2", "lstore_3", "fstore_0", "fstore_1", "fstore_2", "fstore_3", "dstore_0", "dstore_1", "dstore_2", "dstore_3", "astore_0", "astore_1", "astore_2", "astore_3", "iastore", "lastore", "fastore", "dastore", "aastore", "bastore", "castore", "sastore", "pop", "pop2", "dup", "dup_x1", "dup_x2", "dup2", "dup2_x1", "dup2_x2", "swap", "iadd", "ladd", "fadd", "dadd", "isub", "lsub", "fsub", "dsub", "imul", "lmul", "fmul", "dmul", "idiv", "ldiv", "fdiv", "ddiv", "irem", "lrem", "frem", "drem", "ineg", "lneg", "fneg", "dneg", "ishl", "lshl", "ishr", "lshr", "iushr", "lushr", "iand", "land", "ior", "lor", "ixor", "lxor", "iinc", "i2l", "i2f", "i2d", "l2i", "l2f", "l2d", "f2i", "f2l", "f2d", "d2i", "d2l", "d2f", "i2b", "i2c", "i2s", "lcmp", "fcmpl", "fcmpg", "dcmpl", "dcmpg", "ifeq", "ifne", "iflt", "ifge", "ifgt", "ifle", "if_icmpeq", "if_icmpne", "if_icmplt", "if_icmpge", "if_icmpgt", "if_icmple", "if_acmpeq", "if_acmpne", "goto", "jsr", "ret", "tableswitch", "lookupswitch", "ireturn", "lreturn", "freturn", "dreturn", "areturn", "return", "getstatic", "putstatic", "getfield", "putfield", "invokevirtual", "invokespecial", "invokestatic", "invokeinterface", "invokedynamic", "new", "newarray", "anewarray", "arraylength", "athrow", "checkcast", "instanceof", "monitorenter", "monitorexit", "wide", "multianewarray", "ifnull", "ifnonnull", "goto_w", "jsr_w", "breakpoint", ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, "impdep1", "impdep2"};
    /** The opcode. */
    //@formatter:on
    private int opcode;
    /** The name. */
    private String name;
    /** The number of operands. */
    private short numberOfOperands;
    /** The consume stack. */
    private int consumeStack;
    /** The produce stack. */
    private int produceStack;

    /** The type of operands. */
    private TypeEnum[] typeOfOperands;

    /**
     * Instantiates a new instruction op codes.
     *
     * @param tag the tag
     */
    InstructionOpCodes(int tag) {
        this.opcode = tag;
        this.name = OPCODE_NAMES[tag];
        this.numberOfOperands = NO_OF_OPERANDS[tag];
        this.consumeStack = CONSUME_STACK[tag];
        this.produceStack = PRODUCE_STACK[tag];
        this.typeOfOperands = TYPE_OF_OPERANDS[tag];
    }

    /**
     * Adds the.
     *
     * @param n the n
     * @return the instruction op codes
     */
    public InstructionOpCodes add(int n) {
        return read(opcode + n);
    }

    /**
     * Gets the consume stack.
     *
     * @return the consume stack
     */
    public int getConsumeStack() {
        return consumeStack;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of operands.
     *
     * @return the number of operands
     */
    public short getNumberOfOperands() {
        return numberOfOperands;
    }

    /**
     * Gets the opcode.
     *
     * @return the opcode
     */
    public int getOpcode() {
        return opcode;
    }

    /**
     * Gets the produce stack.
     *
     * @return the produce stack
     */
    public int getProduceStack() {
        return produceStack;
    }

    /**
     * Gets the type of operands.
     *
     * @return the type of operands
     */
    public TypeEnum[] getTypeOfOperands() {
        return typeOfOperands;
    }
}
