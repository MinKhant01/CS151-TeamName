package redditClone;

public class Content{
    private static int contentCounter = 0;
    private int contentID;                              //unique ID for a content (content = post + thread)
    private Post contentPost;                           //post for content
    private ArrayList<CommentThread> contentThread;      //thread for content

    //constructor for class Content
    public Content(String postTextMedia){
        contentCounter++;
        this.contentID = contentCounter;
        contentPost = new Post(postTextMedia,contentID);
        contentThread = new ArrayList<CommentThread>();
    }

    //getter for contentID
    public int getContentID(){
        return this.contentID;
    }

    //getter for contentThread arrayList
    public ArrayList<CommentThread> getThread(){
        return this.contentThread;
    }

    //method for adding commentThreads
    public boolean makePostComment(String commentText){
        this.contentThread.add(new CommentThread(commentText,this.contentID));
        return true;
    }


    //public boolean displayContent(){}                 Page class takes care of display function
    //deleteContent function in which class? user class?
}
