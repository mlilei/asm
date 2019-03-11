//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.asm;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public Integer doWhat() {
        Random random = new Random();
        return random.nextInt();
    }
}
