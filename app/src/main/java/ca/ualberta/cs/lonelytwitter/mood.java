package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * Created by Justin on 2016-09-13.
 */
public abstract class Mood {
    private Date date;
    private String currentMood;

    /**
     * Instantiates a new Mood.
     *
     * @param currentMood the current mood
     */
    public Mood(String currentMood){
        this.currentMood = currentMood;
        this.date = new Date();
    }

    /**
     * Instantiates a new Mood.
     *
     * @param currentMood the current mood
     * @param date        the date
     */
    public Mood(String currentMood, Date date){
        this.currentMood = currentMood;
        this.date = date;
    }

    /**
     * Format string.
     *
     * @return the string
     */
    public abstract String format();

    /**
     * Set mood.
     *
     * @param mood the mood
     */
    public void setMood(String mood){

    }

    /**
     * Get mood string.
     *
     * @return the string
     */
    public String getMood(){
        return this.currentMood;
    }

    /**
     * Get date date.
     *
     * @return the date
     */
    public Date getDate(){
        return this.date;
    }
}
