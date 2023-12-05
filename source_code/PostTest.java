import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class PostTest {
    @Test
    public void PostTest(){
        Post post = new Post("test",1,1);
        assertEquals("test",post.getPostTextMedia());
    }

    @Test
    public void updatePost(){
        Post post = new Post("test",1,1);
        post.updatePost("test2");
        assertEquals("test2",post.getPostTextMedia());
    }

    @Test
    public void displayPost(){
        Post post = new Post("test",1,1);
        assertEquals(true,post.displayPost());
    }

    @Test
    public void addToReactions(){
        	Post post = new Post("test",1,1);
        	User user = new User("usus","pupu","Bit","Breakington");
        	post.addToReactions(user, voteType.UPVOTE);
        	assertEquals(voteType.UPVOTE, post.postMap.get(user));
    }

    @Test
    public void getPostKarma(){
    	Post post = new Post("test",1,1);
    	User user = new User("usus","pupu","Bit","Breakington");
    	post.addToReactions(user, voteType.UPVOTE);
    	assertEquals(1, post.getPostKarma());
    }

}
