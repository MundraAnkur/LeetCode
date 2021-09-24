package com.problem.graph;

import com.problem.graph.util.UnionFindCommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0,3)));
        pairs.add(new ArrayList<>(Arrays.asList(1,2)));
        pairs.add(new ArrayList<>(Arrays.asList(0,2)));
        System.out.println(smallestStringWithSwaps("dcab",pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFindCommon uf = new UnionFindCommon(s.length());

        for (List<Integer> pair : pairs)
            uf.union(pair.get(0), pair.get(1));

        char[] str = s.toCharArray();
        pairs.clear();

        // group indexes that are connected
        for (int i = 0; i < str.length; i++) {
            int root = uf.find(i);

            if(pairs.size()<=root)
                pairs.add(new ArrayList<>());
            pairs.get(root).add(i);
        }

        // each connected pairs can get swapped to make sorted string
        for (List<Integer> pair: pairs) {
            char[] subArr = new char[pair.size()];

            for (int i = 0; i < subArr.length; i++)
                subArr[i] = str[pair.get(i)];

            Arrays.sort(subArr);

            for (int i = 0; i < subArr.length; i++)
                str[pair.get(i)] = subArr[i];
        }

        return String.valueOf(str);
    }
}
