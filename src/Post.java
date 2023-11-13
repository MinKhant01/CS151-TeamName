package redditClone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Post{
    int postID;                 //unique ID for post
    int postUserID;             //unique ID for user creating the post
    String postUsername;        //username  for user creating the post
    String postTextMedia;       //text object for the post
    long postTimeStamp;         //date object for the post
    String timeStamp;
    int totalKarma;

    /**
     * This is to keep track of the User reactions on the post
     */
    HashMap<User, voteType> postMap = new HashMap<>();

    /*
    private int postDownVote;           //down vote for the post
    private int postUpVote;             //up vote for the post
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
    public Post(String textMedia, int contentID, int userID){
        this.postID = contentID;
        this.postTextMedia = textMedia;
        //this.postUsername = userName;
        this.postUserID = userID;
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
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


    /**
     * This method add reactions of a particular user on a particular post
     * @param u
     * @param v
     */

    public void addToReactions(User u, voteType v) {
        postMap.put(u, v);
    }


    /**
     * This method return the karma on a particular post
     * @return
     */
    public int getPostKarma() {
        ArrayList<voteType> reactions = (ArrayList<voteType>)postMap.values();
        int totalPostKarma = 0;
        for(int i = 0; i < reactions.size(); i++) {
            voteType reaction = reactions.get(i);
            if(reaction == voteType.UPVOTE) {
                totalPostKarma += 1;
            }
            else if(reaction == voteType.DOWNVOTE) {
                totalPostKarma -= 1;
            }
        }
        totalKarma = totalPostKarma;
        return totalPostKarma;
    }

}