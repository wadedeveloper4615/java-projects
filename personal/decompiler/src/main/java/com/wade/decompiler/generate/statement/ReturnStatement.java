package com.wade.decompiler.generate.statement;

import java.io.PrintStream;

public class ReturnStatement extends Statement {
    protected String name;

    public ReturnStatement name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void print(PrintStream out) {
        if (name == null) {
            out.println(String.format("\t\treturn;"));
        } else {
            out.println(String.format("\t\treturn %s;", name));
        }
    }
}
