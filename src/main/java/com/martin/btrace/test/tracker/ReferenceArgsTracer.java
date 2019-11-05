package com.martin.btrace.test.tracker;

import com.martin.btrace.test.bean.User;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class ReferenceArgsTracer {

    @OnMethod(clazz = "com.martin.btrace.test.controller.BTraceController",
            method = "referenceArgs", location = @Location(Kind.ENTRY))
    public static void traceReferenceArgs(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
        BTraceUtils.println(pcn + "." + pmn);
        BTraceUtils.printFields(user);
        BTraceUtils.println();
    }
}