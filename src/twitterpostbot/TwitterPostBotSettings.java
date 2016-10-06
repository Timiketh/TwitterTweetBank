/*
 * 
 */
package twitterpostbot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author barnsbarn
 */
public class TwitterPostBotSettings {
    
    private final long TIME_IN_MILLIS_MIN_DEFAULT = 1000 * 60 * 60 * 24 * 12;
    private final long TIME_IN_MILLIS_RANGE_DEFAULT = 1000 * 60 * 60 * 24 * 12;
    
    private File fileSettings;
    
    private TwitterPostBotSettings() {
        fileSettings = new File("settings");
    }
    
    public static TwitterPostBotSettings getInstance() {
        return TwitterPostBotSettingsHolder.INSTANCE;
    }

    /**
     * @return the timeInMillisMin
     */
    public long getTimeInMillisMin() {
        long timeMin = TIME_IN_MILLIS_MIN_DEFAULT;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileSettings));
            timeMin = Long.parseLong(br.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TwitterPostBotSettings.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).severe("Settings file not found! Will use default coded values...");
        } catch (IOException ex) {
            Logger.getLogger(TwitterPostBotSettings.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).severe("Could not read settings file! Will use default coded values...");
        }
        return timeMin;
    }

    /**
     * @return the timeInMillisRange
     */
    public long getTimeInMillisRange() {
        long timeRange = TIME_IN_MILLIS_RANGE_DEFAULT;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileSettings));
            br.readLine();
            timeRange = Long.parseLong(br.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TwitterPostBotSettings.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).severe("Settings file not found! Will use default coded values...");
        } catch (IOException ex) {
            Logger.getLogger(TwitterPostBotSettings.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(getClass().getName()).severe("Could not read settings file! Will use default coded values...");
        }
        return timeRange;
    }
    
    private static class TwitterPostBotSettingsHolder {

        private static final TwitterPostBotSettings INSTANCE = new TwitterPostBotSettings();
    }
    
    
}
