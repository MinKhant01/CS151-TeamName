package redditClone;
import java.util.*;
import java.text.SimpleDateFormat;

public class Post{
    private int postID;                 //unique ID for post
    private int postUserID;             //unique ID for user creating the post
    private String postUsername;        //username  for user creating the post
    private String postTextMedia;       //text object for the post
    private long postTimeStamp;         //date object for the post
    /*
    private int postDownVote;           //down vote for the post
    private int postUpVote;             //up vote for the post
     */

    public Post(String textMedia, int contentID, String userName, int userID){
        this.postID = contentID;
        this.postTextMedia = textMedia;
        this.postUsername = userName;
        this.postUserID = userID;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        postTimeStamp = System.currentTimeMillis();
    }

    public boolean displayPost(){
        System.out.print(this.postTextMedia);
        return true;
    }

    public boolean updatePost(String textMedia) {
        this.postTextMedia = textMedia;
        return true;
    }

    //deletePost method has to be on which class? Page class?
}
