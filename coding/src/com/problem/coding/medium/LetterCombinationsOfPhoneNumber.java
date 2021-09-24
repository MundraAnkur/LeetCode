package com.problem.coding.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        String s = map.get(digits.charAt(0));

        for (int i = 0; i < s.length(); i++)
            result.add(String.valueOf(s.charAt(i)));

        for (int i = 1; i < digits.length(); i++) {
            String s1 = map.get(digits.charAt(i));
            tempList.clear();
            tempList.addAll(result);
            result.clear();
            for (int j = 0; j < s1.length(); j++) {
                char ch = s1.charAt(j);
                for (String temp : tempList)
                    result.add(temp + ch);
            }
        }
        return result;
    }

}
