package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class AbstractMood {
    public AbstractMood(Date date) {
        this.date = date;
    }

    public abstract String format();

    public Date getDate() {
        return date;
    }

    Date date;
}
