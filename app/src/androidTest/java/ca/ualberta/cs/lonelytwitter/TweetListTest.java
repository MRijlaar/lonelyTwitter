package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by mrijlaar on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList list = new TweetList();
        list.addTweet(new NormalTweet("test"));
    }

    public void testRemoveTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        list.removeTweet(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testgetCount() {
        TweetList list = new TweetList();
        list.getCount();
    }

    public void testgetCountAccurate() {
        TweetList list = new TweetList();
        assertTrue(list.getCount()==0);
    }

    public void testGetTweets(){
        TweetList list = new TweetList();
        assertFalse(list.getTweets()==null);
    }

}