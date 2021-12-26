package com.lidaxia.tree;

import java.util.Arrays;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/22 19:31
 */
public class Main {

    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums){
            bst.add(num);
        }


        System.out.println(bst);

//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        bst.levelOrder();

        System.out.println();
        System.out.println(bst.removeMin());
        System.out.println();
        System.out.println(bst.removeMax());
    }
}
