package com.problem.coding.medium;

public class TribonacciNumber {

    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        int temp;
        if(n==0)
            return 0;

        for (int i = 3; i <= n; i++) {
            temp = a+b+c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
