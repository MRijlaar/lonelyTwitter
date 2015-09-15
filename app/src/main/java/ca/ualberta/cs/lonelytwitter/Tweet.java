package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by mrijlaar on 9/14/15.
 */
public abstract class Tweet {
    private String text;
    private Date date;

    public Tweet(Date date, String text) throws IOException {
        this.date = date;
        if (text.length() <= 140) this.text = text;
        else {throw new IOException("Tweet was too long!");}
    }

    public Tweet(String text) throws IOException {
        if (text.length() <= 140) this.text = text;
        else {
            throw new IOException("Tweet was too long!");
        }
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException {
        if (text.length() <= 140) this.text = text;
        else {throw new IOException("Tweet was too long!");}
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();
}
