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
		Set<Integer> follows;
		List<Tweet> tweets;
		public User(int userID) {
			super();
			this.userID = userID;
			this.tweets = new ArrayList<Tweet>();
			this.follows = new HashSet<>();
		}
		
		public void postTweet(int tweetID, int clock){
			tweets.add(0,new Tweet(this.userID, tweetID, clock));
		}
	}
	
	public static class Tweet{
		int index;
		int tweetID;
		int clock;
		public Tweet(int index, int tweetID, int clock) {
			super();
			this.index = index;
			this.tweetID = tweetID;
			this.clock = clock;
		}
		
	}
    /** Initialize your data structure here. */
	Map<Integer, User> mapUsers;
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
    public List<Integer> getNewsFeed(int userId) {
        if(!mapUsers.containsKey(userId)) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        
        
        Set<Integer> follows = mapUsers.get(userId).follows;
        Queue<Tweet> top10 = new PriorityQueue<>(10, (a,b) -> Integer.compare(b.clock, a.clock));
        
        List<Integer> folUsers = new ArrayList<>(follows);
        folUsers.add(userId);
        Map<Integer,Integer> usIndex = new HashMap<>();
        IntStream.range(0, folUsers.size()).forEach(i -> usIndex.put(folUsers.get(i),0));
        for(Integer user : folUsers){
        	if(mapUsers.get(user).tweets.size() != 0){
        		top10.add(mapUsers.get(user).tweets.get(usIndex.get(user)));
        		usIndex.put(user,usIndex.get(user)+1);
        	}
        }
        
        while(!top10.isEmpty() && result.size() < 10){
        	Tweet topTw = top10.poll();
        	result.add(topTw.tweetID);
        	if(mapUsers.get(topTw.index).tweets.size() > usIndex.get(topTw.index)){
        		top10.add(mapUsers.get(topTw.index).tweets.get(usIndex.get(topTw.index)));
        		usIndex.put(topTw.index,usIndex.get(topTw.index)+1);
        	}
        }
        return result;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) return;
        if(!mapUsers.containsKey(followerId)) mapUsers.put(followerId, new User(followerId));
        if(!mapUsers.containsKey(followeeId)) mapUsers.put(followeeId, new User(followeeId));
        
        mapUsers.get(followerId).follows.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!mapUsers.containsKey(followeeId) || !mapUsers.containsKey(followerId))return;
    	mapUsers.get(followerId).follows.remove(followeeId);
    }
    
    public static void main(String args[]){
    	Twitter twitter = new Twitter();

    	// User 1 posts a new tweet (id = 5).
    	twitter.postTweet(1, 9);

    	// User 1's news feed should return a list with 1 tweet id -> [5].
    	System.out.println(twitter.getNewsFeed(1));

    	// User 1 follows user 2.
    	twitter.follow(1, 2);

    	// User 2 posts a new tweet (id = 6).
    	twitter.postTweet(2, 15);

    	// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    	// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    	System.out.println(twitter.getNewsFeed(1));;

    	// User 1 unfollows user 2.
    	twitter.unfollow(1, 2);

    	// User 1's news feed should return a list with 1 tweet id -> [5],
    	// since user 1 is no longer following user 2.
    	System.out.println(twitter.getNewsFeed(1));;
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