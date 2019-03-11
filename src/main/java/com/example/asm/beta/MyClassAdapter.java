package com.example.asm.beta;

import com.example.asm.mock.MockContextUtil;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

public class MyClassAdapter extends ClassAdapter {

    public MyClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!MockContextUtil.CURRENT_METHOD_NAME.equals(name)) {
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
        MethodVisitor methodVisitor = cv.visitMethod(access, name, desc, signature, exceptions);
        return new MyMethodAdapter(methodVisitor);
    }
}
