package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A concrete tweet class which has it's importance flag permanently
 * set to true.
 *
 * @author Mark Langen
 * @see AbstractTweet
 */
public class ImportantTweet extends AbstractTweet implements Tweetable {
    /**
     * Construct a new important tweet with a given message. The current
     * date will be used as the date of publishing.
     *
     * @param message The message that the tweet contains
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Override of the importance flag to always return true
     *
     * @return Always true
     */
    @Override
    public boolean isImportant() {
        return true;
    }

    /**
     * Message returned with additional styling to mark it as
     * an important tweet.
     *
     * @return The tweet message, plus some additional styling
     */
    @Override
    public String getMessage() {
        return "IMPORTANT: " + super.getMessage();
    }
}
