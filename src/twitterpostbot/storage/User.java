/*
 */
package twitterpostbot.storage;

/**
 *
 * @author barnsbarn
 */
public class User {
    private String consumerKey = "";
    private String consumerSecret = "";
    private String accesToken = "";
    private String accesTokenSecret = "";
    
    private String username = "";

    /**
     * @return the accesToken
     */
    public String getAccesToken() {
        return accesToken;
    }

    /**
     * @param accesToken the accesToken to set
     */
    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    /**
     * @return the accesTokenSecret
     */
    public String getAccesTokenSecret() {
        return accesTokenSecret;
    }

    /**
     * @param accesTokenSecret the accesTokenSecret to set
     */
    public void setAccesTokenSecret(String accesTokenSecret) {
        this.accesTokenSecret = accesTokenSecret;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the consumerKey
     */
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * @param consumerKey the consumerKey to set
     */
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * @return the consumerSecret
     */
    public String getConsumerSecret() {
        return consumerSecret;
    }

    /**
     * @param consumerSecret the consumerSecret to set
     */
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }
    
    
    
}
