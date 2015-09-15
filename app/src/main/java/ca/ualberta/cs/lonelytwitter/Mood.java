package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mrijlaar on 9/14/15.
 */
public abstract class Mood {
    private Date date;
    private ArrayList<Mood> mood;

    public Mood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
