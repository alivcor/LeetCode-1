package com.leetcode.solved;

public class ID458_PoorPigs {
	 /*
    https://discuss.leetcode.com/topic/66856/major-flaw-in-current-algorithm-fixed
    
    Assume for now we have: [buckets, 15, 60]
    Per pig, we have 5 states that we can detect: death on 15, 30, 45, 60, or life.

    Assume for the moment we have 5 buckets and one pig with the above timings. Represent each bucket as an integer in base 5 (0-indexed).

    Pig drinks from bucket 0 at 0 minutes, bucket 1 at time 15 etc...
    If the pig is still alive, by elimination, we know that bucket 4 would be poisonous.

    We now increase the number of buckets to 25, we have ceil(log_5(25)) = 2 pigs
    Bucket 25 is labelled 44, bucket 1 is labelled 00.
    At time t, have the first pig drink from the buckets where the first digit is t, have the second pig drink when the second digit is t. As each pig represents a single digit in base 5, and 25 consists of two base 5 digits, two pigs are necessary. We can determine the value of each digit based on the time of death of each pig. An overlap of the death of two pigs gives us the information of two digits, so nothing is lost.

    Example: 18 is poisonous (33 in base 5).

    On t=3, one pig is drinking [15,16,17,18,19] and the other is drinking [3,8,13,18,23]. We can see that if both die, the intersection of the sets yields 18.

    Given the default input: 1000, 15, 60

    The above yields the minimum number of pigs = ceil(log_5(1000)) = 5 pigs.
    */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets-- == 0) return 0;
        int base = minutesToTest/minutesToDie + 1;
        int count = 0;
        while(buckets > 0){
            buckets /= base;
            count++;
        }
        return count;        
    }

}
