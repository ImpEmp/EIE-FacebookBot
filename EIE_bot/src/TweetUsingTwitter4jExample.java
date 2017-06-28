

import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 * This class demonstrate how you can post a Tweet in Java using the Twitter REST API and an open source third party
 * twitter integration library in java called Twitter4J
 *
 * User: smhumayun
 * Date: 7/20/13
 * Time: 9:26 AM
 */
public class TweetUsingTwitter4jExample {

    public static void main(String[] args) throws IOException, TwitterException {

        //Your Twitter App's Consumer Key
        String consumerKey = "sHkKDCyejm1mCbWvSM7ZlX5BJ";

        //Your Twitter App's Consumer Secret
        String consumerSecret = "ldqJ4mbQCl4kuIs2PQj111xgGqWoyfkEnYs3J3jLBqUPKJ2K7S";

        //Your Twitter Access Token
        String accessToken = "880054483128111104-bnooexN77uhe0vMo2x6TOhHZ3vopCQ4";

        //Your Twitter Access Token Secret
        String accessTokenSecret = " 2DA74krdn7gxlzVbhtKxpIDYRYlVJDHf9pcFMmoO3aD1j";

        //Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();

        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();

        //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);

        //setup OAuth Access Token
        twitter.getOAuthAccessToken();

        //Instantiate and initialize a new twitter status update
        StatusUpdate statusUpdate = new StatusUpdate(
                //your tweet or status message
                "H-1B Transfer Jobs | Java Developer | Harrison, NY | 2 Years");
        //attach any media, if you want to
//        statusUpdate.setMedia(
//                //title of media
//                "http://h1b-work-visa-usa.blogspot.com"
//                , new URL("http://lh6.ggpht.com/-NiYLR6SkOmc/Uen_M8CpB7I/AAAAAAAAEQ8/tO7fufmK0Zg/h-1b%252520transfer%252520jobs%25255B4%25255D.png?imgmax=800").openStream());

        //tweet or update status
        Status status = twitter.updateStatus(statusUpdate);

        //response from twitter server
        System.out.println("status.toString() = " + status.toString());
        System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
        System.out.println("status.getSource() = " + status.getSource());
        System.out.println("status.getText() = " + status.getText());
        System.out.println("status.getContributors() = " + Arrays.toString(status.getContributors()));
        System.out.println("status.getCreatedAt() = " + status.getCreatedAt());
    //    System.out.println("status.getCurrentUserRetweetId() = " + ((Object) status).getCurrentUserRetweetId());
        System.out.println("status.getGeoLocation() = " + status.getGeoLocation());
        System.out.println("status.getId() = " + status.getId());
        System.out.println("status.getInReplyToStatusId() = " + status.getInReplyToStatusId());
        System.out.println("status.getInReplyToUserId() = " + status.getInReplyToUserId());
        System.out.println("status.getPlace() = " + status.getPlace());
        System.out.println("status.getRetweetCount() = " + status.getRetweetCount());
        System.out.println("status.getRetweetedStatus() = " + status.getRetweetedStatus());
        System.out.println("status.getUser() = " + status.getUser());
        System.out.println("status.getAccessLevel() = " + status.getAccessLevel());
        System.out.println("status.getHashtagEntities() = " + Arrays.toString(status.getHashtagEntities()));
        System.out.println("status.getMediaEntities() = " + Arrays.toString(status.getMediaEntities()));
        if(status.getRateLimitStatus() != null)
        {
   //         System.out.println("status.getRateLimitStatus().getLimit() = " + status.getRateLimitStatus().getLimit());
     //       System.out.println("status.getRateLimitStatus().getRemaining() = " + status.getRateLimitStatus().getRemaining());
            System.out.println("status.getRateLimitStatus().getResetTimeInSeconds() = " + status.getRateLimitStatus().getResetTimeInSeconds());
            System.out.println("status.getRateLimitStatus().getSecondsUntilReset() = " + status.getRateLimitStatus().getSecondsUntilReset());
      //      System.out.println("status.getRateLimitStatus().getRemainingHits() = " + status.getRateLimitStatus().getRemainingHits());
        }
        System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
        System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
    }

}