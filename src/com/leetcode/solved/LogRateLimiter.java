package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class LogRateLimiter {
	/** Initialize your data structure here. */
    Map<String,Integer> logMap;
    public LogRateLimiter() {
        this.logMap = new HashMap<String,Integer>();        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logMap.containsKey(message) || timestamp >= 10 + logMap.get(message)){
            logMap.put(message,timestamp);
            return true;
        }
        return false;
    }
}
