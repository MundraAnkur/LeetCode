package com.problem.coding.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ankurmundra
 * October 09, 2021
 */
public class LC1216_ValidPalindromeIII {
    static Map<String,Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd",216));
    }

    public static boolean isValidPalindrome(String s, int p)
    {
        int n = s.length();
        int[][] dp = new int[n][n];

        //dp
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n ; j++) {
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i+1][j-1];
                else
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
            }
        }
//        return checkPalindrome(s,0,s.length()-1,p);
        return dp[0][n-1] <= p;
    }

    private static boolean checkPalindrome(String str, int i, int j, int k)
    {
        String key = ""+i+"#"+j+"#"+k;
        if(map.containsKey(key))
            return map.get(key);

        if(i<j)
        {
            boolean result;
            if(k==0)
            {
                result = checkPalindrome(str,i,j);
                map.put(key,result);
                return result;
            }
            if(str.charAt(i)==str.charAt(j))
            {
                result = checkPalindrome(str,i+1,j-1,k);
                map.put(key,result);
                return result;
            }
            result = checkPalindrome(str,i+1,j,k-1) || checkPalindrome(str,i,j-1,k-1);
            map.put(key,result);
            return result;
        }
        map.put(key,true);
        return true;
    }

    private static boolean checkPalindrome(String str, int i, int j)
    {
        while(i<j)
            if(str.charAt(i++)!=str.charAt(j--))
                return false;
        return true;
    }
}
