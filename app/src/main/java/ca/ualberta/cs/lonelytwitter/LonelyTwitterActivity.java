/*
Copyright (c) 2016 Justin Barclay, CMPUT301. University of Alberta. All rights reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
For further information, contact me at jbarclay@ualberta.ca
 */


package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of LonelyTwitter project. It handles all
 * user interactions as well as file manipulations.
 * All the files are stored in the form of "json" files stored in Emulaltor's, accessible from
 * Android Device Monitor.
 * @author Justin
 * @see NormalTweet
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {

    /**
     * This is the file name that is being saved / loaded and contains all the tweets
     * @see #loadFromFile()
     * @see #saveInFile()
     */

    private Activity activity = this;

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

    private ArrayAdapter<Tweet> adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                Tweet newTweet = new NormalTweet(text);

                tweetList.add(newTweet);
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                tweetList.clear();
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        });

        oldTweetsList.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Tweet tweet = tweetList.get(position);

                Gson gson = new Gson();
                String gsonTweet = gson.toJson(tweet);


                Intent intent = new Intent(activity, EditTweetActivity.class);
                intent.putExtra("tweet", gsonTweet);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * This method loads the weets from FILENAME (file.sav), and ...
     * @throws FileNotFoundException
     * @exception RuntimeException
     */
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

            tweetList = gson.fromJson(in,listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }


    public ListView getOldTweetsList() {
        return oldTweetsList;
    }
}