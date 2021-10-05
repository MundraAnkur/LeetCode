package com.problem.coding.medium;

import java.util.Arrays;

/**
 * @author ankurmundra
 * October 03, 2021
 */
public class LC16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int val, min = 10001, temp=min;
        for (int i = 0; i < nums.length - 2; i++) {
            val = twoSum(nums,i,target-nums[i]);
            if(Math.abs(target-val) <= min)
            {
                min = Math.abs(target-val);
                temp = closer(target,temp,val);
            }
            if(min==0)
                return val;
        }
        return Math.abs(target-min);
    }

    private int twoSum(int[] nums, int i, int target)
    {
        int j = i+1;
        int k = nums.length-1;
        int temp = 10001;

        while (j<k)
        {
            int current = nums[j]+nums[k]+nums[i];
            if(current == target)
                return target;
            else if(current > target)
                k--;
            else
                j++;
            temp = closer(target,temp,current);
        }

        return temp;
    }

    private int closer(int target, int val1,int val2)
    {
        return Math.abs(target - val1) > Math.abs(target - val2) ? val2 : val1;
    }

}
