package com.ggsd.jvm.c3_jmm;

import java.lang.instrument.Instrumentation;

/**
 * @Auther: ljq
 * @Date: 2021/2/25 16:18
 * @Description
 */
public class ObjectSizeAgent {

    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }

}
