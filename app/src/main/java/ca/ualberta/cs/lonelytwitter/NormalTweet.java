package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by mrijlaar on 9/14/15.
 */
public class NormalTweet extends Tweet{
    public NormalTweet(Date date, String text) throws IOException {
        super(date, text);
    }

    public NormalTweet(String text) throws IOException {
        super(text);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
