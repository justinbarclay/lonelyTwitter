package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Justin on 2016-09-13.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
