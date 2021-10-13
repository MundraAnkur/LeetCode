package com.problem.coding.medium;

import java.util.Arrays;

/**
 * @author ankurmundra
 * September 30, 2021
 */
public class PartitionKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return (k == twoSum(nums, nums[nums.length - 1])) ||
                (k == twoSum(nums, nums[nums.length - 1] + nums[0]));
    }

    private int twoSum(int[] nums, int target)
    {
        int i = 0, count = 0, j = nums.length-1;

        if(target == nums[j])
            while (nums[j--] == target)
                count++;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                count++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < target)
                i++;
            else
                j--;
        }
        return count;
    }
}
