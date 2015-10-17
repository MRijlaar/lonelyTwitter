package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditTweet(){
        final LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        activity.getTweets().clear();
        assertTrue("test tweets were cleared", activity.getTweets().size()==0);

        final Button saveButton = activity.getSaveButton();
        final String tweetText = "Hello";
        final EditText bodyText = activity.getBodyText();
        final ListView oldTweetList = activity.getOldTweetsList();
        activity.getTweets().add(new NormalTweet("orig text"));

        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText(tweetText);
            }
        });
        getInstrumentation().waitForIdleSync();

        assertTrue(activity.getTweets().get(0).getText() == tweetText);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                assertTrue(saveButton.performClick());
            }
        });
        getInstrumentation().waitForIdleSync();

        assertTrue("Test text was saved and loaded",activity.getLoadedTweets().get(0).getText().equals(tweetText));

        //Code from: https://developer.android.com/training/activity-testing/activity-functional-testing.html
        //Date: 2015-10-15
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(), null, false);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();

        Tweet newestTweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals(tweetText, newestTweet.getText());

        //Code from: https://developer.android.com/training/activity-testing/activity-functional-testing.html
        //Date: 2015-10-15
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

// Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        //test that the tweet editor starts up with the correct tweet

        //test that we can edit a tweet

        //test that we can push a save button

        //test that the modified tweet was saved

        //test that the modified tweet was displayed

        receiverActivity.finish();; // close actibity test is good!
    }
}