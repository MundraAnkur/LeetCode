package com.problem.coding.medium;

import java.util.PriorityQueue;

/**
 * @author ankurmundra
 * October 12, 2021
 */
public class LC973_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<>((o1, o2) -> distance(o2)-distance(o1));

        for (int i = 0; i < points.length; i++) {
            if(i<k)
                priorityQueue.add(points[i]);
            else if(distance(points[i]) < distance(priorityQueue.peek()))
            {
                priorityQueue.add(points[i]);
                priorityQueue.poll();
            }
        }

        int[][] result = new int[k][2];
        while (!priorityQueue.isEmpty())
            result[--k] = priorityQueue.poll();
        return result;
    }

    private int distance(int[] point)
    {
        return (point[0]*point[0] + point[1]*point[1]);
    }
}
