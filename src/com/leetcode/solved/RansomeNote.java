package com.leetcode.solved;

public class RansomeNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine == null || magazine.length() == 0) 
            return (ransomNote == null || ransomNote.length() == 0);
            
        if(magazine.length() < ransomNote.length())return false;
        int array[] = new int[256];
        for(int i = 0; i < magazine.length(); i++) array[magazine.charAt(i)]++;
        for(int i = 0; i < ransomNote.length(); i++) array[ransomNote.charAt(i)]--;
        for(int i = 0; i < array.length; i++) if(array[i] < 0) return false;
        return true;
        
    }

}
