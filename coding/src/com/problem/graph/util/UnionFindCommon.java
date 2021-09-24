package com.problem.graph.util;

import java.util.Arrays;

public class UnionFindCommon {
    private final int[] root;
    private final int[] rank;

    public UnionFindCommon(int n) {
        root = new int[n];
        rank = new int[n];  //height of tree

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int item) {
        if(item ==root[item])
            return item;
        return root[item] = find(root[item]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            if(rank[rootX]>rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootY]>rank[rootX])
                root[rootX] = rootY;
            else
            {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean isConnected(int x, int y)
    {
        System.out.println(Arrays.toString(root));
        return find(x)==find(y);
    }
}
