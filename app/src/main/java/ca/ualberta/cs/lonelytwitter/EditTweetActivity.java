package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by Justin on 2016-10-11.
 */
public class EditTweetActivity extends Activity {

    private TextView editTweet;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_tweet);

        editTweet = (TextView) findViewById(R.id.editTweetText);
        Intent intent = getIntent();
        String gsonTweet = intent.getStringExtra("tweet");

        Gson gson = new Gson();
        Tweet tweet = gson.fromJson(gsonTweet, NormalTweet.class);

        editTweet.setText(tweet.toString());
    }
}
