package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends AbstractTweet implements Tweetable {
    public ImportantTweet(String message) {
        super(message);
    }

    @Override
    public boolean isImportant() {
        return true;
    }

    @Override
    public String getMessage() {
        return "IMPORTANT: " + super.getMessage();
    }
}
