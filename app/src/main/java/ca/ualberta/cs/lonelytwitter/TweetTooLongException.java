package ca.ualberta.cs.lonelytwitter;

/**
 * An exception to be thrown when text too long to fit in a tweet is
 * used as the message for a tweet.
 *
 * @author Mark Langen
 */
public class TweetTooLongException extends IllegalArgumentException {
    /**
     * Construct a TweetTooLongException with the given message
     * @param message
     */
    public TweetTooLongException(String message) {
        super(message);
    }
}
