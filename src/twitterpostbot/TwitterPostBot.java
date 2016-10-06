/*
 */
package twitterpostbot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitterpostbot.storage.Tweet;
import twitterpostbot.storage.User;

/**
 *
 * @author barnsbarn
 */
public class TwitterPostBot implements Runnable {

    private User user = null;
    
    /**
     * Bot that will handle the specified user.
     * @param user 
     */
    public TwitterPostBot(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        List<Tweet> bankedTweets = TwitterBankImpl.getInstance().getTweetStorage().getBankedTweetsForUser(user);
        int randomTweet = ThreadLocalRandom.current().nextInt(bankedTweets.size());
        Tweet toSend = bankedTweets.get(randomTweet);
        if(TwitterBankImpl.getInstance().getTweetPoster().postNewTweet(toSend))
        {
            TwitterBankImpl.getInstance().getTweetStorage().deleteTweet(toSend);
        }
        try {
            long sleepingTime = TwitterPostBotSettings.getInstance().getTimeInMillisMin() + ThreadLocalRandom.current().nextLong(TwitterPostBotSettings.getInstance().getTimeInMillisRange());
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Putting Thread for user : {0} to sleep for "+String.valueOf(sleepingTime)+" milliseconds", user.getUsername());            
            Thread.sleep(sleepingTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(TwitterPostBot.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Thread for user : {0} was unable to sleep the full duration...", user.getUsername());
        }
    }
    
    
}
