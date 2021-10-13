package com.problem.coding.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ankurmundra
 * October 08, 2021
 */
public class LC56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();

        int minStart = intervals[0][0];
        int maxEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0] <= maxEnd)
            {
                minStart = Math.min(minStart,intervals[i][0]);
                maxEnd = Math.max(maxEnd,intervals[i][1]);
            }
            else
            {
                list.add(new int[]{minStart,maxEnd});
                minStart = intervals[i][0];
                maxEnd = intervals[i][1];
            }
        }
        list.add(new int[]{minStart,maxEnd});
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] item : list) result[index++] = item;
        return result;
    }
}
