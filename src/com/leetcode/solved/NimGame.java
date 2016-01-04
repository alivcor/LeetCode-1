

package com.leetcode.solved;

public class NimGame {
/*
 * Given:
 * The person picking last coin would win. We can pick any count between 1, 2 and 3.
 * 
 * Solution:
 * If N is 4, any count we pick, opponent would pick rest of the remaining to win.
 * Any multiple of 4 can be reduced in such a way to 4.
 * So if N is a multiple of 4, player 1 can never win.
 * 
 * If N is not a multiple of 4, it would be 4k+1, 4k+2, 4k+3.
 * Player 1 can reduce this to a multiple of 4, and would land at above situation.
 * Now Player 2 is stuck with a number which is multiple of 4 thus loosing.
 */
	public boolean canWinNim(int n) {
        return !(n%4 == 0);
    }
}
