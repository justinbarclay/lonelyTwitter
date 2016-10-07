package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
* This is a child class of the mood class that let's you're twitter followers know that you're in
* a happy mood.
* @author Justin
* @see Mood
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
