/*
 * 
 */
package twitterpostbot;

import twitterpostbot.poster.TweetPoster;
import twitterpostbot.poster.TweetPosterImpl;
import twitterpostbot.retriever.TweetRetriever;
import twitterpostbot.retriever.TweetRetrieverImpl;
import twitterpostbot.storage.TweetStorage;
import twitterpostbot.storage.file.FileTweetStorage;

/**
 *
 * @author barnsbarn
 */
public class TwitterBankImpl {
    
    private TweetStorage tweetStorage = null;
    
    private TweetPoster tweetPoster = null;
    
    private TweetRetriever tweetRetriever = null;
    
    private TwitterBankImpl() {
        tweetStorage = new FileTweetStorage();
        tweetPoster = new TweetPosterImpl();
        tweetRetriever = new TweetRetrieverImpl();
    }
    
    public static TwitterBankImpl getInstance() {
        return TwitterBankImplHolder.INSTANCE;
    }
    
    private static class TwitterBankImplHolder {

        private static final TwitterBankImpl INSTANCE = new TwitterBankImpl();
    }
    
    public TweetStorage getTweetStorage()
    {
        return tweetStorage;
    }
    
    public TweetPoster getTweetPoster()
    {
        return tweetPoster;
    }
    
    public TweetRetriever getTweetRetriever()
    {
        return tweetRetriever;
    }
}
