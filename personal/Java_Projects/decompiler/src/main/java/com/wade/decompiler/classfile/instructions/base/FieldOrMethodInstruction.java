package com.wade.decompiler.classfile.instructions.base;

import com.wade.decompiler.classfile.constant.ConstantCP;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.exceptions.ClassGenException;
import com.wade.decompiler.classfile.instructions.type.ArrayType;
import com.wade.decompiler.classfile.instructions.type.ObjectType;
import com.wade.decompiler.classfile.instructions.type.ReferenceType;
import com.wade.decompiler.classfile.instructions.type.Type;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public abstract class FieldOrMethodInstruction extends CPInstruction {
    protected FieldOrMethodInstruction(InstructionOpCodes opcode, ConstantPool cp, int index) {
        super(opcode, cp, index);
    }

    public ObjectType getLoadClassType() {
        final ReferenceType rt = getReferenceType(this.constantPool);
        if (rt instanceof ObjectType) {
            return (ObjectType) rt;
        }
        throw new ClassGenException(rt.getClass().getCanonicalName() + " " + rt.getSignature() + " does not represent an ObjectType");
    }

    public ReferenceType getReferenceType(ConstantPool cp) {
        final ConstantCP cmr = (ConstantCP) cp.getConstant(super.getIndex());
        String className = cp.constantToString(cmr.getClassIndex(), ClassFileConstants.CONSTANT_Class);
        if (className.startsWith("[")) {
            return (ArrayType) Type.getType(className);
        }
        className = className.replace('/', '.');
        return new ObjectType(className);
    }
}
