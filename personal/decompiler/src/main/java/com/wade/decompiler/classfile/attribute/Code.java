/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.classfile.instructions.base.InstructionList;
import com.wade.decompiler.enums.ClassFileAttributes;
import com.wade.decompiler.util.ByteArray;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class Code.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Code extends Attribute {

    /** The instructions. */
    @ToString.Exclude
    private List<Instruction> instructions;

    /** The byte code. */
    @ToString.Exclude
    private ByteArray byteCode;

    /** The local variable table. */
    @ToString.Exclude
    private LocalVariableTable localVariableTable;

    /** The line number table. */
    @ToString.Exclude
    private LineNumberTable lineNumberTable;

    /** The max stack. */
    private Integer maxStack;

    /** The max locals. */
    private Integer maxLocals;

    /** The exception table. */
    @ToString.Exclude
    private List<CodeException> exceptionTable;

    /** The attributes. */
    @ToString.Exclude
    private List<Attribute> attributes;

    /**
     * Instantiates a new code.
     *
     * @param nameIndex    the name index
     * @param length       the length
     * @param file         the file
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Code(int nameIndex, int length, DataInput file, ConstantPool constantPool, Boolean isInnerClass) throws IOException {
        this(nameIndex, length, file.readUnsignedShort(), file.readUnsignedShort(), new ByteArray(), (List<CodeException>) null, (List<Attribute>) null);
        int codeLength = file.readInt();
        byteCode.readFully(file, codeLength);
        int exception_table_length = file.readUnsignedShort();
        exceptionTable = new ArrayList<>();
        for (int i = 0; i < exception_table_length; i++) {
            exceptionTable.add(new CodeException(file));
        }
        int attributesCount = file.readUnsignedShort();
        attributes = new ArrayList<>();
        for (int i = 0; i < attributesCount; i++) {
            Attribute attribute = Attribute.readAttribute(file, constantPool, isInnerClass);
            attributes.add(attribute);
            if (attribute instanceof LineNumberTable) {
                lineNumberTable = (LineNumberTable) attribute;
            }
            if (attribute instanceof LocalVariableTable) {
                localVariableTable = (LocalVariableTable) attribute;
            }
        }
        super.length = length;
        // System.out.println("Start : "+value.getAttributes().size());
        this.instructions = new InstructionList(byteCode, constantPool).getInstructions();
        // System.out.println("Start : " + name + " End");
    }

    /**
     * Instantiates a new code.
     *
     * @param nameIndex      the name index
     * @param length         the length
     * @param maxStack       the max stack
     * @param maxLocals      the max locals
     * @param code           the code
     * @param exceptionTable the exception table
     * @param attributes     the attributes
     */
    public Code(int nameIndex, int length, int maxStack, int maxLocals, ByteArray code, List<CodeException> exceptionTable, List<Attribute> attributes) {
        super(ClassFileAttributes.ATTR_CODE, nameIndex, length);
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.byteCode = code;
        this.exceptionTable = exceptionTable;
        this.attributes = attributes;
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
        for (Attribute ag : getAttributes()) {
            ag.printUsefulData(out);
        }
        for (Instruction instr : this.instructions) {
            instr.printUsefulData(out);
        }
    }
}
