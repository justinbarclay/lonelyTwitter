package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Justin on 2016-09-27.
 */
public class TweetList {
    /**
     * The Tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    /**
     * Has tweet boolean.
     *
     * @return the boolean
     */
    public boolean hasTweet() {
        for(int i=0; i<tweets.size(); i++){
            for(int j=i+1; j<tweets.size(); j++){
                if(tweets.get(i).equals(tweets.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return this.tweets.get(i);
    }

    /**
     * Delete.
     *
     * @param tweetA the tweet a
     */
    public void delete(Tweet tweetA) {
        tweets.remove(tweetA);
    }

    /**
     * Add tweet.
     *
     * @param tweet the tweet
     */
    public void addTweet(Tweet tweet){
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        } else{
            tweets.add(tweet);
        }
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public List getTweets() {
        // https://stackoverflow.com/questions/6957631/sort-java-collection#6957745
        ArrayList<Tweet> sortedTweet = new ArrayList<Tweet>(tweets.size());
        for(int i = 0; i< tweets.size(); i++){
            sortedTweet.add(tweets.get(i));
        }
        Comparator<Tweet> compareDates = new Comparator<Tweet>(){
            public int compare(Tweet tweetA, Tweet tweetB) {
                if(tweetA.getDate().before(tweetB.getDate())) {
                    return -1;
                } else{
                    return 1;
                }
            }
        };
        Collections.sort(sortedTweet, compareDates);
        return sortedTweet;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return tweets.size();
    }
}
