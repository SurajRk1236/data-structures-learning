package org.learning.dsa.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter355 {
    public static void main(String[] args) {

    }

    class Twitter {

        private static int timestamp = 0;  // Global timestamp to simulate tweet order

        // Tweet class to store tweetId and timestamp
        private static class Tweet {
            int tweetId;
            int time;
            Tweet next;

            public Tweet(int tweetId, int time) {
                this.tweetId = tweetId;
                this.time = time;
                this.next = null;
            }
        }

        // User class to store the user’s information
        private static class User {
            int userId;
            Set<Integer> following;  // The set of users this user is following
            Tweet tweetHead;         // The most recent tweet of this user

            public User(int userId) {
                this.userId = userId;
                this.following = new HashSet<>();
                this.tweetHead = null;
                follow(userId);  // User follows themselves
            }

            public void follow(int followeeId) {
                following.add(followeeId);
            }

            public void unfollow(int followeeId) {
                if (followeeId != this.userId) {
                    following.remove(followeeId);
                }
            }

            public void postTweet(int tweetId) {
                Tweet tweet = new Tweet(tweetId, timestamp++);
                tweet.next = tweetHead;
                tweetHead = tweet;
            }
        }

        private Map<Integer, User> userMap;  // Map to store users by their ID

        public Twitter() {
            userMap = new HashMap<>();
        }

        // If the user doesn’t exist, create a new one
        private User getUser(int userId) {
            userMap.putIfAbsent(userId, new User(userId));
            return userMap.get(userId);
        }

        // Post a tweet
        public void postTweet(int userId, int tweetId) {
            getUser(userId).postTweet(tweetId);
        }

        // Get the 10 most recent tweets
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new ArrayList<>();
            User user = getUser(userId);
            if (user == null) return result;

            // Min-heap to keep the most recent 10 tweets
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

            // Add all the tweets from the user and their followees into the heap
            for (int followeeId : user.following) {
                Tweet tweet = getUser(followeeId).tweetHead;
                if (tweet != null) {
                    pq.offer(tweet);
                }
            }

            // Get the 10 most recent tweets
            while (!pq.isEmpty() && result.size() < 10) {
                Tweet tweet = pq.poll();
                result.add(tweet.tweetId);
                if (tweet.next != null) {
                    pq.offer(tweet.next);
                }
            }

            return result;
        }

        // User follows another user
        public void follow(int followerId, int followeeId) {
            getUser(followerId).follow(followeeId);
        }

        // User unfollows another user
        public void unfollow(int followerId, int followeeId) {
            getUser(followerId).unfollow(followeeId);
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
}
