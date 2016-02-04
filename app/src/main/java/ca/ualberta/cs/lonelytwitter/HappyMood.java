package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A happy implemenation of AbstractMood
 *
 * @author Mark Langen
 */
public class HappyMood extends AbstractMood {
    /**
     * Create a new mood with the current date
     *
     * @param date
     */
    public HappyMood(Date date) {
        super(date);
    }

    /**
     * Format the mood, returning a happy string
     *
     * @return Always "Happy".
     */
    @Override
    public String format() {
        return "Happy";
    }
}
