package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mrijlaar on 9/14/15.
 */
public abstract class Mood {
    private String mood;

    public Mood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
