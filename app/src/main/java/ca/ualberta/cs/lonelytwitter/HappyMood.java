package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Justin on 2016-09-13.
 */
public class HappyMood extends Mood {
    /**
     * Instantiates a new Happy mood.
     */
    public HappyMood(){
        super("Happy");
    }

    /**
     * Instantiates a new Happy mood.
     *
     * @param date the date
     */
    public HappyMood(Date date) {
        super("Happy", date);
    }

    public String format() {
        return "(っ◕‿◕)っ";
    }
}
