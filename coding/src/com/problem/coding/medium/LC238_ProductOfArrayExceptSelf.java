package com.problem.coding.medium;

import java.util.Arrays;

/**
 * @author ankurmundra
 * October 04, 2021
 */
public class LC238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0)
                zeroCount++;
            else
                product = product * num;
        }

        if(zeroCount==1)
        {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0)
                    nums[i] = (int) product;
                else
                    nums[i] = 0;
            }
        }
        else if(zeroCount>1)
            Arrays.fill(nums, 0);
        else
            for (int i = 0; i < nums.length; i++)
                nums[i] = divide(product,nums[i]);
        return nums;
    }

    private int divide(long a, int b)
    {
        int isNegative = (a < 0) ^ (b < 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);

        if(b==1)
            return isNegative * ((int) a);
        return (int) Math.round(isNegative * Math.exp(Math.log(a)-Math.log(b)));
    }
}
