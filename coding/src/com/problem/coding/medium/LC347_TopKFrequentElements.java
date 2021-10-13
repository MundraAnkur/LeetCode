package com.problem.coding.medium;

import java.util.*;

/**
 * @author ankurmundra
 * October 12, 2021
 */
public class LC347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(item -> map.put(item, map.getOrDefault(item, 0) + 1));

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        int i = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (i < k)
            {
                priorityQueue.add(entry);
                i++;
            }
            else {
                priorityQueue.poll();
                priorityQueue.add(entry);
            }
        }
        int[] result = new int[k];
        for (int j = 0; j < k; j++)
            result[j] = priorityQueue.poll().getKey();

        return result;
    }
}
