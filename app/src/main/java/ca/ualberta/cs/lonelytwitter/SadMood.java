package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by langen on 1/14/16.
 */
public class SadMood extends AbstractMood {
    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String format() {
        return "Sad";
    }
}
