package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class AbstractTweet {
    public AbstractTweet(Date created, String message) {
        this.date = created;
        this.message = message;
    }

    public AbstractTweet(String message) {
        this(new Date(System.currentTimeMillis()), message);
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() >= 140) {
            throw new TweetTooLongException("Message exceeds 140 characters.");
        }
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public Date getDate() {
        return date;
    }

    public abstract boolean isImportant();

    private String message;
    private Date date;
}
