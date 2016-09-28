package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

/**
 * Created by Justin on 2016-09-27.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
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

    public void testDeleteTweet() {
        TweetList list = new TweetList();

        Tweet tweetA = new NormalTweet("hello");

        list.add(tweetA);

        assertTrue(list.hasTweet(tweetA));

        list.delete(tweetA);
        assertFalse(list.hasTweet(tweetA));
    }

    public void testCantHaveDuplicateTweets() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("hello");

        list.addTweet(tweet);
        try {
            list.addTweet(tweet);
            assertTrue(false);
        } catch (IllegalArgumentException argument) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public void testGetReturnsTweetsInOrder() {
        TweetList list = new TweetList();

        Tweet tweetA = new NormalTweet("hello");
        Tweet tweetB = new NormalTweet("Thing", new Date(0));
        Tweet tweetC = new NormalTweet("Bonjour");

        list.add(tweetA);
        list.add(tweetC);
        list.add(tweetB);

        List tweets = list.getTweets();
        assertEquals(tweetB, tweets.get(0));
        assertEquals(tweetA, tweets.get(1));
        assertEquals(tweetC, tweets.get(2));
    }

    public void testGetCount() {
        TweetList list = new TweetList();

        Tweet tweetA = new NormalTweet("hello");
        Tweet tweetB = new NormalTweet("Thing");
        Tweet tweetC = new NormalTweet("Bonjour");

        list.addTweet(tweetA);
        list.addTweet(tweetC);
        list.addTweet(tweetB);
        assertEquals(3, list.getCount());
    }

    public void testHasTweets() {
        TweetList list = new TweetList();

        Tweet tweetA = new NormalTweet("hello");
        Tweet tweetB = new NormalTweet("Bonjour");
        Tweet tweetC = new NormalTweet("Bonjour");

        list.addTweet(tweetA);
        list.addTweet(tweetB);
        list.addTweet(tweetC);

        assertTrue(list.hasTweet());
    }
}