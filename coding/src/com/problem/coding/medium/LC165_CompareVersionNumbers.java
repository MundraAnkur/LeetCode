package com.problem.coding.medium;

import java.util.Arrays;

/**
 * @author ankurmundra
 * October 04, 2021
 */
public class LC165_CompareVersionNumbers {
    public int compareVersion(String v1, String v2) {
        int[] version1 = Arrays.stream(v1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] version2 = Arrays.stream(v2.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int i = 0, j = 0;
        int a, b;
        while (i<version1.length || j<version2.length)
        {
            a = i >= version1.length ? 0 : version1[i++];
            b = j >= version2.length ? 0 : version2[j++];

            if(a>b)
                return 1;
            if(a<b)
                return -1;
        }

        return 0;
    }
}
