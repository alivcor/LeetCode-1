package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class Twitter {

public static class User{
		int userID;
		Set<Integer> userIFollow;
		List<Tweet> myTweets;
		public User(int userID) {
			this.userID = userID;
			this.myTweets = new ArrayList<Tweet>();
			this.userIFollow = new HashSet<>();
		}
		
		/**Always add tweet to the zeroth position.
		 * Since we need a maximum of 10 tweets in the news feed. Remove others.
		 */
		public void postTweet(int tweetID, int clock){
			if(this.myTweets.size() == 10) myTweets.remove(9);
			myTweets.add(0,new Tweet(this.userID, tweetID, clock));
		}
	}
	
	public static class Tweet{
		int user;
		int tweetID;
		int clock;
		public Tweet(int user, int tweetID, int clock) {
			super();
			this.user = user;
			this.tweetID = tweetID;
			this.clock = clock;
		}
		
	}
    /** Initialize your data structure here. */
	//Map userID vs User
	Map<Integer, User> mapUsers;
	//Time each tweet arrives
	int clock;
    public Twitter() {
    	mapUsers = new HashMap<>();
    	clock = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!mapUsers.containsKey(userId)) mapUsers.put(userId, new User(userId));
        mapUsers.get(userId).postTweet(tweetId, this.clock++);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    /**Work similar to merge K sorted list and stop when result size == 10.
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId) {
        if(!mapUsers.containsKey(userId)) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        List<Integer> folUsers = new ArrayList<>(mapUsers.get(userId).userIFollow);
        folUsers.add(userId);
        
        Queue<Tweet> top10 = new PriorityQueue<>(10, (a,b) -> Integer.compare(b.clock, a.clock));
        Map<Integer,Integer> usIndex = new HashMap<>();
        IntStream.range(0, folUsers.size()).forEach(i -> usIndex.put(folUsers.get(i),0));
        
        for(Integer user : folUsers){
        	if(mapUsers.get(user).myTweets.size() != 0){
        		top10.add(mapUsers.get(user).myTweets.get(usIndex.get(user)));
        		usIndex.put(user,usIndex.get(user)+1);
        	}
        }
        
        while(!top10.isEmpty() && result.size() < 10){
        	Tweet topTw = top10.poll();
        	result.add(topTw.tweetID);
        	if(mapUsers.get(topTw.user).myTweets.size() > usIndex.get(topTw.user)){
        		top10.add(mapUsers.get(topTw.user).myTweets.get(usIndex.get(topTw.user)));
        		usIndex.put(topTw.user,usIndex.get(topTw.user)+1);
        	}
        }
        return result;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) return;
        if(!mapUsers.containsKey(followerId)) mapUsers.put(followerId, new User(followerId));
        if(!mapUsers.containsKey(followeeId)) mapUsers.put(followeeId, new User(followeeId));
        
        mapUsers.get(followerId).userIFollow.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!mapUsers.containsKey(followeeId) || !mapUsers.containsKey(followerId))return;
    	mapUsers.get(followerId).userIFollow.remove(followeeId);
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */