package com.wade.pojotester.testfiles.fields;

import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassContainingStream.
 */
@SuppressWarnings({ "rawtypes", "unused" })
public class ClassContainingStream {
    
    /** The stream integer. */
    private final Stream<Integer> stream_Integer = Stream.of(1);
    
    /** The stream string. */
    private Stream<String> stream_String;
    
    /** The stream object. */
    private Stream<Object> stream_Object;
    
    /** The stream A. */
    private Stream<A> stream_A;
    
    /** The stream. */
    private Stream stream;
    
    /** The a. */
    private A a;

    /**
     * The Class A.
     */
    private class A {
    }
}
