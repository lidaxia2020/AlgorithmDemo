package com.lidaxia.proxy;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author lijiannan
 * @desc
 * @date 2022/1/24 9:10（
 */
public class ProxyTest {




    public static void main(String[] args) {
        // 当 test 与方法名相同  返回 abc
        Ai ai = (Ai)create(Ai.class.getName() +"&helloWorld=abc");
        System.out.println(ai);

        // 当 test 与方法名不相同  返回null
        Ai aiTest = (Ai)create(Ai.class.getName() +"&test=abc");
        System.out.println(aiTest);
    }

    // 实现该方法
    private static Object create(String s) {
        return null;
    }


    interface Ai {
        void helloWorld();
    }
}


