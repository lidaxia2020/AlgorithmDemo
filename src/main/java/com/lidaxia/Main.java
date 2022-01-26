package com.lidaxia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/24 19:41
 */
public class Main {

    public static void main(String[] args) {
        String sp = "123$123";
        String[] s = sp.split("\\$");

        String str = null;
        System.out.println(str);
        System.out.println(str + "");

        String test = "test_";
        System.out.println(test + str);

        Integer integer = null;
        System.out.println(integer);
        System.out.println(integer + "");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
            if (list.size() > 10) {
                clearList(list);
            }
            System.out.println("clearList+++++" + list.size());
        }

    }

    private static void clearList(List<String> list) {
        System.out.println("list = " + list.hashCode());
        List<String> list1=list.stream().filter(x->x.equals("1")).collect(Collectors.toList());
        list=list.stream().filter(x->x.equals("1")).collect(Collectors.toList());
        System.out.println("list = " + list.hashCode());
        System.out.println("clearList==============" + list1.size());
        System.out.println("clearList==============" + list.size());
        list.clear();
    }
}
