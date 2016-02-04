package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A sad mood implementation of AbstractMood
 *
 * @author Mark Langen
 */
public class SadMood extends AbstractMood {
    /**
     * Create a new sad mood with the given date
     *
     * @param date
     */
    public SadMood(Date date) {
        super(date);
    }

    /**
     * Format the mood, giving a sad string
     *
     * @return Always "Sad"
     */
    @Override
    public String format() {
        return "Sad";
    }
}
