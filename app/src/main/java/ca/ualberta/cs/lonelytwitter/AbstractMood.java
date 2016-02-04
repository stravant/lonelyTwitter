package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Class describing the one mood of a tweet
 *
 * @author Mark Langen
 */
public abstract class AbstractMood {
    /**
     * Crate a new mood for a tweet on a given date
     *
     * @param date
     */
    public AbstractMood(Date date) {
        this.date = date;
    }

    /**
     * Convert to the textual representation of the mood
     *
     * @return The textual representation
     */
    public abstract String format();

    /**
     * Get the date that the mood was created on
     *
     * @return The date
     */
    public Date getDate() {
        return date;
    }

    Date date;
}
