/*
 */
package twitterpostbot.poster;

import twitterpostbot.storage.Tweet;

/**
 *
 * @author barnsbarn
 */
public interface TweetPoster {
    
    public boolean postNewTweet(Tweet tweet);
    
}
