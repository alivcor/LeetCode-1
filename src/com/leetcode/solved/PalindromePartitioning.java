package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/*
    1. Start from one end, consider each character as center(for odd) and center-1 for even.
    2. Recurse if Palindrome.
    */
    public List<List<String>> partition(String s) {
        char array[] = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            array[i] = s.charAt(i);
        }
        
        return partition(array,0,array.length-1);
    }
    
    public static boolean isPalindrome(char[] s, int start, int end){
        while(end > start){
            if(s[start] != s[end]) return false;
            start++; 
            end--;
        }
        
        return true;
        
    }
    private static void appendValue(List<List<String>> result, char[] array, int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++){
            sb.append(array[i]);
        }
        String s = sb.toString();
        if(result.size() == 0){
            List<String> resultList = new ArrayList<String>();
            resultList.add(s);
            result.add(resultList);
            return;
        } 
        for(List<String> list : result){
            list.add(0,s);
        }
        return;
    }
    public static List<List<String>> partition(char[] s, int start, int end){
        List<String> result = new ArrayList<String>();
        List<List<String>> resultSet = new ArrayList<List<String>>();
        if(start > end) return resultSet;
        if(start == end){
            result.add(s[start] + "");
            resultSet.add(result);
            return resultSet;
        }
        
        for(int i = start; i <= end; i++){
            if(isPalindrome(s, start, i)){
               List<List<String>> set = partition(s, i + 1, end);
               appendValue(set, s, start, i);
               resultSet.addAll(set);
            }
        }
        
        return resultSet;
        
    }
}
