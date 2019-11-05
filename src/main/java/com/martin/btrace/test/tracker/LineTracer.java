package com.martin.btrace.test.tracker;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class LineTracer {

    @OnMethod(clazz = "com.martin.btrace.test.controller.BTraceController",
            location = @Location(value = Kind.LINE, line = 37))
    public static void traceLine(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
        BTraceUtils.println(pcn + "." + pmn + "," + line);
        BTraceUtils.println();
    }
}