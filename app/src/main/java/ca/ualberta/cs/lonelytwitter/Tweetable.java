package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * An interface for something that can be tweeted.
 */
public interface Tweetable {
    /**
     * The message that the tweetable contains
     *
     * @return The message as a string
     */
    public String getMessage();

    /**
     * The date that the tweetable was tweeted on
     *
     * @return The date
     */
    public Date getDate();

}
