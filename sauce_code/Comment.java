package redditClone;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

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

	// int commentDownVote;
	// int commentUpVote;

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

	public boolean deleteCommentComment(int id) {

		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getCommentID() == id) {
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

	public int getCommentID() {
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

	public static void main(String[] args) {
		Comment c = new Comment("Hello World", 1);

		c.addComment(new Comment("Hello Wrld", 2));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Comment c3 = new Comment("Hello Wold", 3);
		c3.time = Long.MAX_VALUE;
		c.addComment(c3);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.addComment(new Comment("Hello Word", 4));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// c.addComment(new Comment("Hello Worl", 5));
		// System.out.println(c.getComment());
		System.out.print(c.deleteCommentComment(5));
		// System.out.print(c.comments.size());
		c.sortByTime();

		for (int i = 0; i < c.comments.size(); i++) {

			System.out.print(c.comments.get(i).commentCreatorID + " " + c.comments.get(i).time + " ");
		}

	}

}
