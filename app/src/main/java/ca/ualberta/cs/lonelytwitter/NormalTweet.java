/*
Copyright (c) 2016 Justin Barclay, CMPUT301. University of Alberta. All rights reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
For further information, contact me at jbarclay@ualberta.ca
 */


package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * NormalTweet extends Tweet and sets always returns false when isImportant method is called
 * @author Justin
 * @see Tweet
 */
public class NormalTweet extends Tweet {
    /**
     * This constructor makes a normalTweet with given string parameter.
     *
     * @param message this parameter is the given string for the tweet.
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

    /**
     * Getter for isImportant
     *
     * @return isImportant
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
