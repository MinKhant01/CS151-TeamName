package redditClone;
import java.text.SimpleDateFormat;
import java.util.*;

public class Comment{

	static int commentCount = 0;
	int commentID = 0;
	int commentCreatorID;
	String commentCreatorUsername;
	String commentTextMedia;
	int commentRefPostID;
	int commentRefPostUserID;
	String timeStamp;
	long time;
	int totalKarma;
	
	ArrayList<Comment> comments;
	
	/**
	 * This is to keep track of user reactions on the comment
	 */
	HashMap<User, voteType> commentMap = new HashMap<>();
	
	
//	int commentDownVote;
//	int commentUpVote;
	
	public Comment(String text, int creatorID) {
		
		commentCount++;
		commentID = commentCount;
		commentTextMedia = text;
		commentCreatorID = creatorID;
		comments = new ArrayList<>();
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		time = System.currentTimeMillis(); 
		
	}
	
	public String getComment() {
		return commentTextMedia;
	}
	
	public boolean deleteCommentComment(int topId, Comment comment) {
	
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == topId) {
				comments.remove(comment);
				break;
			}
		}
		return true;
	}
	
	public boolean addCommentonComment(int id, String comment, int creatorId) {
			for(int i = 0; i < comments.size(); i++) {
				if(comments.get(i).getCommentID() == id) {
					comments.get(i).addComment(new Comment(comment, creatorId));
					break;
				}
			}
			return true;
		}
	
	public boolean upDateCommentonComment(int id, String comment) {
		for(int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getCommentID() == id) {
				comments.get(i).updateComment(comment);
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
	
	public boolean addComment(Comment C) {
		comments.add(C);
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
	
	public void sortByKarma() {
	    Collections.sort(comments, new Comparator<Comment>() {
	        public int compare(Comment c1, Comment c2) {
	            return Long.compare(c2.totalKarma, c1.totalKarma);
	        }
	    });
	}
	
	
	
	
	 /**
     * This method add reactions of a particular user on a particular comment
     * @param u
     * @param v
     */
	
	public void addToReactions(User user, voteType v) {
		
//		if(commentMap.get(user) == v) {
//			commentMap.put(user, voteType.NOVOTE);
//		}
		
		commentMap.put(user, v);
	}
	
	/**
	 * This method return the karma on a particular comment
	 * @return
	 */
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

	
	
//	public static void main(String[] args) {
//		Comment c = new Comment("Hello World", 1);
//		
//		 c.addComment(new Comment("Hello Wrld", 2));
//		 try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 Comment c3 = new Comment("Hello Wold", 3);
//		 c3.time = Long.MAX_VALUE;
//		 c.addComment(c3);
//		 try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		 c.addComment(new Comment("Hello Word", 4));
//		 try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		//c.addComment(new Comment("Hello Worl", 5));
//		//System.out.println(c.getComment());
//		System.out.print(c.deleteCommentComment(5));
//		//System.out.print(c.comments.size());
//		c.sortByTime();
//		
//		for(int i = 0; i < c.comments.size(); i++) {
//			
//			System.out.print(c.comments.get(i).commentCreatorID + " " + c.comments.get(i).time + " ");
//		}
//		
//		
//		
//	}

}
