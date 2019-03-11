package com.example.asm;

import com.google.gson.Gson;
import org.junit.Test;

public class GsonTest extends AsmApplicationTests {

    private static Gson gson = new Gson();

    @Test
    public void a() {
        String str = "hello mock";
        System.out.println(gson.toJson(str));
    }

    @Test
    public void b() {
        String str = "\"hello mock\"";
        System.out.println(gson.fromJson(str, String.class));
    }
}
