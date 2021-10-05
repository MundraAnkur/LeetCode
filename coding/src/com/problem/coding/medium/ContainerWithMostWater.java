package com.problem.coding.medium;

/**
 * @author ankurmundra
 * October 02, 2021
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0, localArea;
        int i = 0, j = height.length-1;

        while (i<j)
        {
            localArea = (j-i)* Math.min(height[i], height[j]);
            maxArea = Math.max(localArea,maxArea);

            if(height[j] > height[i])
                i++;
            else
                j--;
        }
        return maxArea;
    }

}
