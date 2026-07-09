class Twitter {
    
    Map<Integer, Set<Integer>> map;
    Map<Integer, List<int []>> tweet;
    int count;

    public Twitter() {
        map = new HashMap<>();
        tweet = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        count++;
        map.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        tweet.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int []> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int u : map.getOrDefault(userId, new HashSet<>())) {
            List<int []> tweets = tweet.get(u);
            int i = tweets.size() - 1;
            int c = 10;
            while (i >= 0 && c > 0) {
                heap.offer(tweets.get(i));
                i--;
                c--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int c = 0;
        while (!heap.isEmpty() && c < 10) {
            ans.add(heap.poll()[1]);
            c++;
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        map.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId)
            map.get(followerId).remove(followeeId);
    }
}

// 1 -> [(1, tweetId), (2, tweetId)] List
// 2 -> [(3, tweetId)] List

// 1 -> [2]

// Heap -> 10
