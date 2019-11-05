package com.martin.btrace.test.tracker;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class RegexTracer {

    @OnMethod(clazz = "/com.martin.btrace.test.controller.*/", method = "/.*/", location = @Location(Kind.RETURN))
    public static void traceArgs(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] anyTypes, @Return String result) {
        BTraceUtils.println(pcn + "." + pmn);
        BTraceUtils.printArray(anyTypes);
        BTraceUtils.println(result);
        BTraceUtils.println();
    }
}
