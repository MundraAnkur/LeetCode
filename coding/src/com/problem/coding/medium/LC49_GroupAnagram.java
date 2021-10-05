package com.problem.coding.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankurmundra
 * October 04, 2021
 */
public class LC49_GroupAnagram {

    public static void main(String[] args) {
        char ch = 1+'a';
        System.out.println(ch);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(List.of(strs[0])));
        boolean flag;

        for(int i=1;i<strs.length;i++)
        {
            flag = false;
            for(List<String> list : lists)
            {
                if(isAnagram(list.get(0),strs[i]))
                {
                    list.add(strs[i]);
                    flag = true;
                    break;
                }
            }
            if(!flag)
                lists.add(new ArrayList<>(List.of(strs[i])));
        }
        return lists;
    }

    private boolean isAnagram(String str1, String str2)
    {
        if(str1.length()!=str2.length())
            return false;

        int[] arr = new int[26];
        for(int i=0;i<str1.length();i++)
        {
            arr[str1.charAt(i) - 'a']++;
            arr[str2.charAt(i) - 'a']--;
        }

        for(int item: arr)
            if(item != 0)
                return false;
        return true;
    }
}
