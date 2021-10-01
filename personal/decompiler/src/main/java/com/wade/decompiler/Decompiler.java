/*
 *
 */
package com.wade.decompiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import com.wade.decompiler.classfile.ClassParser;
import com.wade.decompiler.classfile.JavaClass;
import com.wade.decompiler.generate.JavaClassGen;

/**
 * The Class Decompiler.
 */
public class Decompiler {
    /**
     * The main method.
     *
     * @param argv the arguments
     */
    public static void main(String[] argv) {
        try {
            Class<Decompiler> c = Decompiler.class;
            Decompiler decompiler = new Decompiler();
            String resource = "/com/wade/decompiler/test/SimpleClassWithFields.class";
            JavaClass javaClass = decompiler.process(c, resource, false);
            decompiler.decompile(javaClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Decompile.
     *
     * @param jc the jc
     */
    private void decompile(JavaClass jc) {
        PrintStream out = System.out;
        jc.toUsefulString(out);
        JavaClassGen jg = new JavaClassGen(jc, false);
        jg.toUsefulString(out);
        jg.decompile(out);
    }

    /**
     * Process.
     *
     * @param parent       the parent
     * @param resource     the resource
     * @param isInnerClass the is inner class
     * @return the java class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private JavaClass process(Class<Decompiler> parent, String resource, Boolean isInnerClass) throws IOException {
        InputStream rs = parent.getResourceAsStream(resource);
        return new ClassParser(rs, resource).parse(isInnerClass);
    }
}
