package com.problem.coding.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankurmundra
 * October 09, 2021
 */
public class LC763_PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> list = new ArrayList<>();
        int current;

        for (int i = 0; i < s.length() ; i++)
            lastIndex[s.charAt(i) -'a'] =  i;

        for (int i = 0; i < s.length(); ) {
            current = lastIndex[s.charAt(i) -'a'];
            int index = i+1;
            while (index<current)
            {
                int lIndex = lastIndex[s.charAt(index++)-'a'];
                if(lIndex > current)
                    current = lIndex;
            }
            list.add(current+1-i);
            i = current+1;
        }
        return list;
    }
}
