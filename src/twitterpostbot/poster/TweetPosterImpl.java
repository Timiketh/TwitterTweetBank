/*
 */
package twitterpostbot.poster;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;
import twitter4j.conf.ConfigurationBuilder;
import twitterpostbot.storage.Tweet;

/**
 *
 * @author barnsbarn
 */
public class TweetPosterImpl implements TweetPoster {


    @Override
    public boolean postNewTweet(Tweet tweet) {
        try {            
            ConfigurationBuilder cb = new ConfigurationBuilder().setOAuthConsumerKey(tweet.getUser().getConsumerKey()).setOAuthConsumerSecret(tweet.getUser().getConsumerSecret()).setOAuthAccessToken(tweet.getUser().getAccesToken()).setOAuthAccessTokenSecret(tweet.getUser().getAccesTokenSecret());
            Twitter twitter = new TwitterFactory(cb.build()).getInstance();
            if (tweet.getMedias() == null)
            {
                Status status = twitter.updateStatus(tweet.getMessage());
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Tweet succesfully posted for user {0}. Message was : {1}", new Object[]{tweet.getUser().getUsername(), tweet.getMessage()});
                return true;
            }
            else
            {
                long[] mediaIds = new long[tweet.getMedias().length];
                for (int i = 0; i < tweet.getMedias().length; i++) {
                    UploadedMedia media = twitter.uploadMedia((tweet.getMedias()[i]));
                    mediaIds[i] = media.getMediaId();
                }
                StatusUpdate update = new StatusUpdate(tweet.getMessage());
                update.setMediaIds(mediaIds);
                Status status = twitter.updateStatus(update);
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Tweet succesfully posted for user {0}. Message was : {1} with {2} files.", new Object[]{tweet.getUser().getUsername(), tweet.getMessage(), tweet.getMedias().length});
                return true;
            }
        } catch (TwitterException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error trying to post new tweet!");
            return false;
        }
    }
    
    
    
}
