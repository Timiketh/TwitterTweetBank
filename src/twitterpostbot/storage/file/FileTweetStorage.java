/*
 * 
 */
package twitterpostbot.storage.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitterpostbot.storage.Tweet;
import twitterpostbot.storage.TweetStorage;
import twitterpostbot.storage.User;

/**
 *
 * @author barnsbarn
 */
public class FileTweetStorage implements TweetStorage {

    @Override
    public List<Tweet> getBankedTweets() {
        List<User> users = getUsers();
        
        return null;
    }
    
    
    /**
     * Get the list of all the registered Users for this applications.
     * @return List of all registered Users.
     */
    private List<User> getUsers()
    {
        File storage = new File(FileStorageConfiguration.PATH_TO_STORAGE_FOLDER);
        List<User> users = new ArrayList<>();
        for (File usernameFolder : storage.listFiles())
        {
            if (usernameFolder.isDirectory())
            {
                User user = loadUserFile(usernameFolder);
                if (null != user)
                {
                    users.add(user);
                }
            }
        }
        return users;
    }
    
    /**
     * Return a User from the specified folder.
     * @param userFolder the folder of the user.
     * @return the User associated with the folder.
     */
    private User loadUserFile(File userFolder)
    {
        File userFile = new File(userFolder, FileStorageConfiguration.USER_FILE);
        User user = parseUserFile(userFile);
        if (user != null)
        {
            user.setUsername(userFolder.getName());
        }
        return user;
    }
    
    /**
     * Returns the User with specified information from the file.
     * @param userFile the file containing the user information.
     * @return User built from the file.
     */
    private User parseUserFile(File userFile)
    {
        User user = null;
        try {
            FileReader fr = new FileReader(userFile);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            String ck = null;
            String cs = null;
            String at = null;
            String ats = null;
            int index = 0;
            while ((line = reader.readLine()) != null)
            {
                switch(index)
                {
                    case (0) : ck = line; break;
                    case (1) : cs = line; break;
                    case (2) : at = line; break;
                    case (3) : ats = line; break;
                }
            }
            if (ck != null && cs != null && at != null && ats != null)
            {
                user = new User();
                user.setConsumerKey(ck);
                user.setConsumerSecret(cs);
                user.setAccesToken(at);
                user.setAccesTokenSecret(ats);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTweetStorage.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "File information [{0}] was not found!", userFile.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(FileTweetStorage.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "There was a problem reading file [{0}]!", userFile.getAbsolutePath());
        }
        return user;
    }
}
