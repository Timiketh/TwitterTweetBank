/*
 * 
 */
package twitterpostbot.storage;

import java.io.File;

/**
 *
 * @author barnsbarn
 */
public class Tweet {
    
    private File[] medias = null;
    private String message = "";
    private User user = null;
    
    public Tweet(User user, String message, File... medias)
    {
        this.user = user;
        this.message = message;
        this.medias = medias;
    }
    
}
