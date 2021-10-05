package com.problem.coding.medium;

/**
 * @author ankurmundra
 * September 28, 2021
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;

        for (int i = 0; i < nums.length-1; ) {
            jumps++;
            if(i+nums[i]< nums.length-1)
                i = getNextIndex(nums,i);
            else
                break;
        }
        return jumps;
    }

    private int getNextIndex(int[] nums, int i)
    {
        int max = i+1;
        for (int j = i+1; j <= i+nums[i]; j++)
            if (j + nums[j] > max + nums[max])
                max = j;
        return max;
    }
}
