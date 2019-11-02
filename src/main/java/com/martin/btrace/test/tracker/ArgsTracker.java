package com.martin.btrace.test.tracker;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class ArgsTracker {

    @OnMethod(clazz = "com.martin.btrace.test.controller.BTraceController",
            method = "args", location = @Location(Kind.ENTRY))
    public static void traceArgs(@ProbeClassName String pcn, @ProbeMethodName String pmn,
                                 AnyType[] anyTypes, @Return String result) {
        BTraceUtils.print(pcn + "." + pmn);
        BTraceUtils.printArray(anyTypes);
        BTraceUtils.print(result);
    }
}