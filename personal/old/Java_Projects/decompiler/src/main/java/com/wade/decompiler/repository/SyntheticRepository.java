package com.wade.decompiler.repository;

import java.util.HashMap;
import java.util.Map;

public class SyntheticRepository extends MemorySensitiveClassPathRepository {
    private static final Map<ClassPath, SyntheticRepository> instances = new HashMap<>(); // CLASSPATH X REPOSITORY

    public SyntheticRepository(ClassPath path) {
        super(path);
    }

    public static SyntheticRepository getInstance() {
        return getInstance(ClassPath.SYSTEM_CLASS_PATH);
    }

    public static SyntheticRepository getInstance(final ClassPath classPath) {
        SyntheticRepository rep = instances.get(classPath);
        if (rep == null) {
            rep = new SyntheticRepository(classPath);
            instances.put(classPath, rep);
        }
        return rep;
    }
}
