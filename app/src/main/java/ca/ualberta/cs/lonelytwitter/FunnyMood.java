package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Justin on 2016-09-13.
 */
public class FunnyMood extends Mood {
    /**
     * Instantiates a new Funny mood.
     */
    public FunnyMood(){
        super("Laughing");
    }

    /**
     * Instantiates a new Funny mood.
     *
     * @param date the date
     */
    public FunnyMood(Date date){
        super("Laughing", date);
    }

    public String format(){
        return "(☞ﾟ∀ﾟ)☞";
    }
}
