package com.lidaxia.array;


import java.util.Arrays;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/18 20:56
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array(5);
        for (int i =0;i<10;i++)
            array.addLast(i);

        System.out.println(array);

        array.add(3,30);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);
    }

}
