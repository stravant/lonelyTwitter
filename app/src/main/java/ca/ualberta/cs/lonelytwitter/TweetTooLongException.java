package ca.ualberta.cs.lonelytwitter;

/**
 * Created by langen on 1/14/16.
 */
public class TweetTooLongException extends IllegalArgumentException {
    public TweetTooLongException(String message) {
        super(message);
    }
}
