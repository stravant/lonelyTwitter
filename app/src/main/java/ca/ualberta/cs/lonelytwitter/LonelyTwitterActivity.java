package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Main activity for LonelyTwitter
 *
 * @author Mark Langen
 */
public class LonelyTwitterActivity extends Activity {
    /**
     * The File to which the tweets are saved on the local file system.
     */
    private static final String FILENAME = "file.sav";

    /**
     * The UI component into which the user can enter text to tweet
     */
    private EditText bodyText;

    /**
     * The main UI component storing the list of tweets
     */
    private ListView oldTweetsList;

    /**
     * The list of tweets currently being shown in the app
     */
    private ArrayList<AbstractTweet> tweets = new ArrayList<AbstractTweet>();

    /**
     * Adapter to create tweet UI entries in the oldTweetsList
     */
    ArrayAdapter<AbstractTweet> adapter;

    private int calculateTweetSize() {
        //
        return -1;
    }

    public String removeStopWords() {
        // Do something
        return "";
    }

    private void startSecondActivity(Intent intent) {
        // Run the second activity
    }

    protected boolean evaluateOtherActivity(Intent intent) {
        // Do something
        String expression1 = "", expression2 = "", expression3 = "",
                expression4 = "";
        //String expression = someMethod(expression1 + expression2 + expression3 +
        //        expression4);
        return true;
    }

    /**
     * The adapter class specific to AbstractTweets to draw them into
     * tweet list_items.
     */
    private class TweetAdapter extends ArrayAdapter<AbstractTweet> {
        public TweetAdapter(Context context, ArrayList<AbstractTweet> tweets) {
            super(context, 0, tweets);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            AbstractTweet tweet = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView text = (TextView)convertView.findViewById(R.id.item_text);
            TextView date = (TextView)convertView.findViewById(R.id.item_date);
            text.setText(tweet.getMessage());
            date.setText(tweet.getDate().toString());
            return convertView;
        }
    }

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState Todo
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Find relevant parts in the UI
        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        // Set up save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                AbstractTweet newestTweet = new NormalTweet(text);
                tweets.add(newestTweet);
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });

        // Set up clear button
        Button clearButton = (Button)findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tweets.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });
    }

    /**
     * Called when the activity is shown to the user
     */
    @Override
    protected void onStart() {
        super.onStart();

        // Load in tweets
        loadFromFile();

        // Set up adapter to show them
        adapter = new TweetAdapter(this, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * Loads in the tweets from the FILENAME save file, destructively overwriting
     * the contents of the tweets array.
     */
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Taken from
            // http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // on Jan 21
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the contents of the tweets array to the FILENAME save file.
     * Runs synchronously, does not return until the contents have been commited
     * to the file.
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweets, out);
            out.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}