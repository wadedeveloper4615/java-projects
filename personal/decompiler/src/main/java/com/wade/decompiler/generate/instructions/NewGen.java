package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.ANEWARRAY;
import com.wade.decompiler.classfile.instructions.MULTIANEWARRAY;
import com.wade.decompiler.classfile.instructions.NEW;
import com.wade.decompiler.classfile.instructions.NEWARRAY;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class NewGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class NewGen extends InstructionGen {
    /** The name. */
    private String name;
    /** The dimension. */
    private Byte dimension;

    /**
     * Instantiates a new new gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public NewGen(int offset, ANEWARRAY instr, ConstantPool cp) {
        super(offset, instr.getLength());
        this.dimension = null;
        this.setConstantPool(cp);
        this.name = cp.constantToString(instr.getIndex(), ClassFileConstants.CONSTANT_Class);
    }

    /**
     * Instantiates a new new gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public NewGen(int offset, MULTIANEWARRAY instr, ConstantPool cp) {
        super(offset, instr.getLength());
        this.dimension = instr.getDimensions();
        this.setConstantPool(cp);
        this.name = cp.constantToString(instr.getIndex(), ClassFileConstants.CONSTANT_Class);
    }

    /**
     * Instantiates a new new gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public NewGen(int offset, NEW instr, ConstantPool cp) {
        super(offset, instr.getLength());
        this.dimension = null;
        this.name = cp.constantToString(instr.getIndex(), ClassFileConstants.CONSTANT_Class);
    }

    /**
     * Instantiates a new new gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public NewGen(int offset, NEWARRAY instr, ConstantPool cp) {
        super(offset, instr.getLength());
        this.setConstantPool(cp);
        this.name = null;
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    @Override
    public Statement decompile(Stack<Statement> stack) {
//        String name = String.format("new %s()", this.name);
//        String signature = String.format("L%s;", this.name);
//        stack.push(new Expression(name, signature));
//        return "\t\t/*pushing " + name + "*/";
        return super.decompile(stack);
    }
}
