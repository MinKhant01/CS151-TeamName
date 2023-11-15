package redditClone;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * This content class is like the container for post and thread class
 * In and of itself a post is not associated with a thread, but this 
 * class makes so that they are always grouped together. 
 * 
 * Content =  Post + Thread;
 * @author vishweshmashru
 *
 */
public class Content{
    static int contentCounter = 0;
    int contentID;                              //unique ID for a content (content = post + thread)
    Post contentPost;                           //post for content
    List<Comment> contentThread;      //thread for content
    int userID;

    //constructor for class Content
    public Content(String postTextMedia, int userID){
        contentCounter++;
        this.contentID = contentCounter;
        contentPost = new Post(postTextMedia,contentID, userID);
        contentThread = new ArrayList<>();
        this.userID = userID;
        
    }

    //getter for contentID
    public int getContentID(){
        return this.contentID;
    }

    //getter for contentThread arrayList
    public List<Comment> getThread(){
        return contentThread;
    }

    //method for adding commentThreads
    public boolean makePostComment(String commentText){
        contentThread.add(new Comment(commentText, userID));
        return true;
    }
    
    public void sortByTime() {
	    Collections.sort(contentThread, new Comparator<Comment>() {
	        public int compare(Comment c1, Comment c2) {
	            return Long.compare(c2.time, c1.time);
	        }
	    });
	}


    //public boolean displayContent(){}          Front-end UI / Page class takes care of display function
    //deleteContent function in which class? user class?
}
