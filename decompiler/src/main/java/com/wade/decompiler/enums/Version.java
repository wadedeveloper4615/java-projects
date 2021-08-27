package com.wade.decompiler.enums;

/**
 * The Enum Version.
 */
public enum Version {
    /** The Version 1 1. */
    //@formatter:off
    Version_1_1(45, 3, "1.1"),
 /** The Version 1 2. */
 Version_1_2(46, 0, "1.2"),
 /** The Version 1 3. */
 Version_1_3(47, 0, "1.3"),
 /** The Version 1 4. */
 Version_1_4(48, 0, "1.4"),
 /** The Version 1 5. */
 Version_1_5(49, 0, "1.5"),
 /** The Version 1 6. */
 Version_1_6(50, 0, "1.6"),
 /** The Version 1 7. */
 Version_1_7(51, 0, "1.7"),
 /** The Version 1 8. */
 Version_1_8(52, 0, "1.8"),
 /** The Version 9. */
 Version_9(53, 0, "9"),
 /** The Version 10. */
 Version_10(54, 0, "10"),
 /** The Version 11. */
 Version_11(55, 0, "11"),
 /** The Version 12. */
 Version_12(56, 0, "12"),
 /** The Version 13. */
 Version_13(57, 0, "13"),
 /** The Version 14. */
 Version_14(58, 0, "14"),
 /** The Version 15. */
 Version_15(59, 0, "15"),
 /** The Version 16. */
 Version_16(60, 0, "15+"),
 /** The Unknown. */
 Unknown(-1, -1, "Unknown");

    /**
     * Read.
     *
     * @param minor the minor
     * @param major the major
     * @return the version
     */
    public static Version read(int minor, int major) {
	for (Version v : Version.values()) {
	    if (v.getMajor() == major && v.getMinor() == minor) {
		return v;
	    }
	}
	System.out.println("major=" + major + " minor=" + minor);
	return Unknown;
    }
    /** The major. */
    //@formatter:on
    private final int major;
    /** The minor. */
    private final int minor;

    /** The version string. */
    private final String versionString;

    /**
     * Instantiates a new version.
     *
     * @param major         the major
     * @param minor         the minor
     * @param versionString the version string
     */
    Version(int major, int minor, String versionString) {
        this.major = major;
        this.minor = minor;
        this.versionString = versionString;
    }

    /**
     * Gets the major.
     *
     * @return the major
     */
    public int getMajor() {
        return major;
    }

    /**
     * Gets the minor.
     *
     * @return the minor
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Gets the version string.
     *
     * @return the version string
     */
    public String getVersionString() {
        return versionString;
    }
}