/**
 * Created by Justin on 2016-09-13.
 */
package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private ArrayList<Mood> moods;

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public boolean equals(Tweet otherTweet){
        // Two tweets are equal if they have the same message;
        return this.message.equals(otherTweet.getMessage());
    }

    public abstract Boolean isImportant();

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