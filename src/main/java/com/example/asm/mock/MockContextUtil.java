package com.example.asm.mock;

import java.util.concurrent.ConcurrentHashMap;

public class MockContextUtil {

    /**
     * 修改后的类的字节码
     */
    public static ConcurrentHashMap<String, byte[]> BYTECODE_MAP = new ConcurrentHashMap<>();

    public static String CURRENT_CLASS_PATH = "";
    public static String CURRENT_METHOD_NAME = "";
    public static String CURRENT_MOCK_JSON = "";

}
