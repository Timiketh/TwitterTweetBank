/*
 * 
 */
package twitterpostbot.storage.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import twitterpostbot.TwitterBankImpl;
import twitterpostbot.storage.Tweet;
import twitterpostbot.storage.User;

/**
 *
 * @author barnsbarn
 */
public class FileTweetStorageTest {
    
    public FileTweetStorageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetUsers() throws IOException
    {
        List<User> users = TwitterBankImpl.getInstance().getTweetStorage().getUsers();
        assertEquals("Expected number of users was 2, but is in fact "+users.size(), users.size(), 2);
        if (users.get(0).getUsername().equals("BarnaqueJeux"))
        {
            assertEquals("First expected user was BarnaqueJeux, but instead was "+users.get(0).getUsername(), "BarnaqueJeux", users.get(0).getUsername());
            assertEquals("Second expected user was EmericMorin, but instead was "+users.get(1).getUsername(), "EmericMorin", users.get(1).getUsername());         
        }
        else
        {
            assertEquals("First expected user was EmericMorin, but instead was "+users.get(0).getUsername(), "EmericMorin", users.get(0).getUsername());
            assertEquals("Second expected user was BarnaqueJeux, but instead was "+users.get(1).getUsername(), "BarnaqueJeux", users.get(1).getUsername());
        }
    }
    
    @Test
    public void getTweetsForUser()
    {
        List<User> users = TwitterBankImpl.getInstance().getTweetStorage().getUsers();
        User testUser = null;
        for (User user : users)
        {
            if (user.getUsername().equals("EmericMorin"))
            {
                testUser = user;
                break;
            }
        }
        List<Tweet> bankedTweets = TwitterBankImpl.getInstance().getTweetStorage().getBankedTweetsForUser(testUser);
        assertEquals("Expected 3 tweets, but got this many : "+bankedTweets.size(), 3, bankedTweets.size());
        for(Tweet tweet : bankedTweets)
        {
            System.out.println(tweet.getMessage());
            if (tweet.getMedias() != null)
            {
                for (File file : tweet.getMedias())
                {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
