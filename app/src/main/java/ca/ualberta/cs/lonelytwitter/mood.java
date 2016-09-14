package ca.ualberta.cs.lonelytwitter;
import java.util.Date;
/**
 * Created by Justin on 2016-09-13.
 */
public abstract class Mood {
    private Date date;
    private String currentMood;

    public Mood(String currentMood){
        this.currentMood = currentMood;
        this.date = new Date();
    }

    public Mood(String currentMood, Date date){
        this.currentMood = currentMood;
        this.date = date;
    }

    public abstract String format();

    public void setMood(String mood){

    }

    public String getMood(){
        return this.currentMood;
    }

    public Date getDate(){
        return this.date;
    }
}
