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

/**
 *
 * @author barnsbarn
 */
public class FileTweetParser {
    
    private File toParse = null;
    
    private static final String MESSAGE_TOKEN = "message:";
    
    private static final String MEDIA_TOKEN = "media:";
    
    public FileTweetParser(File tweetFile)
    {
        this.toParse = tweetFile;
    }
    
    /**
     * The tweet whose information must be set from this FileTweetParser's specified file.
     * @param tweet 
     */
    public void parseFile(Tweet tweet)
    {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(toParse));
            String line = "";
            List<File> files = new ArrayList<>();
            boolean mediaFileMissing = false;
            while ((line = bf.readLine()) != null)
            {
                if (line.contains(MESSAGE_TOKEN))
                {
                    tweet.setMessage(line.replace(MESSAGE_TOKEN, ""));
                }
                else if (line.contains(MEDIA_TOKEN))
                {
                    String mediaId = line.replace(MEDIA_TOKEN, "");
                    File mediaFile = parseMedia(mediaId);
                    if (mediaFile.exists())
                    {
                        files.add(mediaFile);
                    }
                    else
                    {
                        mediaFileMissing = true;
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Media file with filename [{0}] is missing. Tweet with tweet file [{1}]. It's message will be set to null.", new Object[]{mediaFile, toParse.getName()});
                    }
                }
            }
            if (mediaFileMissing)
            {
                tweet.setMessage(null);
            }
            else
            {
                if (!files.isEmpty())
                {
                    tweet.setMedias(files.toArray(new File[files.size()]));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTweetParser.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(FileTweetParser.class.getName()).log(Level.SEVERE, "Tweet file {0} not found! Tweet will be skipped.");
        } catch (IOException ex) {
            Logger.getLogger(FileTweetParser.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(FileTweetParser.class.getName()).log(Level.SEVERE, "Tweet file {0} could not be read! Tweet will be skipped.");
        }
    }
    
    /**
     * Return the media file associated with the mediaId.
     * @param mediaId the file name of the media file inside the media folder
     * @return 
     */
    public File parseMedia(String mediaId)
    {
        String filePath = FileStorageConfiguration.SEP+FileStorageConfiguration.MEDIA_FOLDER+FileStorageConfiguration.SEP+mediaId;
        return new File(toParse.getParentFile(), filePath);
    }
    
}
