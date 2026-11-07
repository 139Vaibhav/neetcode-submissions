
class Twitter {
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> following;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // Add my own tweets
        if(tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add tweets of people I follow
        Set<Integer> followerList = following.getOrDefault(userId, new HashSet<>());

        for(int x : followerList) {
            if(tweets.containsKey(x)) {
                pq.addAll(tweets.get(x));
            }
        }

        // Get latest 10 tweets
        while(!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
