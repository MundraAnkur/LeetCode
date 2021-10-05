package com.problem.coding.medium;

/**
 * @author ankurmundra
 * October 02, 2021
 */
public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0)
            return  0;
        int multiplier = 1;
        int index = 0, result = 0;
        if(s.charAt(index)=='-')
        {
            multiplier = -1;
            index++;
        }
        else if(s.charAt(index)=='+')
            index++;

        while (index < s.length())
        {
            int val = (s.charAt(index) - '0');
            if(multiplier==1 && (result > Integer.MAX_VALUE/10 ||
                    (result == Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10 < val)))
                return Integer.MAX_VALUE;
            else if((result + Integer.MIN_VALUE/10)> 0 ||
                    (result+ Integer.MIN_VALUE/10 == 0 && val+Integer.MIN_VALUE%10>0))
                return Integer.MIN_VALUE;

            result = result*10 + val;
            index++;
        }
        return multiplier*result;
    }

}
