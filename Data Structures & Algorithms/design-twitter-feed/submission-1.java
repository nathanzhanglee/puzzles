class Twitter {
    // map of Integer to HashSet<Intger> user to Followings
    // minHeap of [time, userID, tweetId] (sort by time)
    int time;
    HashMap<Integer, HashSet<Integer>> followings;
    Queue<int[]> minHeap;
    public Twitter() {
        time = 0;
        followings = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    }
    
    public void postTweet(int userId, int tweetId) {
        minHeap.add(new int[] {time, userId, tweetId});
        follow(userId, userId);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (followings.getOrDefault(userId, new HashSet<>()).size() == 0) {
            return new ArrayList<>();
        }
        HashSet<Integer> follows = followings.get(userId);
        List<Integer> result = new ArrayList<>();
        HashSet<int[]> removed = new HashSet<>();
        while (!minHeap.isEmpty() && result.size() < 10) {
            int[] tweet = minHeap.poll();
            removed.add(tweet);
            if (follows.contains(tweet[1])) {
                result.add(tweet[2]);
            }
        }
        for (int[] tweet : removed) {
            minHeap.offer(tweet);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = followings.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followings.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followings.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        HashSet<Integer> set = followings.get(followerId);
        set.remove(followeeId);
        followings.put(followerId, set);
    }
}
