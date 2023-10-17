package redditClone;
import java.util.*;

/**
 * The way we have a definded the CommentThread class is that
 * every comment directly on a post is a CommentThread, and
 * any comment on a thread is a comment and that will be handled
 * by the comment class.
 * 
 * So, Posts have Threads. Post -> Thread
 * and Threads have comments. Threads -> comments
 * 
 * @author vishweshmashru
 *
 */
public class CommentThread {
	static int threadCount = 0;
	int threadID;
	ArrayList<Comment> comments; // this list keep tracks of the comments on a particular thread
	int userID; 
	int postID;
	String threadText; // the text of a thread
	long time;
	
	
	/**
	 * 
	 * @param s
	 * @param userID
	 */
	public CommentThread(String s, int userID) {
		threadCount++;
		threadID = threadCount;
		comments = new ArrayList<Comment>();
		threadText = s;
		this.userID = userID;
		time = System.currentTimeMillis(); 
	}
	
	/**
	 * This method is to add comments to a thread
	 * 
	 * 
	 *  Thread -> comment
	 * @param c
	 */
	public void add(Comment c) {
		comments.add(c);
	}
		

	
	public boolean addComment(String s) {
		comments.add(new Comment(s, userID));
		return true;		
	}
	
	public boolean deleteThreadComment(int id) {
		
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == id) {
				comments.remove(i);
				break;
			}
		}
		return true;
	}
	
	public boolean updateComment(int id, String s) {
		
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == id) {
				comments.get(i).commentTextMedia = s;
				break;
			}
		}
		return true;
	}
	
	public boolean display(int id) {
		
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == id) {
				System.out.print(comments.get(i).commentTextMedia);
				break;
			}
		}
		return true;
	}
	
	public void sortByTime() {
	    Collections.sort(comments, new Comparator<Comment>() {
	        @Override
	        public int compare(Comment c1, Comment c2) {
	            return Long.compare(c2.time, c1.time);
	        }
	    });
	}
	
	public int getID() {
		return this.threadID;
	}
//	public boolean displayComment(int i) {
//		return true;
//	}

}
