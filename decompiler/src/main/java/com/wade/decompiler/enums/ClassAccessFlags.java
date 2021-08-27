package com.wade.decompiler.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * The Enum ClassAccessFlags.
 */
public enum ClassAccessFlags {
    /** The acc public. */
    //@formatter:off
    ACC_PUBLIC(0x0001, 0),

    /** The acc private. */
    ACC_PRIVATE(0x0002, 1),

    /** The acc protected. */
    ACC_PROTECTED(0x0004, 2),

    /** The acc static. */
    ACC_STATIC(0x0008, 3),

    /** The acc final. */
    ACC_FINAL(0x0010, 4),

    /** The acc open. */
    ACC_OPEN(0x0020, 5),

    /** The acc super. */
    ACC_SUPER(0x0020, 5),

    /** The acc synchronized. */
    ACC_SYNCHRONIZED(0x0020, 5),

    /** The acc transitive. */
    ACC_TRANSITIVE(0x0020, 6),

    /** The acc bridge. */
    ACC_BRIDGE(0x0040, 6),

    /** The acc static phase. */
    ACC_STATIC_PHASE(0x0040, 6),

    /** The acc volatile. */
    ACC_VOLATILE(0x0040, 6),

    /** The acc transient. */
    ACC_TRANSIENT(0x0080, 7),

    /** The acc varargs. */
    ACC_VARARGS(0x0080, 7),

    /** The acc native. */
    ACC_NATIVE(0x0100, 8),

    /** The acc interface. */
    ACC_INTERFACE(0x0200, 9),

    /** The acc abstract. */
    ACC_ABSTRACT(0x0400, 10),

    /** The acc strict. */
    ACC_STRICT(0x0800, 11),

    /** The acc synthetic. */
    ACC_SYNTHETIC(0x1000, 12),

    /** The acc annotation. */
    ACC_ANNOTATION(0x2000, 13),

    /** The acc enum. */
    ACC_ENUM(0x4000, 14),

    /** The acc mandated. */
    ACC_MANDATED(0x8000, 15),

    /** The acc module. */
    ACC_MODULE(0x8000, 15),

    /** The max acc flag. */
    MAX_ACC_FLAG(0x4000, 16),

    /** The max acc flag i. */
    MAX_ACC_FLAG_I(0x8000, 17),

    /** The acc dummy. */
    ACC_DUMMY(0, 18);

    /**
     * Checks if is sets the.
     *
     * @param flag the flag
     * @param p the p
     * @return true, if is sets the
     */
    public static boolean isSet(int flag, ClassAccessFlags p) {
	return (flag & p.getFlag()) != 0;
    }

    /**
     * Read.
     *
     * @param flags the flags
     * @return the class access flags
     */
    public static ClassAccessFlags read(int flags) {
	ClassAccessFlags flag = ClassAccessFlags.ACC_DUMMY.setFlag(flags);
	return flag;
    }

    /**
     * Read list.
     *
     * @param accessFlags the access flags
     * @return the list
     */
    public static List<ClassAccessFlags> readList(int accessFlags) {
	List<ClassAccessFlags> list = new ArrayList<>();
	for (ClassAccessFlags v : ClassAccessFlags.values()) {
	    if (ClassAccessFlags.isSet(accessFlags, v)) {
		list.add(v);
	    }
	}
	return list;
    }

    /** The access names. */
    //@formatter:on
    private String[] ACCESS_NAMES = { "public", "private", "protected", "static", "", "synchronized", "volatile", "transient", "native", "interface", "abstract", "strictfp", "synthetic", "annotation", "enum", "module", "max flag", "max_flag 2", "DUMMY" };
    /** The flag. */
    private int flag;
    /** The name. */
    private String name;
    /** The index. */
    private int index;

    /**
     * Instantiates a new class access flags.
     *
     * @param flag  the flag
     * @param index the index
     */
    ClassAccessFlags(int flag, int index) {
        this.flag = flag;
        this.name = ACCESS_NAMES[index];
        this.index = index;
    }

