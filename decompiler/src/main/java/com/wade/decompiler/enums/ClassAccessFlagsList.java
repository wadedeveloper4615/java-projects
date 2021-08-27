package com.wade.decompiler.enums;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ClassAccessFlagsList.
 */
public class ClassAccessFlagsList {
    /** The flags. */
    private int flags;
    /** The flags list. */
    private List<ClassAccessFlags> flagsList;

    /**
     * Instantiates a new class access flags list.
     */
    public ClassAccessFlagsList() {
        flagsList = new ArrayList<>();
    }

    /**
     * Instantiates a new class access flags list.
     *
     * @param dataInputStream the data input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ClassAccessFlagsList(DataInput dataInputStream) throws IOException {
        this.flags = dataInputStream.readUnsignedShort();
        this.flagsList = ClassAccessFlags.readList(flags);
    }

    /**
     * Instantiates a new class access flags list.
     *
     * @param flags the flags
     */
    public ClassAccessFlagsList(int flags) {
        this.flags = flags;
        this.flagsList = ClassAccessFlags.readList(flags);
    }

    /**
     * Adds the flag.
     *
     * @param flag the flag
     */
    public void addFlag(ClassAccessFlags flag) {
        flagsList.add(flag);
        this.setFlags();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ClassAccessFlagsList other = (ClassAccessFlagsList) obj;
        if (flags != other.flags) {
            return false;
        }
        if (flagsList == null) {
            if (other.flagsList != null) {
                return false;
            }
        } else if (!flagsList.equals(other.flagsList)) {
            return false;
        }
        return true;
    }

    /**
     * Gets the flags.
     *
     * @return the flags
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Gets the flags list.
     *
     * @return the flags list
     */
    public List<ClassAccessFlags> getFlagsList() {
        return flagsList;
    }

    /**
     * Checks for flag.
     *
     * @param flags the flags
     * @return true, if successful
     */
    public boolean hasFlag(ClassAccessFlags flags) {
        return (this.flags & flags.getFlag()) != 0;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + flags;
        result = prime * result + ((flagsList == null) ? 0 : flagsList.hashCode());
        return result;
    }

    /**
     * Checks if is abstract.
     *
     * @return true, if is abstract
     */
    public boolean isAbstract() {
        return hasFlag(ClassAccessFlags.ACC_ABSTRACT);
    }

    /**
     * Checks if is annotation.
     *
     * @return true, if is annotation
     */
    public boolean isAnnotation() {
        return hasFlag(ClassAccessFlags.ACC_ANNOTATION);
    }

    /**
     * Checks if is enum.
     *
     * @return true, if is enum
     */
    public boolean isEnum() {
        return hasFlag(ClassAccessFlags.ACC_ENUM);
    }

    /**
     * Checks if is final.
     *
     * @return true, if is final
     */
    public boolean isFinal() {
        return hasFlag(ClassAccessFlags.ACC_FINAL);
    }

    /**
     * Checks if is final and abstract.
     *
     * @return true, if is final and abstract
     */
    public boolean isFinalAndAbstract() {
        return hasFlag(ClassAccessFlags.ACC_FINAL) && hasFlag(ClassAccessFlags.ACC_ABSTRACT);
    }

    /**
     * Checks if is interface.
     *
     * @return true, if is interface
     */
    public boolean isInterface() {
        return hasFlag(ClassAccessFlags.ACC_INTERFACE);
    }

    /**
     * Checks if is mandated.
     *
     * @return true, if is mandated
     */
    public boolean isMandated() {
        return hasFlag(ClassAccessFlags.ACC_MANDATED);
    }

    /**
     * Checks if is native.
     *
     * @return true, if is native
     */
    public boolean isNative() {
        return hasFlag(ClassAccessFlags.ACC_NATIVE);
    }

    /**
     * Checks if is private.
     *
     * @return true, if is private
     */
    public boolean isPrivate() {
        return hasFlag(ClassAccessFlags.ACC_PRIVATE);
    }

    /**
     * Checks if is protected.
     *
     * @return true, if is protected
     */
    public boolean isProtected() {
        return hasFlag(ClassAccessFlags.ACC_PROTECTED);
    }

    /**
     * Checks if is public.
     *
     * @return true, if is public
     */
    public boolean isPublic() {
        return hasFlag(ClassAccessFlags.ACC_PUBLIC);
    }

    /**
     * Checks if is static.
     *
     * @return true, if is static
     */
    public boolean isStatic() {
        return hasFlag(ClassAccessFlags.ACC_STATIC);
    }

    /**
     * Checks if is strictfp.
     *
     * @return true, if is strictfp
     */
    public boolean isStrictfp() {
        return hasFlag(ClassAccessFlags.ACC_STRICT);
    }

    /**
     * Checks if is super.
     *
     * @return true, if is super
     */
    public boolean isSuper() {
        return hasFlag(ClassAccessFlags.ACC_SUPER);
    }

    /**
     * Checks if is synchronized.
     *
     * @return true, if is synchronized
     */
    public boolean isSynchronized() {
        return hasFlag(ClassAccessFlags.ACC_SYNCHRONIZED);
    }

    /**
     * Checks if is synthetic.
     *
     * @return true, if is synthetic
     */
    public boolean isSynthetic() {
        return hasFlag(ClassAccessFlags.ACC_SYNTHETIC);
    }

    /**
     * Checks if is transient.
     *
     * @return true, if is transient
     */
    public boolean isTransient() {
        return hasFlag(ClassAccessFlags.ACC_TRANSIENT);
    }

    /**
     * Checks if is var args.
     *
     * @return true, if is var args
     */
    public boolean isVarArgs() {
        return hasFlag(ClassAccessFlags.ACC_VARARGS);
    }

    /**
     * Checks if is volatile.
     *
     * @return true, if is volatile
     */
    public boolean isVolatile() {
        return hasFlag(ClassAccessFlags.ACC_VOLATILE);
    }

    /**
     * Removes the.
     *
     * @param o the o
     * @return true, if successful
     */
    public boolean remove(Object o) {
        boolean remove = flagsList.remove(o);
        setFlags();
        return remove;
    }

    /**
     * Sets the flags.
     */
    private void setFlags() {
        flags = 0;
        for (ClassAccessFlags v : flagsList) {
            flags |= v.getFlag();
        }
    }

    /**
     * Sets the flags list.
     *
     * @param flagsList the new flags list
     */
    public void setFlagsList(List<ClassAccessFlags> flagsList) {
        this.flagsList = flagsList;
        this.setFlags();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return flagsList.toString();
    }
}
