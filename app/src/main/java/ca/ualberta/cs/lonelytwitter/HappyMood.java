package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by langen on 1/14/16.
 */
public class HappyMood extends AbstractMood {
    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String format() {
        return "Happy";
    }
}
