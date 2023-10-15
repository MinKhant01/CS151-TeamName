package redditClone;
import java.util.*;

public class CommentThread {
	static int threadCount = 0;
	int threadID;
	ArrayList<Comment> comments;
	int userID;
	int postID;
	
	
	
	public CommentThread() {
		threadCount++;
		threadID = threadCount;
		comments = new ArrayList<Comment>();
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
	
//	public boolean displayComment(int i) {
//		return true;
//	}

}
