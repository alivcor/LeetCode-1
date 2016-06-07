package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RussianDollEnvelopes {
	public static class Envelopes{
		Integer w;
		Integer l;
		public Envelopes(Integer w, Integer l) {
			super();
			this.w = w;
			this.l = l;
		}
	}
	public static int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0) return 0;
		List<Envelopes> listEnv = new ArrayList<>();
		IntStream.range(0, envelopes.length).
		forEach(i -> listEnv.add(new Envelopes(envelopes[i][0], envelopes[i][1])));
		Collections.sort(listEnv, (a,b) -> a.l.compareTo(b.l));
		int[] result = new int[listEnv.size()];
		for(int i = 1; i < listEnv.size(); i++){
			for(int j = 0; j < i; j++){
				if(listEnv.get(i).w > listEnv.get(j).w && listEnv.get(i).l > listEnv.get(j).l)
					result[i] = Integer.max(result[i], 1 + result[j]);
			}
		}
		return Arrays.stream(result).max().getAsInt()+1;
    }

	public static void main(String[] args) {
		int env[][] = {{5,4},{6,4}};
		System.out.println(maxEnvelopes(env));
	}

}
