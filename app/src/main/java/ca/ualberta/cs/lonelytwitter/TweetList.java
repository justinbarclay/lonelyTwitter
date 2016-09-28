package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Justin on 2016-09-27.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

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

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return this.tweets.get(i);
    }

    public void delete(Tweet tweetA) {
        tweets.remove(tweetA);
    }

    public void addTweet(Tweet tweet){
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        } else{
            tweets.add(tweet);
        }
    }

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

    public int getCount() {
        return tweets.size();
    }
}
