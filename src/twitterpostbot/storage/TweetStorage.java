/*
 */
package twitterpostbot.storage;

import java.util.List;

/**
 *
 * @author barnsbarn
 */
public interface TweetStorage {
    
    public List<Tweet> getBankedTweetsForUser(User user);
    
    public List<User> getUsers();
    
    public void deleteTweet(Tweet tweet);
    
}
