package leetcode._355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {

    HashMap<Integer, User> users = new HashMap();
    int time;
    class User {
        int id;
        Set<Integer> followings;
        Tweet head;
        User(int id) {
            this.id = id;
            followings = new HashSet();
        }
    }
    class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        User u = users.get(userId);
        if (u == null) {
            u = new User(userId);
        }

        Tweet t = u.head;
        u.head = new Tweet(tweetId, time++);
        u.head.next = t;

        users.put(userId, u);
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = users.get(userId);
        if (user == null) {
            return new ArrayList();
        }

        Set<Integer> s = new HashSet();
        s.add(userId);
        s.addAll(user.followings);

        Set<User> us = new HashSet();
        for(int u : s) {
            user = users.get(u);
            if (user != null) {
                us.add(user);
            }
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);
        for(User u : us) {
            if(u.head != null) {
                pq.add(u.head);
            }
        }
        List<Integer> ts = new ArrayList();
        int n = 0;
        while(!pq.isEmpty() && n++ < 10) {
            Tweet t = pq.poll();
            ts.add(t.id);
            if(t.next != null) {
                pq.add(t.next);
            }
        }
        return ts;
    }

    public void follow(int followerId, int followeeId) {
        User u = users.get(followerId);
        if (u == null) {
            u = new User(followerId);
        }

        users.put(followerId, u);
        u.followings.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User u = users.get(followerId);
        if (u == null) {
            return;
        }
        u.followings.remove(followeeId);
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