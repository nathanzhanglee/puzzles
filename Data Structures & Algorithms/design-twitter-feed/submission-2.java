class Twitter {
    HashMap<Integer, HashSet<Integer>> userFollowings;
    HashMap<Integer, HashSet<int[]>> userPosts;
    int time;
    public Twitter() {
        userFollowings = new HashMap<>();
        userPosts = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userPosts.containsKey(userId)) {
            userPosts.put(userId, new HashSet<>());
        }
        userPosts.get(userId).add(new int[] {tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        if (!userFollowings.containsKey(userId)) {
            userFollowings.put(userId, new HashSet<>());
        }
        userFollowings.get(userId).add(userId);
        for (int following : userFollowings.get(userId)) {
            for (int[] post : userPosts.get(following)) {
                if (minHeap.size() >= 10) {
                    if (minHeap.peek()[1] < post[1]) {
                        minHeap.poll();
                        minHeap.offer(post);
                    }
                } else {
                    minHeap.offer(post);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll()[0]);
        }
        Collections.reverse(result);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowings.get(followerId).remove(followeeId);
    }
}
