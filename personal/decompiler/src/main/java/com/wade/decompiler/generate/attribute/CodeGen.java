package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import com.wade.decompiler.classfile.attribute.Code;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.generate.instructions.CompareGen;
import com.wade.decompiler.generate.instructions.InstructionGen;
import com.wade.decompiler.generate.instructions.InstructionInfoExtract;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class CodeGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class CodeGen extends AttributeGen {
    /** The max stack. */
    private Integer maxStack;
    /** The max locals. */
    private Integer maxLocals;
    /** The code size. */
    private Long codeSize;
    /** The attributes. */
    private List<AttributeGen> attributes;
    /** The code exception. */
    private List<CodeExceptionGen> codeException;
    /** The instruction extracted. */
    private InstructionInfoExtract instructionExtracted;
    private LocalVariableTableGen localVariableTable;
    private LineNumberTableGen lineNumberTable;
    private LocalVariableTypeTableGen localVariableTypeTable;

    /**
     * Instantiates a new code gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     */
    public CodeGen(Code attribute, ConstantPool constantPool, Boolean isInnerClass) {
        super(attribute, constantPool);
        this.maxStack = attribute.getMaxStack();
        this.maxLocals = attribute.getMaxLocals();
        this.codeSize = attribute.getByteCode().getArrayLength();
        this.attributes = new ArrayList<>();
        attribute.getAttributes().stream().forEach(entry -> this.attributes.add(AttributeGen.readAttribute(entry, constantPool, isInnerClass)));
        this.codeException = new ArrayList<>();
        attribute.getExceptionTable().stream().forEach(entry -> this.codeException.add(new CodeExceptionGen(entry, constantPool)));
        for (AttributeGen ag : attributes) {
            if (ag instanceof LocalVariableTableGen) {
                localVariableTable = (LocalVariableTableGen) ag;
            }
            if (ag instanceof LocalVariableTypeTableGen) {
                localVariableTypeTable = (LocalVariableTypeTableGen) ag;
            }
            if (ag instanceof LineNumberTableGen) {
                lineNumberTable = (LineNumberTableGen) ag;
            }
        }
        this.instructionExtracted = new InstructionInfoExtract(attribute.getInstructions(), localVariableTable, localVariableTypeTable, constantPool);
    }

    @Override
    public void decompile(PrintStream out) {
        out.println("\t\t/*");
        for (InstructionGen ig : instructionExtracted.getInstructionsExtracted()) {
            out.println("\t\t" + ig.toString());
        }
        out.println("\t\t*/");
        Stack<Statement> stack = new Stack<>();
        List<Statement> results = new ArrayList<>();
        Consumer<? super InstructionGen> action = ig -> {
            Statement statement = ig.decompile(stack);
            if (statement != null) {
                results.add(statement);
            }
        };
        instructionExtracted.getInstructionsExtracted().stream().forEach(action);
        results.stream().forEach(s -> s.print(out));
    }

    @Override
    public void printUsefulData(PrintStream out) {
        for (AttributeGen ag : getAttributes()) {
            ag.printUsefulData(out);
        }
        out.println("Instructions");
        for (InstructionGen ag : instructionExtracted.getInstructionsExtracted()) {
            out.println("   " + ag.toString());
            if (ag instanceof CompareGen) {
                for (InstructionGen ag1 : ((CompareGen) ag).getThenBlock()) {
                    out.println("      " + ag1.toString());
                }
            }
        }
    }
}
