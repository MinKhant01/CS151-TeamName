import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class CommentTest {
    @Test
    public void CommentTest(){
        Comment comment = new Comment("test",1);
        assertEquals("test",comment.getComment());
    }

    @Test
    public void updateComment(){
        Comment comment = new Comment("test",1);
        comment.updateComment("test2");
        assertEquals("test2",comment.getComment());
    }

    @Test
    public void addToReactions(){
    	Comment comment = new Comment("test",1);
    	User user = new User("usus","pupu","Bit","Breakington");
    	comment.addToReactions(user, voteType.UPVOTE);
    	assertEquals(voteType.UPVOTE, comment.commentMap.get(user));
    }

    @Test
    public void getCommentKarma(){
    	Comment comment = new Comment("test",1);
    	User user = new User("usus","pupu","Bit","Breakington");
    	comment.addToReactions(user, voteType.UPVOTE);
    	assertEquals(1, comment.getCommentKarma());
    }

    @Test
    public void sortByTime(){
    	//problem
    }

    @Test
    public void sortByKarma(){
    	//problem
    }
}
