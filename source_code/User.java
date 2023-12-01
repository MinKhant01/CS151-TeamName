package redditClone;
import java.text.SimpleDateFormat;
import java.util.*;



public class User {
	
    int userID;
    static int userCount = 0;
    String username;
    String password;
    String userLastName;
    String userFirstName;
    long timestamp;
    String displayTimeStamp;
    ArrayList<Content> userContent;
    ArrayList<Comment> comments;
    int totalKarma;
    //Page userPage;

    public User(String userName, String passWord, String firstName, String lastName){
    	
        userCount++;
        userID = userCount;
        username = userName;
        password = passWord;
        userFirstName = firstName;
        userLastName = lastName;

        @SuppressWarnings("unused")
		String displayTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        @SuppressWarnings("unused")
        long timeStamp = System.currentTimeMillis();
        userContent = new ArrayList<Content>();
    }
 

    // boolean displayUser();

    boolean makePost(String s){
        Content c = new Content(s, userID);
        userContent.add(c);
        return true;
    }

    boolean deletePost(int id) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == id){
                 userContent.remove(i);
                 break;
            }
        }
        return true;

    }

    boolean makeThread(String comment, int id) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == id){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));
                break;
            }
        }
        return true;

    }

    boolean makeComment(String comment, int contentID, int threadID) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == contentID){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment,userID));
                
                ArrayList<CommentThread> thread = c.getThread();

                for(int j = 0;  j < thread.size(); j++){
                    if(thread.get(j).getID() == threadID){
                        thread.get(j).add(new Comment(comment, userID));
                        break;
                    }
                }
                break;
            }
        }


        return true;

    }


    boolean updateCommentThread(String comment, int contentID, int threadID) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == contentID){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));

                ArrayList<CommentThread> thread = c.getThread();

                for(int j = 0;  j < thread.size(); j++){
                    if(thread.get(j).getID() == threadID){
                        thread.get(j).threadText = comment;
                        break;
                    }
                }
                break;
            }
        }


        return true;
    }

    boolean deleteCommentThread(String comment, int contentID, int threadID) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == contentID){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));

                ArrayList<CommentThread> thread = c.getThread();

                for(int j = 0;  j < thread.size(); j++){
                    if(thread.get(j).getID() == threadID){
                        thread.remove(threadID);
                        break;
                    }
                }
                break;
            }
        }


        return true;
    }
    
    public void sortByTime() {
	    Collections.sort(userContent, new Comparator<Content>() {
	        public int compare(Content c1, Content c2) {
	            return Long.compare(c2.contentPost.postTimeStamp, c1.contentPost.postTimeStamp);
	        }
	    });
	}
    
    public void sortByKarma() {
	    Collections.sort(userContent, new Comparator<Content>() {
	        public int compare(Content c1, Content c2) {
	            return Long.compare(c2.contentPost.totalKarma, c1.contentPost.totalKarma);
	        }
	    });
	}
    
    /**
     * This method is returns the total karma of the user overall with all the posts and comments
     * @return
     */
    
    public int getKarma() {
    	
    	int karma = 0;
    	for(int i = 0; i < comments.size(); i++) {
    		karma += comments.get(i).getCommentKarma();
    	}
    	
    	for(int i = 0; i < userContent.size(); i++) {
    		karma += userContent.get(i).contentPost.getPostKarma();
    	}
    	
    	return karma;
    }
    
    /**
     * This method will be triggered whenever the user reacts on something on the frontend for post
     * @param p
     * @param v
     */
    
    public void react(Post p, voteType v) {
    	p.addToReactions(this, v);
    }
    
    /**
     * This method will be triggered whenever the user reacts on something on the frontend for comment
     * @param p
     * @param v
     */
    
    public void react(Comment c, voteType v) {
    	c.addToReactions(this, v);
    }

}
