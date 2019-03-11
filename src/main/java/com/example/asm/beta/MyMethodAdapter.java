package com.example.asm.beta;

import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

public class MyMethodAdapter extends MethodAdapter {

    MyMethodAdapter(MethodVisitor mv) {
        super(mv);
    }

    @Override
    public void visitCode() {



        //Label l0 = new Label();
        //mv.visitLabel(l0);
        //mv.visitLineNumber(15, l0);
        //mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        //mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Thread", "currentThread", "()Ljava/lang/Thread;");
        //mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Thread", "getStackTrace", "()[Ljava/lang/StackTraceElement;");
        //mv.visitInsn(Opcodes.ICONST_0);
        //mv.visitInsn(Opcodes.AALOAD);
        //mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StackTraceElement", "getClassName", "()Ljava/lang/String;");
        //mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Thread", "currentThread", "()Ljava/lang/Thread;");
        //mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Thread", "getStackTrace", "()[Ljava/lang/StackTraceElement;");
        //mv.visitInsn(Opcodes.ICONST_0);
        //mv.visitInsn(Opcodes.AALOAD);
        //mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StackTraceElement", "getMethodName", "()Ljava/lang/String;");
        //mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/example/asm/mock/MockUtil", "doMock", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
        //mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/Object;)V");
        //Label l1 = new Label();
        //mv.visitLabel(l1);
        //mv.visitLineNumber(16, l1);
        //mv.visitInsn(Opcodes.RETURN);
        //Label l2 = new Label();
        //mv.visitLabel(l2);
        //mv.visitLocalVariable("this", "Lcom/example/asm/MyServiceImpl;", null, l0, l2, 0);



    }
}
