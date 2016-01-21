package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractTweet {
    //// Constructors
    public AbstractTweet(Date created, String message) {
        this.date = created;
        this.message = message;
    }

    public AbstractTweet(String message) {
        this(new Date(System.currentTimeMillis()), message);
    }

    //// Tweet message and date
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() >= 140) {
            throw new TweetTooLongException("Message exceeds 140 characters.");
        }
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }

    public Date getDate() {
        return date;
    }

    //// Importance flag
    public abstract boolean isImportant();

    //// Mood handling code
    public void addMood(AbstractMood mood) {
        moodList.add(mood);
    }

    public List<AbstractMood> getMoodList() {
        return moodList;
    }

    //// Private data
    private String message;
    private Date date;
    private ArrayList<AbstractMood> moodList = new ArrayList<AbstractMood>();
}
