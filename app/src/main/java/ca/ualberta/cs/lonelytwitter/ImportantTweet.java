/*
Copyright (c) 2016 Justin Barclay, CMPUT301. University of Alberta. All rights reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
For further information, contact me at jbarclay@ualberta.ca
 */


package ca.ualberta.cs.lonelytwitter;

/**
 * ImportantTweet extends Tweet, except that it always returns true for the isImportant method call
 *
 * @author Justin
 * @see Tweet
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     *  Sets the importance of the tweet to true
     * @return True
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
