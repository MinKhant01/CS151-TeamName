import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class UserTest {
    @Test
    public void createUser(){
        User user = new User("usus","pupu","Bit","Breakington");
        assertEquals("usus",user.username);
        assertEquals("pupu",user.password);
        assertEquals("Bit",user.userFirstName);
        assertEquals("Breakington",user.userLastName);
    }

    @Test
    public void makePost(){
        User user = new User("bitBreakers","It3aB1tBr34k3r!","Bit","Breakington");
        user.makePost("testing for makePost");
        assertEquals("testing for makePost",user.userContent.get(0).getContentPost().getPostTextMedia());
    }

    @Test
    public void deletePost(){
        User user = new User("usus","pupu","Bit","Breakington");
        user.makePost("testing for deletePost");
        user.deletePost(1);
        assertEquals(0,user.userContent.size());
    }

    @Test
    public void makeThread(){
        User user = new User("usus","pupu","Bit","Breakington");
        user.makePost("testing for makeThread");
        user.makeThread("test for makeThread",1);
        assertEquals("test for makeThread",user.userContent.get(0).getContentThread().get(0).getThreadText());
    }

    @Test
    public void makeComment(){

    }

    @Test
    public void updateCommentThread(){

    }

    @Test
    public void deleteCommentThread(){

    }

    @Test
    public void sortContentByTime(){
        try{
            User user1 = new User("A","123","aa","AA");
            TimeUnit.SECONDS.sleep(1);
            user1.makePost("post1");
            TimeUnit.SECONDS.sleep(1);
            user1.makePost("post2");
            TimeUnit.SECONDS.sleep(1);
            user1.makePost("post3");

            user1.sortContentByTime();

            assertEquals("post3",user1.userContent.get(0).getContentPost().getPostTextMedia());
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void sortContentByKarma(){
        User user1 = new User("A","123","aa","AA");
        User user2 = new User("B","123","bb","BB");
        User user3 = new User("C","123","cc","CC");

        user1.makePost("post1");
        user1.makePost("post2");
        user1.makePost("post3");

        user1.react(user1.userContent.get(0).getContentPost(), voteType.UPVOTE);
        user2.react(user1.userContent.get(0).getContentPost(), voteType.UPVOTE);
        user3.react(user1.userContent.get(0).getContentPost(), voteType.UPVOTE);

        user1.react(user1.userContent.get(1).getContentPost(), voteType.UPVOTE);
        user2.react(user1.userContent.get(1).getContentPost(), voteType.DOWNVOTE);
        user3.react(user1.userContent.get(1).getContentPost(), voteType.DOWNVOTE);

        user1.react(user1.userContent.get(2).getContentPost(), voteType.DOWNVOTE);
        user2.react(user1.userContent.get(2).getContentPost(), voteType.DOWNVOTE);
        user3.react(user1.userContent.get(2).getContentPost(), voteType.DOWNVOTE);

        user1.sortContentByKarma();
        assertEquals("post1",user1.userContent.get(0).getContentPost().getPostTextMedia());
    }

    @Test
    public void getKarma(){
    	User user1 = new User("A","123","aa","AA");
        User user2 = new User("B","123","bb","BB");
        User user3 = new User("C","123","cc","CC");

        user1.makePost("post1");
        user1.makePost("post2");
        user1.makePost("post3");

        user1.react(user1.userContent.get(0).getContentPost(), voteType.UPVOTE);
        user2.react(user1.userContent.get(0).getContentPost(), voteType.UPVOTE);
        user3.react(user1.userContent.get(0).getContentPost(), voteType.UPVOTE);

        user1.react(user1.userContent.get(1).getContentPost(), voteType.UPVOTE);
        user2.react(user1.userContent.get(1).getContentPost(), voteType.DOWNVOTE);
        user3.react(user1.userContent.get(1).getContentPost(), voteType.DOWNVOTE);

        user1.react(user1.userContent.get(0).getContentPost(), voteType.DOWNVOTE);
        user2.react(user1.userContent.get(0).getContentPost(), voteType.DOWNVOTE);
        user3.react(user1.userContent.get(0).getContentPost(), voteType.DOWNVOTE);

        assertEquals(-2, user1.getKarma());
    }

}
