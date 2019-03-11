package com.example.asm;

import com.example.asm.beta.MyClassAdapter;
import com.example.asm.loader.MyClassLoader;
import com.example.asm.mock.MockContextUtil;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@PropertySource("mock.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsmApplicationTests {

    @Resource
    private MyService myService;

    @Test
    public void contextLoads() {
        myService.doWhat();
    }

    @Value(value = "${classPath}")
    private String classPath;

    @Value(value = "${mockJson}")
    private String mockJson;

    @Value(value = "${methodName}")
    private String methodName;


    @Test
    public void gogogo() {
        this.getMockClassBytecode();
        this.loadMockClass();

    }

    /**
     * 修改 mock 类字节码
     * 存进 MockCache.bytecodeMap
     */
    @Test
    public void getMockClassBytecode() {
        myService.doWhat();

        MockContextUtil.CURRENT_CLASS_PATH = classPath;
        MockContextUtil.CURRENT_METHOD_NAME = methodName;
        MockContextUtil.CURRENT_MOCK_JSON = mockJson;


        ClassReader classReader;
        try {
            classReader = new ClassReader(MockContextUtil.CURRENT_CLASS_PATH);
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassAdapter classAdapter = new MyClassAdapter(classWriter);
            classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] bytes = classWriter.toByteArray();
            MockContextUtil.BYTECODE_MAP.put(MockContextUtil.CURRENT_CLASS_PATH, bytes);


            //写入文件
            File file = new File("MyServiceImpl.class");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载修改后的类
     */
    @Test
    public void loadMockClass() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            MyClassLoader myClassLoader = new MyClassLoader(classLoader);
            Class aClass = myClassLoader.loadClass(MockContextUtil.CURRENT_CLASS_PATH);
            MyService myService = (MyService) aClass.newInstance();
            myService.doWhat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
