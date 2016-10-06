/*
 * 
 */
package twitterpostbot.storage;

import java.io.File;
import java.util.Date;

/**
 *
 * @author barnsbarn
 */
public class Tweet {
    
    private File[] medias = null;
    private String message = "";
    private User user = null;
    private Date date = null;
    private String id = null;

    /**
     * @return the medias
     */
    public File[] getMedias() {
        return medias;
    }

    /**
     * @param medias the medias to set
     */
    public Tweet setMedias(File[] medias) {
        this.medias = medias;
        return this;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public Tweet setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public Tweet setUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public Tweet setDate(Date date) {
        this.date = date;
        return this;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public Tweet setId(String id) {
        this.id = id;
        return this;
    }
    
    
    
}
