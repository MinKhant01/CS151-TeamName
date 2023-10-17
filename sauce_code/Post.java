package redditClone;

import java.text.SimpleDateFormat;

public class Post {
    int postID; // unique ID for post
    int postUserID; // unique ID for user creating the post
    String postUsername; // username for user creating the post
    String postTextMedia; // text object for the post
    long postTimeStamp; // date object for the post
    String timeStamp;
    /*
     * private int postDownVote; //down vote for the post
     * private int postUpVote; //up vote for the post
     */

    /**
     * removed String username as we dont need to handle username in this class
     * we could have a global hashmap that maps userID to usernames.
     * 
     * @param textMedia
     * @param contentID
     * @param userName
     * @param userID
     */
    public Post(String textMedia, int contentID, int userID) {
        this.postID = contentID;
        this.postTextMedia = textMedia;
        // this.postUsername = userName;
        this.postUserID = userID;
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        postTimeStamp = System.currentTimeMillis();
    }

    public boolean displayPost() {
        System.out.print(this.postTextMedia);
        return true;
    }

    public boolean updatePost(String textMedia) {
        this.postTextMedia = textMedia;
        return true;
    }

    // deletePost method has to be on which class? Page class?
}