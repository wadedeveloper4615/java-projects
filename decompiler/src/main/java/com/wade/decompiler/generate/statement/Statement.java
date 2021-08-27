package com.wade.decompiler.generate.statement;

import java.io.PrintStream;

import lombok.Getter;

@Getter
public class Statement {
    protected String comment;

    public Statement comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void print(PrintStream out) {
        out.println("\t\t/*" + comment + "*/");
    }
}
