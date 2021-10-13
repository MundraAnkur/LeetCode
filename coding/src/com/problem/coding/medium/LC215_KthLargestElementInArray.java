package com.problem.coding.medium;

import java.util.Random;

/**
 * @author ankurmundra
 * October 12, 2021
 */
public class LC215_KthLargestElementInArray {
    private Random random;
    public int findKthLargest(int[] nums, int k) {
        random = new Random();
        return quickSelect(nums,0, nums.length-1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if(l<=r)
        {
            int pivot = l + random.nextInt(r-l+1);
            int j = l;
            swap(nums,pivot,r);
            for (int i = l; i < r; i++)
                if (nums[i] < nums[r])
                    swap(nums,i,j++);
            swap(nums,r,j);
            pivot = j;
            if(pivot == nums.length-k)
                return nums[pivot];
            else if(pivot > nums.length-k-1)
                return quickSelect(nums,l,pivot-1,k);
            else
                return quickSelect(nums,pivot+1,r,k);
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
