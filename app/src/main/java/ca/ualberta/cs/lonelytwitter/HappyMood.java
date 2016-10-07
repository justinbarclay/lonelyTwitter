/*
Copyright (c) 2016 Justin Barclay, CMPUT301. University of Alberta. All rights reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
For further information, contact me at jbarclay@ualberta.ca
 */


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
