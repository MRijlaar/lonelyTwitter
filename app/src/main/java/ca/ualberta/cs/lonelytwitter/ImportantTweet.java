package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by mrijlaar on 9/14/15.
 */
public class ImportantTweet extends Tweet implements Tweetable{
    public ImportantTweet(Date date, String text) throws IOException {
        super(date, text);
    }

    public ImportantTweet(String text) throws IOException {
        super(text);
        this.setText(text);
    }

    public Boolean isImportant() {
            return Boolean.TRUE;
    }
}
