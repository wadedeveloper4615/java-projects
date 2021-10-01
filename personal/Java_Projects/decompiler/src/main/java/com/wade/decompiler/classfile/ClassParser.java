package com.wade.decompiler.classfile;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.exceptions.ClassFormatException;
import com.wade.decompiler.constants.Const;
import com.wade.decompiler.enums.ClassAccessFlags;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode
public class ClassParser {
    private static int BUFSIZE = 8192;
    private InputStream inputStream;
    private String fileName;
    private int classNameIndex;
    private int superclassNameIndex;
    private ClassAccessFlagsList accessFlags;
    private List<Integer> interfaces;
    private ConstantPool constantPool;
    private List<Field> fields;
    private List<Method> methods;
    private List<Attribute> attributes;
    private boolean isZip;
    private Version version;
    private ZipFile zip;

    public ClassParser() {
    }

    public ClassParser(InputStream inputStream, String fileName) {
        this.fileName = fileName;
        String clazz = inputStream.getClass().getName();
        this.isZip = clazz.startsWith("java.util.zip.") || clazz.startsWith("java.util.jar.");
        this.zip = null;
        if (inputStream instanceof DataInputStream) {
            this.inputStream = inputStream;
        } else {
            this.inputStream = new BufferedInputStream(inputStream, BUFSIZE);
        }
    }

    public ClassParser(String fileName) throws IOException {
        this.isZip = true;
        this.zip = null;
        this.inputStream = new BufferedInputStream(new FileInputStream(fileName), BUFSIZE);
    }

    public ClassParser(String zipFile, String fileName) throws IOException {
        this.isZip = true;
        this.zip = new ZipFile(zipFile);
        ZipEntry entry = zip.getEntry(fileName);
        if (entry == null) {
            throw new IOException("File " + fileName + " not found");
        }
        inputStream = new BufferedInputStream(zip.getInputStream(entry), BUFSIZE);
    }

    public JavaClass parse() throws IOException, ClassFormatException {
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            readID(dataInputStream);
            readVersion(dataInputStream);
            readConstantPool(dataInputStream);
            readClassInfo(dataInputStream);
            readInterfaces(dataInputStream);
            readFields(dataInputStream);
            readMethods(dataInputStream);
            readAttributes(dataInputStream);
        } finally {
            try {
                if (zip != null) {
                    zip.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return new JavaClass(classNameIndex, superclassNameIndex, fileName, version, accessFlags, constantPool, interfaces, fields, methods, attributes);
    }

    private void readAttributes(DataInput inputStream) throws IOException, ClassFormatException {
        int attributes_count = inputStream.readUnsignedShort();
        attributes = new ArrayList<>();
        for (int i = 0; i < attributes_count; i++) {
            attributes.add(Attribute.readAttribute(inputStream, constantPool));
        }
    }

    private void readClassInfo(DataInput inputStream) throws IOException, ClassFormatException {
        accessFlags = new ClassAccessFlagsList(inputStream);
        if (accessFlags.isInterface()) {
            accessFlags.addFlag(ClassAccessFlags.ACC_ABSTRACT);
        }
        if (accessFlags.isFinalAndAbstract()) {
            throw new ClassFormatException("Class " + fileName + " can't be both final and abstract");
        }
        classNameIndex = inputStream.readUnsignedShort();
        superclassNameIndex = inputStream.readUnsignedShort();
    }

    protected void readConstantPool(DataInput inputStream) throws IOException, ClassFormatException {
        constantPool = new ConstantPool(inputStream);
    }

    protected void readFields(DataInput inputStream) throws IOException, ClassFormatException {
        int fields_count = inputStream.readUnsignedShort();
        fields = new ArrayList<>();
        for (int i = 0; i < fields_count; i++) {
            fields.add(new Field(inputStream, constantPool));
        }
    }

    protected void readID(DataInput inputStream) throws IOException, ClassFormatException {
        if (inputStream.readInt() != Const.JVM_CLASSFILE_MAGIC) {
            throw new ClassFormatException(fileName + " is not a Java .class file");
        }
    }

    protected void readInterfaces(DataInput inputStream) throws IOException, ClassFormatException {
        int interfaces_count = inputStream.readUnsignedShort();
        interfaces = new ArrayList<>();
        for (int i = 0; i < interfaces_count; i++) {
            interfaces.add(inputStream.readUnsignedShort());
        }
    }

    protected void readMethods(DataInput inputStream) throws IOException, ClassFormatException {
        int methods_count = inputStream.readUnsignedShort();
        methods = new ArrayList<>();
        for (int i = 0; i < methods_count; i++) {
            methods.add(new Method(inputStream, constantPool));
        }
    }

    protected void readVersion(DataInput inputStream) throws IOException, ClassFormatException {
        version = Version.read(inputStream.readUnsignedShort(), inputStream.readUnsignedShort());
    }
}
