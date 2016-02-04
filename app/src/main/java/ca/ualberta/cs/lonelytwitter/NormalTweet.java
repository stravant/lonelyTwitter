package ca.ualberta.cs.lonelytwitter;

/**
 * A concrete tweet class with it's importance flag permanently set to
 * false. No additional styling is applied, see {@link ImportantTweet}, which
 * does have additional styling applied.
 *
 * @author Mark Langen
 * @see AbstractTweet
 */
public class NormalTweet extends AbstractTweet implements Tweetable {
    /**
     * Construct a normal tweet, with the given message, and a date
     * of publication as the current date.
     *
     * @param message The tweet message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * The importance flag, permanently set to false
     *
     * @return Always false
     */
    @Override
    public boolean isImportant() {
        return false;
    }
}
