package com.martin.btrace.test.tracker;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class ThrowableTracer {

    @TLS
    static Throwable currentThrowable;

    @OnMethod(clazz = "java.lang.Throwable", method = "<init>")
    public static void traceThrowable(@Self Throwable self) {
        //new Throwable()
        currentThrowable = self;
    }

    @OnMethod(clazz = "java.lang.Throwable", method = "<init>")
    public static void traceThrowable(@Self Throwable self, String message) {
        //new Throwable(String message)
        currentThrowable = self;
    }

    @OnMethod(clazz = "java.lang.Throwable", method = "<init>")
    public static void traceThrowable(@Self Throwable self, Throwable cause) {
        //new Throwable(Throwable cause)
        currentThrowable = self;
    }

    @OnMethod(clazz = "java.lang.Throwable", method = "<init>")
    public static void traceThrowable(@Self Throwable self, String message, Throwable cause) {
        //new Throwable(String message, Throwable cause)
        currentThrowable = self;
    }


    @OnMethod(clazz = "java.lang.Throwable", method = "<init>", location = @Location(Kind.RETURN))
    public static void print() {
        if (currentThrowable != null) {
            BTraceUtils.Threads.jstack(currentThrowable);
            currentThrowable = null;
        }
        BTraceUtils.println();
    }
}