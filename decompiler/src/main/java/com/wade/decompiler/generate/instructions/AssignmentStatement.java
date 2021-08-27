package com.wade.decompiler.generate.instructions;

import java.io.PrintStream;

import com.wade.decompiler.generate.statement.Statement;

public class AssignmentStatement extends Statement {
    private String op1;
    private String op2;
    private String name;

    public AssignmentStatement() {
    }

    @Override
    public AssignmentStatement comment(String comment) {
        this.comment = comment;
        return this;
    }

    public AssignmentStatement name(String name) {
        this.name = name;
        return this;
    }

    public AssignmentStatement op1(String op1) {
        this.op1 = op1;
        return this;
    }

    public AssignmentStatement op2(String op2) {
        this.op2 = op2;
        return this;
    }

    @Override
    public void print(PrintStream out) {
        out.println(String.format("\t\t%s.%s = %s;", op2, name, op1));
    }
}
