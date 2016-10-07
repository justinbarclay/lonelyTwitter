package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Justin on 2016-09-13.
 */
public class NormalTweet extends Tweet {
    /**
     * This constructor makes a normalTweet with given string parameter.
     *
     * @param message this parameter is the given string for the tweet. If it is set to empty                  string then it will be replaced by....
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public NormalTweet(String message, Date date){
        super(message, date);
    }
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
