package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Justin on 2016-09-13.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }
    public NormalTweet(String message, Date date){
        super(message, date);
    }
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
