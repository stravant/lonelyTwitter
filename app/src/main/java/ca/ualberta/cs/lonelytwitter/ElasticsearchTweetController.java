package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    private static void initializeClient() {
        DroidClientConfig.Builder builder =
                new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
        DroidClientConfig cfg = builder.build();

        JestClientFactory factory = new JestClientFactory();
        factory.setDroidClientConfig(cfg);
        client = (JestDroidClient)factory.getObject();
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, List<NormalTweet>> {
        @Override
        protected List<NormalTweet> doInBackground(String... params) {
            initializeClient();
            List<NormalTweet> foundTweets = new ArrayList<NormalTweet>();
            String search_string = params[0];
            search_string = "{\n" +
                    "    \"query\": {\n" +
                    "        \"match\": {\n" +
                    "            \"message\": \"" + search_string + "\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            Search search =
                    new Search.Builder(search_string).addIndex("testing").addType("tweet").build();
            try {
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    Log.i("TODO", "Search: " + params[0] + " -> Total hits: " + result.getTotal());
                    foundTweets = result.getSourceAsObjectList(NormalTweet.class);
                } else {
                    Log.e("TODO", "Our search failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return foundTweets;
        }
    }

    public static class AddTweetTask extends AsyncTask<Tweet, Void, Void> {
        @Override
        protected Void doInBackground(Tweet... params) {
            initializeClient();

            for (Tweet tweet: params) {
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        tweet.setId(result.getId());
                    } else {
                        Log.e("TODO", "Our insert failed");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }

    public static ArrayList<Tweet> getTweets() {
        initializeClient();
        // TODO:
        return null;
    }

    public static void createTweet(Tweet tweet) {

    }
}
