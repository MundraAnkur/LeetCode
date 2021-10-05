package com.problem.coding.medium;

import java.util.Arrays;

/**
 * @author ankurmundra
 * October 04, 2021
 */
public class LC48_RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j]  = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for(int i=0;i< matrix.length;i++)
        {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
