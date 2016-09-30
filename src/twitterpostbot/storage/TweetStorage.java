/*
 */
package twitterpostbot.storage;

import java.util.List;

/**
 *
 * @author barnsbarn
 */
public interface TweetStorage {
    
    public abstract List<Tweet> getBankedTweets();
    
}
