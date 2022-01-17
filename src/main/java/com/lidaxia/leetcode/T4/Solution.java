package com.lidaxia.leetcode.T4;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/17 16:17（
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] temp = new int[nums1.length + nums2.length];
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        if (nums1.length == 0) {
            for (int i = 0; i < nums2.length; i++) {
                temp[i] = nums2[i];
            }
        }

        if (nums2.length == 0) {
            for (int i = 0; i < nums1.length; i++) {
                temp[i] = nums1[i];
            }
        }

        if (nums1.length != 0 && nums2.length != 0) {
            mearge(nums1, nums2, temp);
        }


        if (temp.length % 2 != 0) {
            int n = temp.length / 2;
            return temp[n];
        } else {
            int n = temp.length / 2 - 1;
            return (temp[n] + temp[n + 1]) / 2.0;
        }
    }


    public static void mearge(int[] nums1, int[] nums2, int[] temp) {
        int n1 = 0, n2 = 0;
        int t = 0;
        for (int i = 0; i < temp.length; i++) {
            if (nums1[n1] < nums2[n2]) {
                temp[i] = nums1[n1];
                n1++;
                if (n1 == nums1.length) {
                    t = i + 1;
                    break;
                }
            } else {
                temp[i] = nums2[n2];
                n2++;
                if (n2 == nums2.length) {
                    t = i + 1;
                    break;
                }
            }
        }

        if (n1 == nums1.length) {
            for (int i = n2; i < nums2.length; i++) {
                temp[t] = nums2[i];
                t++;
            }
        } else {
            for (int i = n1; i < nums1.length; i++) {
                temp[t] = nums1[i];
                t++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
