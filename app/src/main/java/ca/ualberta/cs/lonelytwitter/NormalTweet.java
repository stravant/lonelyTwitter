package ca.ualberta.cs.lonelytwitter;

public class NormalTweet extends AbstractTweet implements Tweetable {
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public boolean isImportant() {
        return false;
    }
}
