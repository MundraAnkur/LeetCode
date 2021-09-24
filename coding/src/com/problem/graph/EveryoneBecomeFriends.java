package com.problem.graph;

import java.util.Arrays;
import java.util.Comparator;

public class EveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        UnionFind unionFind = new UnionFind(n);

        for (int[] log : logs) {
            if (unionFind.union(log[1], log[2]) == 1)
                return log[0];
        }
        return -1;
    }
}

class UnionFind {
    private final int[] root;
    private final int[] rank;
    private int unConnected;

    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];  //height of tree
        unConnected = n;

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if (rank[rootY] > rank[rootX])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            unConnected--;
        }
        return unConnected;
    }
}
