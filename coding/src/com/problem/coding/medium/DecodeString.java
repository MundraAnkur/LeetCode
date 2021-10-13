package com.problem.coding.medium;

import java.util.Stack;

/**
 * @author ankurmundra
 * September 29, 2021
 */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
//        System.out.println(Character.getNumericValue('b'));
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        stack.push(String.valueOf(s.charAt(s.length()-1)));

        int index = s.length()-2;
        String res;
        while (index>=0)
        {
            char ch = s.charAt(index--);
            if(ch=='[')
            {
                res = "";
                while (!stack.peek().equals("]"))
                    res += stack.pop();
                stack.pop();

                ch = s.charAt(index);
                String factor = "";
                while (index>=0 && Character.isDigit(ch))
                {
                    factor = ch+factor;
                    index--;
                    if(index>=0)
                        ch = s.charAt(index);
                }
                res = res.repeat(Integer.parseInt(factor));
                stack.push(res);
            }
            else
                stack.push(String.valueOf(ch));
        }

        res = "";
        while (!stack.isEmpty())
            res = res + stack.pop();
        return res;
    }

    private static int getMultiplicationFactor(int index, String str)
    {
        int len = 0;
        int a,b,c;
        int count = 0;
        while (count<3 && index>=0)
        {
            char ch = str.charAt(index--);

        }

        return 1;
    }
}
