package com.example.asm.mock;

public class MockUtil {

    public static Object doMock(String className, String methodName) {
        System.out.println("MockUtil.doMock()");
        System.out.println("className : " + className);
        System.out.println("methodName : " + methodName);


        if (System.currentTimeMillis() > 1L) {
            return "MockUtil.doMock()";
        }
        return null;
    }
}
