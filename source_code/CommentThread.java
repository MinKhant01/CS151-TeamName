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
	HashMap<User, voteType> commentMap = new HashMap<>();
	int totalKarma;


	/**
	 * 
	 * @param s
	 * @param userID
	 */
	public CommentThread(String comment, int userID) {
		threadCount++;
		threadID = threadCount;
		comments = new ArrayList<Comment>();
		threadText = comment;
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
	public void add(Comment comment) {
		comments.add(comment);
	}

	public void addToReactions(User user, voteType v) {

//		if(commentMap.get(user) == v) {
//			commentMap.put(user, voteType.NOVOTE);
//		}

		commentMap.put(user, v);
	}

	public int getCommentKarma() {
		//ArrayList<voteType> reactions = (ArrayList<voteType>)commentMap.values();
		List<voteType> reactions = new ArrayList<voteType>(commentMap.values());

		int totalCommentKarma = 0;
		for(int i = 0; i < reactions.size(); i++) {
			voteType reaction = reactions.get(i);
			if(reaction == voteType.UPVOTE) {
				totalCommentKarma += 1;
			}
			else if(reaction == voteType.DOWNVOTE) {
				totalCommentKarma -= 1;
			}
		}
		totalKarma = totalCommentKarma;
		return totalCommentKarma;
	}
	
	public boolean addComment(String comment) {
		comments.add(new Comment(comment, userID));
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
	
	public boolean updateComment(int id, String newComment) {
		
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == id) {
				comments.get(i).commentTextMedia = newComment;
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
