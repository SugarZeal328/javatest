package com.java.datastructure;

public class Solution {

    //求数组最大序列值，动态规划思想
    public int maxSubArray(int[] nums) {

        int pre = 0;
        int maxsum = nums[0];
        for(int i : nums){

            pre = (pre + i > i)? pre + i:i;
            maxsum = (maxsum > pre)? maxsum :pre;
        }

       return maxsum;

    }
}
