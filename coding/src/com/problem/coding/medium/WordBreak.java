package com.problem.coding.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ankurmundra
 * October 02, 2021
 */
public class WordBreak {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Apple","Pen"));
        System.out.println(wordBreak("ApplePenTomApple",list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict) {
            if(s.length()>0 && s.contains(word))
                s = s.replace(word,"");
            else
                return false;
        }
        return s.length()==0;
    }
}
