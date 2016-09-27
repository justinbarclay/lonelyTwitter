package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Justin on 2016-09-27.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }
    public void testAddTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("hello");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello");
        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet tweetA = new NormalTweet("hello");
        Tweet tweetB = new NormalTweet("Bonjour");

        list.add(tweetA);
        list.add(tweetB);

        assertEquals(tweetA, list.getTweet(0));
        assertEquals(tweetB, list.getTweet(1));
    }
}
