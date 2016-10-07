/**
 * Created by Justin on 2016-09-13.
 */
package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type Tweet.
 */
public abstract class Tweet implements Tweetable {
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
     * Equals boolean.
     *
     * @param otherTweet the other tweet
     * @return the boolean
     */
    public boolean equals(Tweet otherTweet){
        // Two tweets are equal if they have the same message;
        return this.message.equals(otherTweet.getMessage());
    }

    /**
     * Is important boolean.
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

    public Date getDate(){
        return this.date;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + this.message;
    }
}