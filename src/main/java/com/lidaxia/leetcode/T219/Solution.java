package com.lidaxia.leetcode.T219;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/18 16:25（
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
