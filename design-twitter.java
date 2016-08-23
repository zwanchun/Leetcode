/*Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

*/

public class Twitter {
    
    List<Tweet> twitter_list;
    Map<Integer, Set<Integer>> follow;
    

    /** Initialize your data structure here. */
    public Twitter() {
        twitter_list=new ArrayList<Tweet>();
        follow=new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        twitter_list.add(new Tweet(userId,tweetId));
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> rst=new ArrayList<Integer>();
        for(int i=twitter_list.size()-1;i>=0 && rst.size()<10;i--){
            Tweet temp=twitter_list.get(i);
            if(temp.userid==userId||(follow.containsKey(userId)&&follow.get(userId).contains(temp.userid))){
                rst.add(temp.tweetid);
            }
        }
        return rst;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)){
            follow.put(followerId,new HashSet<Integer>());
        }
        follow.get(followerId).add(followeeId);
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)) return;
        follow.get(followerId).remove(followeeId);
        
    }
    
    private class Tweet{
        
        int userid;
        int tweetid;
        
        public Tweet(int userid, int tweetid){
            this.userid=userid;
            this.tweetid=tweetid;
        }
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
