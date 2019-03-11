package com.example.asm.loader;

import com.example.asm.mock.MockContextUtil;

import java.util.Arrays;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("loadClass : " + name);
        if (!MockContextUtil.CURRENT_CLASS_PATH.equals(name)) {
            return super.loadClass(name);
        }
        byte[] classData = MockContextUtil.BYTECODE_MAP.get(MockContextUtil.CURRENT_CLASS_PATH);
        System.out.println("classData : " + Arrays.toString(classData));
        return defineClass(MockContextUtil.CURRENT_CLASS_PATH,
                classData, 0, classData.length);

    }
}
