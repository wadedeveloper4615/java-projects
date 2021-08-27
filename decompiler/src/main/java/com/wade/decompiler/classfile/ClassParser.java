package com.wade.decompiler.classfile;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.Version;
import com.wade.decompiler.exceptions.ClassFormatException;

/**
 * The Class ClassParser.
 */
public class ClassParser {
    /** The bufsize. */
    private static int BUFSIZE = 8192;
    /** The file name. */
    private String fileName;
    /** The input stream. */
    private InputStream inputStream;
    /** The version. */
    private Version version;
    /** The constant pool. */
    private ConstantPool constantPool;
    /** The class name index. */
    private Integer classNameIndex;
    /** The superclass name index. */
    private Integer superclassNameIndex;
    /** The interfaces. */
    private List<Integer> interfaces;
    /** The fields. */
    private List<Field> fields;
    /** The methods. */
    private List<Method> methods;
    /** The attributes. */
    private List<Attribute> attributes;
    /** The access flags. */
    private Integer accessFlags;

    /**
     * Instantiates a new class parser.
     */
    public ClassParser() {
    }

    /**
     * Instantiates a new class parser.
     *
     * @param inputStream the input stream
     * @param fileName    the file name
     */
    public ClassParser(InputStream inputStream, String fileName) {
	this.fileName = fileName;
	if (inputStream instanceof DataInputStream) {
	    this.inputStream = inputStream;
	} else {
	    this.inputStream = new BufferedInputStream(inputStream, BUFSIZE);
	}
    }

    /**
     * Instantiates a new class parser.
     *
     * @param fileName the file name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ClassParser(String fileName) throws IOException {
	this.inputStream = new BufferedInputStream(new FileInputStream(fileName), BUFSIZE);
    }

    /**
     * Parses the.
     *
     * @param isInnerClass the is inner class
     * @return the java class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public JavaClass parse(Boolean isInnerClass) throws IOException {
	try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
	    readID(dataInputStream);
	    readVersion(dataInputStream);
	    readConstantPool(dataInputStream);
	    readClassInfo(dataInputStream);
	    readInterfaces(dataInputStream);
	    readFields(dataInputStream, isInnerClass);
	    readMethods(dataInputStream, isInnerClass);
	    readAttributes(dataInputStream, isInnerClass);
	}
	return JavaClass.builder().classNameIndex(classNameIndex).superclassNameIndex(superclassNameIndex).fileName(fileName).version(version).accessFlags(accessFlags).constantPool(constantPool).interfaces(interfaces).fields(fields).methods(methods).attributes(attributes).build();
    }

    /**
     * Read attributes.
     *
     * @param inputStream  the input stream
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readAttributes(DataInput inputStream, Boolean isInnerClass) throws IOException {
	int attributes_count = inputStream.readUnsignedShort();
	attributes = new ArrayList<>();
	for (int i = 0; i < attributes_count; i++) {
	    attributes.add(Attribute.readAttribute(inputStream, constantPool, isInnerClass));
	}
    }

    /**
     * Read class info.
     *
     * @param inputStream the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readClassInfo(DataInput inputStream) throws IOException {
	accessFlags = inputStream.readUnsignedShort();
	classNameIndex = inputStream.readUnsignedShort();
	superclassNameIndex = inputStream.readUnsignedShort();
    }

    /**
     * Read constant pool.
     *
     * @param inputStream the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readConstantPool(DataInput inputStream) throws IOException {
	constantPool = new ConstantPool(inputStream);
    }

    /**
     * Read fields.
     *
     * @param inputStream  the input stream
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readFields(DataInput inputStream, Boolean isInnerClass) throws IOException {
	int fields_count = inputStream.readUnsignedShort();
	fields = new ArrayList<>();
	for (int i = 0; i < fields_count; i++) {
	    fields.add(new Field(inputStream, constantPool, isInnerClass));
	}
    }

    /**
     * Read ID.
     *
     * @param inputStream the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readID(DataInput inputStream) throws IOException {
	if (inputStream.readInt() != 0xCAFEBABE) {
	    throw new ClassFormatException(fileName + " is not a Java .class file");
	}
    }

    /**
     * Read interfaces.
     *
     * @param inputStream the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readInterfaces(DataInput inputStream) throws IOException {
	int interfaces_count = inputStream.readUnsignedShort();
	interfaces = new ArrayList<>();
	for (int i = 0; i < interfaces_count; i++) {
	    interfaces.add(inputStream.readUnsignedShort());
	}
    }

    /**
     * Read methods.
     *
     * @param inputStream  the input stream
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readMethods(DataInput inputStream, Boolean isInnerClass) throws IOException {
	int methods_count = inputStream.readUnsignedShort();
	methods = new ArrayList<>();
	for (int i = 0; i < methods_count; i++) {
	    methods.add(new Method(inputStream, constantPool, isInnerClass));
	}
    }

    /**
     * Read version.
     *
     * @param inputStream the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void readVersion(DataInput inputStream) throws IOException {
	version = Version.read(inputStream.readUnsignedShort(), inputStream.readUnsignedShort());
    }
}
