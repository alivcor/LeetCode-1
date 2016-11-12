package com.leetcode.solved;

public class ID440_KthSmallestInLexographicalOrder {
	
	 /*
    https://discuss.leetcode.com/topic/64624/concise-easy-to-understand-java-5ms-solution-with-explaination
    Assume this as a 10-ary tree.
Main function
    Firstly, calculate how many steps curr need to move to curr + 1.
    if the steps <= k, we know we can move to curr + 1, and narrow down k to k - steps.
    else if the steps > k, that means the curr + 1 is actually behind the target node x in the preorder path, we can't jump to curr + 1. What we have to do is to move forward only 1 step (curr * 10 is always next preorder node) and repeat the iteration.

calSteps function

    how to calculate the steps between curr and curr + 1?
    Let n1 = curr, n2 = curr + 1.
    n2 is always the next right node beside n1's right most node (who shares the same ancestor "curr")
    (2 is right next to 1, 20 is right next to 19, 200 is right next to 199).
    
    so, if n2 <= n, what means n1's right most node exists, we can simply add the number of nodes from n1 to n2 to steps.
    else if n2 > n, what means n (the biggest node) is on the path between n1 to n2, add (n + 1 - n1) to steps.
    
    organize this flow to "steps += Math.min(n + 1, n2) - n1; n1 *= 10; n2 *= 10;"
    */
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        while(k > 0){
            int steps = calculateStepSize(n, curr, curr + 1);
            if(steps <= k){
                k -= steps;
                curr++;
            }else{
                curr *= 10;
                k -= 1;
            }
        }
        
        return curr;
    }
    /*
    This function finds all the values between subtrees.
    Example we are at 1 digit, so the total count of numbers in subtree of 1. 
    But if at any point the n2 value passes the N, we stop.
    */
    private int calculateStepSize(int N, long n1, long n2){
        int steps = 0;
        while(n1 <= N){
            steps += Math.min(N + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
