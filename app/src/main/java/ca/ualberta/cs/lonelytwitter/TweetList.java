package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by mrijlaar on 9/28/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){

    }

    public void addTweet(Tweet tweet){
        //if
        tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Integer getCount(){
        return tweets.size();
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }
}
