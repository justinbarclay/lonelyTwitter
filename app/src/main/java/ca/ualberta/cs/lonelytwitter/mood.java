package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * Mood is the abstract base class for all mood sub types. IE Happy, Funny. It ensures that all
 * mood tweets implement a string method, so everyone can see their mood.
 * @author Justin
 */
public abstract class Mood {
    private Date date;
    private String currentMood;

    /**
     * Instantiates a new Mood.
     * Mood type is stored as a string.
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
     * Abstract method to ensure that any mood can be printed for the user
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
