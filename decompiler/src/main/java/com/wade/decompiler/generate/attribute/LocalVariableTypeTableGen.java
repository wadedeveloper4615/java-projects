package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.wade.decompiler.classfile.attribute.LocalVariable;
import com.wade.decompiler.classfile.attribute.LocalVariableTypeTable;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LocalVariableTypeTableGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class LocalVariableTypeTableGen extends AttributeGen {
    /** The local variable type table. */
    private Map<Integer, LocalVariableGen> localVariableTypeTable;

    /**
     * Instantiates a new local variable type table gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public LocalVariableTypeTableGen(LocalVariableTypeTable attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.localVariableTypeTable = new HashMap<>();
        Map<Integer, LocalVariable> map = attribute.getLocalVariableTypeTable();
        map.keySet().stream().forEach(entry -> localVariableTypeTable.put(entry, new LocalVariableGen(map.get(entry), constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("Local Variable Type Table");
        for (Integer index : getLocalVariableTypeTable().keySet()) {
            out.println(getLocalVariableTypeTable().get(index).toString());
        }
    }
}
