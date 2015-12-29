package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BullsAndCows {

	public static String getHint(String secret, String guess) {
		int countA = 0;
		int countB = 0;
		List<Character> listChars = new ArrayList<>();
		HashSet<Integer> setInd = new HashSet<>();
		if(secret.length() != guess.length()) return null;
		
		for(int i = 0; i < secret.length(); i++){
			if(secret.charAt(i) == guess.charAt(i)){
				countA++;
			}else{
				listChars.add(secret.charAt(i));
				setInd.add(i);
			}
		}
		
		for(int index : setInd){
			if(listChars.contains(guess.charAt(index))){
				Character c = new Character(guess.charAt(index));
				listChars.remove(c);
				countB++;
			}
		}
		return (countA + "A" + countB + "B");
    }
	public static void main(String[] args) {
		System.out.println(getHint("1122", "2211"));

	}

}
