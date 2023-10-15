package redditClone;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class Comment {
	
	static int commentCount = 0;
	int commentID = 0;
	int commentCreatorID;
	String commentCreatorUsername;
	String commentTextMedia;
	int commentRefPostID;
	int commentRefPostUserID;
	String timeStamp;
	long time;
	
	ArrayList<Comment> comments;
	
	
//	int commentDownVote;
//	int commentUpVote;
	
	public Comment(String text, int creatorID) {
		
		commentCount++;
		commentCount = commentID;
		
		commentTextMedia = text;
		commentCreatorID = creatorID;
	
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		time = System.currentTimeMillis();  	
		
	}
	
	public String getComment() {
		return this.commentTextMedia;
	}
	
	public boolean deleteCommentComment(int id) {
		
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == id) {
				comments.remove(i);
				break;
			}
		}
		return true;
	}
	
	public boolean updateComment(String s) {
		this.commentTextMedia = s;
		return true;
	}
	
	public int getCommentID(){
		return this.commentID;
	}

}
