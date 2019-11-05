package com.martin.btrace.test.tracker;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class ConstructorTracer {

    @OnMethod(clazz = "com.martin.btrace.test.bean.User", method = "<init>")
    public static void traceConstructor(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] anyTypes) {
        BTraceUtils.println(pcn + "." + pmn);
        BTraceUtils.printArray(anyTypes);
        BTraceUtils.println();
    }
}
