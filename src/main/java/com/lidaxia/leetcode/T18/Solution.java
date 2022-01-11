package com.lidaxia.leetcode.T18;

import java.util.*;

/**
 * 18. 四数之和
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 15:05（
 */
public class Solution {

    /**
     * 双指针法
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        //对数组排序
        //不放在下面方法里排序是为了减少不必要的性能消耗，不必在每次递归时都进行一次O(NlogN)的排序
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    //设计一个n数之和的API
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        //至少是2数之和并且数组长度至少要等于目标元素的个数
        if (n < 2 || size < n) {
            return result;
        }
        //求2数之和，采用双指针法
        if (n == 2) {
            int left = start;
            int right = size - 1;
            while (left < right) {
                int leftElem = nums[left];
                int rightElem = nums[right];
                int sum = leftElem + rightElem;
                if (sum < target) {
                    //左指针右移+去重
                    while (left < right && nums[left] == leftElem) left++;
                } else if (sum > target) {
                    //右指针左移+去重
                    while (left < right && nums[right] == rightElem) right--;
                } else {
                    //加入一组元素
                    result.add(Arrays.asList(leftElem, rightElem));
                    //去重
                    while (left < right && nums[left] == leftElem) left++;
                    while (left < right && nums[right] == rightElem) right--;
                }
            }
        } else {
            //大于2个数之和，采用递归计算
            for (int i = start; i < size; i++) {
                List<List<Integer>> subResult = nSum(nums, n - 1, i + 1,
                        target - nums[i]);
                //加入当前元素
                for (List<Integer> list : subResult) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.addAll(list);
                    result.add(arrayList);
                }
                //去重
                while (i < size - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
        return result;
    }



    /**
     * 本人写  超时
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        nums = sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target && nums[i] > 0)
                break;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] > target && nums[j] > 0)
                    break;
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] > target && nums[k] > 0)
                        break;
                    for (int m = k + 1; m < nums.length; m++) {
                        if (nums[i] + nums[j] + nums[m] + nums[k] > target)
                            break;
                        if (nums[i] + nums[j] + nums[m] + nums[k] == target) {
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        }
                    }
                }
            }
        }
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        System.out.println(solution.fourSum(nums, -11));
    }

    private int[] sort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            sort(arr, left, mid, temp);
            //右边归并排序，使得右子序列有序
            sort(arr, mid + 1, right, temp);
            //将两个有序子数组合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
