/*
Copyright (c) 2016 Justin Barclay, CMPUT301. University of Alberta. All rights reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
For further information, contact me at jbarclay@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;

import io.searchbox.annotations.JestId;

/**
 * This is the base model for lonelyTwitter where every action of the user has to do with viewing
 * or making tweets. It implements tweetable to ensure that the message and date are able to be
 * displayed in the view.
 * @author Justin
 */
public abstract class Tweet implements Tweetable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JestId
    private String id;

    private String message;
    private Date date;
    private ArrayList<Mood> moods;

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    /**
     * A tweet equals another tweet if their strings equal each other
     *
     * @param otherTweet the other tweet
     * @return the boolean
     */
    public boolean equals(Tweet otherTweet){
        // Two tweets are equal if they have the same message;
        return this.message.equals(otherTweet.getMessage());
    }

    /**
     * A method to indicate the importance of a tweet
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     *  Get the message of the tweet
     * @return message the content of the tweet
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *  Get the date of the tweet
     * @return date the date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Returns a custom string containing pertinent information for the user
     * @return string
     */
    @Override
    public String toString() {
        return date.toString() + " | " + this.message;
    }
}