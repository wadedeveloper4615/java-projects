package com.wade.decompiler.generate.statement;

import java.io.PrintStream;

import lombok.Getter;

@Getter
public class LoadStatement extends Statement {
    private String name;
    private String signature;

    public LoadStatement() {
    }

    @Override
    public LoadStatement comment(String comment) {
        this.comment = comment;
        return this;
    }

    public LoadStatement name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void print(PrintStream out) {
        out.println("\t\t/*" + comment + "*/");
    }

    public LoadStatement signature(String signature) {
        this.signature = signature;
        return this;
    }
}
