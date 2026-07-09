class Twitter {

    List<int[]> globalTweets;
    Map<Integer, Set<Integer>> map;

    public Twitter() {
        globalTweets = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        globalTweets.add(new int[] {userId, tweetId});
        map.putIfAbsent(userId, new HashSet<>());
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        for (int i = globalTweets.size() - 1; i >= 0; i--) {
            if (result.size() >= 10)    break;

            int[] u = globalTweets.get(i);
            if (u[0] == userId || map.get(userId).contains(u[0])) {
                result.add(u[1]);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        map.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        map.get(followerId).remove(followeeId);
    }
}
