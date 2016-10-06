/*
 * 
 */
package twitterpostbot;

/**
 *
 * @author barnsbarn
 */
public class TwitterBank {
    
    public static void main(String[] args) 
    {
        TwitterBankImpl.getInstance().getTweetStorage().getUsers().stream().map((user) -> new TwitterPostBot(user)).forEach((twitterBot) -> {
            twitterBot.run();
        });
    }
    
}
