package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * An abstract class that all types of tweets extend. Also
 * implements the Tweetable interface.
 *
 * @author Mark Langen
 */
public abstract class AbstractTweet implements Tweetable {
    /**
     * Constructor for an AbstractTweet, creates a new tweet with a
     * given content to be published on a given date.
     *
     * @param created The date on which the tweet was published
     * @param message The message contained within the tweet
     */
    public AbstractTweet(Date created, String message) {
        this.date = created;
        this.message = message;
    }

    /**
     * Create a tweet with the date of publishing equal to the
     * current date.
     *
     * @param message The message contained within the tweet
     */
    public AbstractTweet(String message) {
        this(new Date(System.currentTimeMillis()), message);
    }

    /**
     * Modify the message in a tweet. Throws an error if the new message
     * is too long to fit in a tweet.
     *
     * @param message The message to change the contents to
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() >= 140) {
            throw new TweetTooLongException("Message exceeds 140 characters.");
        }
        this.message = message;
    }

    /**
     * Getter, getting the message in a tweet
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Convert a tweet to a string, containing the message and the
     * date on which it was published.
     * @return The converted tweet
     */
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }

    /**
     * Get the date on which the tweet was published
     * @return The date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Flag marking whether a tweet is important or not. Important tweets
     * are shown with a more eye-catching look in the UI.
     *
     * @return The current state of the flag
     */
    public abstract boolean isImportant();

    /**
     * Add a mood to the tweet, describing the mood of the user when they
     * published it.
     *
     * @param mood The mood to add to the tweet
     */
    public void addMood(AbstractMood mood) {
        moodList.add(mood);
    }

    /**
     * Get a list of all of the moods that the tweet currently has.
     * A reference to the list should not be kept between invocations
     * of other methods of the tweet object.
     *
     * @return A list of the moods
     */
    public List<AbstractMood> getMoodList() {
        return moodList;
    }

    /**
     * The current message as a string.
     */
    private String message;

    /**
     * The date that the tweet was published on.
     */
    private Date date;

    /**
     * An ArrayList of the moods that the tweet currently has.
     */
    private ArrayList<AbstractMood> moodList = new ArrayList<AbstractMood>();
}
