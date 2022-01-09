package com.lidaxia.hash;

import java.util.HashSet;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/9 19:49
 */
public class Main {

    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        double c= 3.14;
        System.out.println(((Double) c).hashCode());

        String d = "test";
        System.out.println(d.hashCode());

        Student student = new Student(1,2,"hash",13);
        System.out.println(student.hashCode());

        HashSet set = new HashSet();

    }
}
