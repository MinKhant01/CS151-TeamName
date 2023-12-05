import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;


public class CommentThreadTest {
    @Test
    public void CommentThreadTest(){
        CommentThread commentThread = new CommentThread("test",1);
        assertEquals("test",commentThread.getThreadText());
    }

    //write test methods for each method in class Comment Thread
    @Test
    public void addComment(){
        CommentThread commentThread = new CommentThread("test",1);
        Comment comment = new Comment("test",1);
        commentThread.add(comment);
        assertEquals("test",commentThread.comments.get(0).getComment());
    }

    @Test
    public void addToReactions(){
    	CommentThread commentThread = new CommentThread("test",1);
    	User user = new User("usus","pupu","Bit","Breakington");
    	commentThread.addToReactions(user, voteType.UPVOTE);
    	assertEquals(voteType.UPVOTE, commentThread.commentMap.get(user));
    }

    @Test
    public void getCommentKarma(){
    	CommentThread commentThread = new CommentThread("test",1);
    	User user = new User("usus","pupu","Bit","Breakington");
    	commentThread.addToReactions(user, voteType.UPVOTE);
    	assertEquals(1, commentThread.getCommentKarma());
    }

    @Test
    public void addCommentTest(){
    	CommentThread commentThread = new CommentThread("test",1);
    	commentThread.addComment("test");
    	assertEquals("test", commentThread.comments.get(0).getComment());
    }

    @Test
    public void updateComment(){
        CommentThread commentThread = new CommentThread("test",1);
        commentThread.addComment("test");
        commentThread.updateComment(1, "test2");
        assertEquals("test2", commentThread.comments.get(0).getComment());
    }

    @Test
    public void deleteThreadComment(){
        	CommentThread commentThread = new CommentThread("test",1);
        	commentThread.addComment("test");
        	commentThread.deleteThreadComment(1);
        	assertEquals(0, commentThread.comments.size());
    }

    @Test
    public void sortCommentByTime(){
    	//how are we sorting this again?
    }


}
