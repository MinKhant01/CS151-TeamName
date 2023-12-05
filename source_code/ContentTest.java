import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class ContentTest {
    @Test
    public void ContentTest(){
        Content content = new Content("test",1);
        assertEquals("test",content.getContentPost().getPostTextMedia());
    }

    @Test
    public void makePostComment(){
        Content content = new Content("test",1);
        content.makePostComment("test");
        assertEquals("test",content.getContentThread().get(0).getThreadText());
    }

    @Test
    public void sortByTime(){
        //what really are we sorting here again?
    }
}
