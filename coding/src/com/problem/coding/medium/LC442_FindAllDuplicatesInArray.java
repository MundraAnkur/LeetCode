package com.problem.coding.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankurmundra
 * October 05, 2021
 */
public class LC442_FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1]<0)
                list.add(Math.abs(nums[i]));
            nums[Math.abs(nums[i])-1] = -1*nums[Math.abs(nums[i])-1];
        }
        return list;
    }
}