    /**
     * Gets the flag.
     *
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if is abstract.
     *
     * @return true, if is abstract
     */
    public boolean isAbstract() {
        return (flag & ACC_ABSTRACT.getFlag()) != 0;
    }

    /**
     * Checks if is annotation.
     *
     * @return true, if is annotation
     */
    public boolean isAnnotation() {
        return (flag & ACC_ANNOTATION.getFlag()) != 0;
    }

    /**
     * Checks if is enum.
     *
     * @return true, if is enum
     */
    public boolean isEnum() {
        return (flag & ACC_ENUM.getFlag()) != 0;
    }

    /**
     * Checks if is final.
     *
     * @return true, if is final
     */
    public boolean isFinal() {
        return (flag & ACC_FINAL.getFlag()) != 0;
    }

    /**
     * Checks if is interface.
     *
     * @return true, if is interface
     */
    public boolean isInterface() {
        return (flag & ACC_INTERFACE.getFlag()) != 0;
    }

    /**
     * Checks if is mandated.
     *
     * @return true, if is mandated
     */
    public boolean isMandated() {
        return (flag & ACC_MANDATED.getFlag()) != 0;
    }

    /**
     * Checks if is native.
     *
     * @return true, if is native
     */
    public boolean isNative() {
        return (flag & ACC_NATIVE.getFlag()) != 0;
    }

    /**
     * Checks if is private.
     *
     * @return true, if is private
     */
    public boolean isPrivate() {
        return (flag & ACC_PRIVATE.getFlag()) != 0;
    }

    /**
     * Checks if is protected.
     *
     * @return true, if is protected
     */
    public boolean isProtected() {
        return (flag & ACC_PROTECTED.getFlag()) != 0;
    }

    /**
     * Checks if is public.
     *
     * @return true, if is public
     */
    public boolean isPublic() {
        return (flag & ACC_PUBLIC.getFlag()) != 0;
    }

    /**
     * Checks if is sets the.
     *
     * @param p the p
     * @return true, if is sets the
     */
    public boolean isSet(int p) {
        return (flag & p) != 0;
    }

    /**
     * Checks if is static.
     *
     * @return true, if is static
     */
    public boolean isStatic() {
        return (flag & ACC_STATIC.getFlag()) != 0;
    }

    /**
     * Checks if is strictfp.
     *
     * @return true, if is strictfp
     */
    public boolean isStrictfp() {
        return (flag & ACC_STRICT.getFlag()) != 0;
    }

    /**
     * Checks if is super.
     *
     * @return true, if is super
     */
    public boolean isSuper() {
        return (flag & ACC_SUPER.getFlag()) != 0;
    }

    /**
     * Checks if is synchronized.
     *
     * @return true, if is synchronized
     */
    public boolean isSynchronized() {
        return (flag & ACC_SYNCHRONIZED.getFlag()) != 0;
    }

    /**
     * Checks if is synthetic.
     *
     * @return true, if is synthetic
     */
    public boolean isSynthetic() {
        return (flag & ACC_SYNTHETIC.getFlag()) != 0;
    }

    /**
     * Checks if is transient.
     *
     * @return true, if is transient
     */
    public boolean isTransient() {
        return (flag & ACC_TRANSIENT.getFlag()) != 0;
    }

    /**
     * Checks if is var args.
     *
     * @return true, if is var args
     */
    public boolean isVarArgs() {
        return (flag & ACC_VARARGS.getFlag()) != 0;
    }

    /**
     * Checks if is volatile.
     *
     * @return true, if is volatile
     */
    public boolean isVolatile() {
        return (flag & ACC_VOLATILE.getFlag()) != 0;
    }

    /**
     * Sets the flag.
     *
     * @param flag the flag
     * @return the class access flags
     */
    public ClassAccessFlags setFlag(int flag) {
        this.flag = flag;
        this.name = ACCESS_NAMES[flag];
        return this;
    }
}
