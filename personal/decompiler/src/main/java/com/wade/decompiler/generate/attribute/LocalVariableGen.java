package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.LocalVariable;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.LocalVariableType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LocalVariableGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class LocalVariableGen {
    /** The start. */
    private Integer start;
    /** The length. */
    private Integer length;
    /** The slot. */
    private Integer slot;
    /** The name. */
    private String name;
    /** The signature. */
    private String signature;
    /** The type. */
    private LocalVariableType type;

    /**
     * Instantiates a new local variable gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public LocalVariableGen(LocalVariable attribute, ConstantPool constantPool) {
        if (attribute != null) {
            this.start = attribute.getStart();
            this.length = attribute.getLength();
            this.slot = attribute.getSlot();
            this.name = ((ConstantUtf8) constantPool.getConstant(attribute.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            this.signature = ((ConstantUtf8) constantPool.getConstant(attribute.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            if (start == 0 && !name.equals("this")) {
                type = LocalVariableType.PARAMETER;
            } else if (start == 0 && name.equals("this")) {
                type = LocalVariableType.THIS;
            } else {
                type = LocalVariableType.LOCAL;
            }
        } else {
            // throw new ClassGenException("missing local variable data");
        }
    }
}
