package com.problem.coding.medium;

import java.util.*;

/**
 * @author ankurmundra
 * October 02, 2021
 */
public class LC12_IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }

    public static String intToRoman(int num) {
        TreeMap<Integer,String> map = new TreeMap<>(Map.of(1, "I", 5, "V", 10, "X",
                50, "L", 100, "C", 500, "D", 1000, "M",
                900, "CM", 400, "CD", 90, "XC"));
        map.put(40,"XL");
        map.put(9,"IX");
        map.put(4,"IV");

        List<Integer> list = getParts(num);
        StringBuilder result = new StringBuilder();

        for (int i = list.size()-1; i >=0 ; i--) {
            int n = list.get(i);
            if(map.containsKey(n))
                result.append(map.get(n));
            else
                while (n != 0) {
                    result.append(map.floorEntry(n).getValue());
                    n = n - map.floorKey(n);
                }
        }
        return result.toString();

    }

    private static List<Integer> getParts(int num)
    {
        List<Integer> list = new ArrayList<>();
        int multiplier = 1;
        while (num!=0)
        {
            list.add((num%10)*multiplier);
            num = num/10;
            multiplier = multiplier*10;
        }
        return list;
    }
}
