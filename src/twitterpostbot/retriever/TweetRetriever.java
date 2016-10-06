/*
 * 
 */
package twitterpostbot.retriever;

import java.util.List;
import twitterpostbot.storage.Tweet;
import twitterpostbot.storage.User;

/**
 *
 * @author barnsbarn
 */
public interface TweetRetriever {
    
    public List<Tweet> getLastestTweets(User user, int numberOfTweets);
    
}
