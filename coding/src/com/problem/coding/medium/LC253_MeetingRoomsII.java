package com.problem.coding.medium;

import java.util.*;

/**
 * @author ankurmundra
 * October 09, 2021
 */
public class LC253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        priorityQueue.add(intervals[0][1]);
        int minEnd;
        int counter = 1;

        for(int i=1;i<intervals.length;i++)
        {
            minEnd = priorityQueue.peek();
            if(intervals[i][0] < minEnd)
                counter++;
            else
                priorityQueue.poll();
            priorityQueue.add(intervals[i][1]);
        }
        return counter;
    }

}
