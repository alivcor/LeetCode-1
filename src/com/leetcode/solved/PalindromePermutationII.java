package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {
private char[] countCharacters(String s){
        
        char[] charcount = new char[256];
        for(int i = 0; i < s.length(); i++) charcount[s.charAt(i)]++;
        int countOdd = 0;
        for(int i = 0; i < charcount.length; i++) if(charcount[i]%2 == 1) countOdd++;
        
        return (countOdd > 1) ? null : charcount;
    }
    public List<String> generatePalindromes(String s) {
        if(s == null) return null;
        char[] charcount = countCharacters(s);
        
        if(charcount == null) return new ArrayList<String>();
        
        String sb = "";
        for(int i = 0; i < charcount.length; i++){
            if(charcount[i]%2 == 1) {
                sb = (char)(i) + "";
                charcount[i]--;
            }
        }
        
        List<String> result = new ArrayList<>();
        getPalin(sb,charcount,result);
        return result;
    }
    
    private void getPalin(String sb, char[] charcount, List<String> result){
        
        boolean isEmpty = true;
        for(int i = 0; i < charcount.length; i++){
            if(charcount[i] > 0){
                isEmpty = false;
                char c = (char)(i);
                charcount[i] -= 2;
                getPalin(c + sb + c, charcount, result);
                charcount[i] += 2;
            }
        }
        if(isEmpty){
            result.add(sb);
        }
    }
}
