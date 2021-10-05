package com.problem.coding.medium;

import java.util.*;

/**
 * @author ankurmundra
 * September 30, 2021
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++)
            if(i==0 || (nums[i]!=nums[i-1]))
                twoSum(nums, lists, i);
        return lists;
    }

    private void twoSum(int[] nums, List<List<Integer>> lists, int i) {
        int j = i +1;
        int k = nums.length-1;
        while (j<k)
        {
            if(nums[j]+ nums[k]+ nums[i]==0)
            {
                lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[j++], nums[k--])));
                while (k>j && nums[k]==nums[k+1])
                    k--;
            }
            else if(nums[j]+ nums[k]+ nums[i] > 0)
                k--;
            else
                j++;
        }
    }
}
