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
    Thread[] userThread;
    // Page userPage;

    public User(String userName, String passWord, String firstName, String lastName) {
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

    boolean makePost(String s) {
        Content c = new Content(s, userID);
        userContent.add(c);
        return true;
    }

    boolean deletePost(int id) {

        for (int i = 0; i < userContent.size(); i++) {
            if (userContent.get(i).getContentID() == id) {
                userContent.remove(i);
                break;
            }
        }
        return true;

    }

    boolean makeThread(String comment, int id) {

        for (int i = 0; i < userContent.size(); i++) {
            if (userContent.get(i).getContentID() == id) {
                Content c = userContent.get(i);
                // get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));
                break;
            }
        }
        return true;

    }

    boolean makeComment(String comment, int contentID, int threadID) {

        for (int i = 0; i < userContent.size(); i++) {
            if (userContent.get(i).getContentID() == contentID) {
                Content c = userContent.get(i);
                // get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));

                ArrayList<CommentThread> thread = c.getThread();

                for (int j = 0; j < thread.size(); j++) {
                    if (thread.get(j).getID() == threadID) {
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

        for (int i = 0; i < userContent.size(); i++) {
            if (userContent.get(i).getContentID() == contentID) {
                Content c = userContent.get(i);
                // get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));

                ArrayList<CommentThread> thread = c.getThread();

                for (int j = 0; j < thread.size(); j++) {
                    if (thread.get(j).getID() == threadID) {
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

        for (int i = 0; i < userContent.size(); i++) {
            if (userContent.get(i).getContentID() == contentID) {
                Content c = userContent.get(i);
                // get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment, userID));

                ArrayList<CommentThread> thread = c.getThread();

                for (int j = 0; j < thread.size(); j++) {
                    if (thread.get(j).getID() == threadID) {
                        thread.remove(threadID);
                        break;
                    }
                }
                break;
            }
        }

        return true;
    }

}
