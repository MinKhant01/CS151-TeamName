package redditClone;

import java.util.Scanner;

public class Interact {
    int postCounter = 0;
    int commentCounter = 0;
    Scanner scanner = new Scanner(System.in);
    public User createUser() {
        System.out.println("Enter username: ");
        String userName = scanner.next();

        System.out.println("Enter password: ");
        String passWord = scanner.next();

        System.out.println("Enter first name: ");
        String firstName = scanner.next();

        System.out.println("Enter last name: ");
        String lastName = scanner.next();

        User user1 = new User(userName, passWord, firstName, lastName);

        return user1;
    }

    public boolean createPost(User currentUser) {

        System.out.println("Put in some text to make a post!: ");
        String textPost = scanner.next();

        postCounter++;
        System.out.println("The ID for this post is: " + postCounter);

        return currentUser.makePost(textPost);
    }

    //this method replies directly to the post itself thus uses commentThread class
    public boolean makePostReplyingComment(User currentUser, int postID){
        System.out.println("Put in some text to make a comment!: ");
        String textComment = scanner.next();

        commentCounter++;
        System.out.println("The ID for this comment is: " + commentCounter);

        return currentUser.makeThread(textComment, postID);
    }

    public void reactPost(User currentUser, int postID) {
        System.out.println("Pick a vote reaction: ");
        System.out.println("1. Upvote ");
        System.out.println("2. Downvote ");

        int input = scanner.nextInt();

        //get contentPost from content

        if(input == 1) {
            //the current user has an arrayList of contents
            //go into the arrayList of content and grab the one that has the same postID
            //since the arrayList is 0 based we need to subtract 1 from postID
            //once we have the specific content then get the Post object since react uses Post object as a parameter
            currentUser.react(currentUser.userContent.get(postID-1).contentPost, voteType.UPVOTE);
        }

        else if(input == 2) {
            currentUser.react(currentUser.userContent.get(postID-1).contentPost, voteType.DOWNVOTE);
        }
        else{
            currentUser.react(currentUser.userContent.get(postID-1).contentPost, voteType.NOVOTE);
        }
    }

    public void reactComment(User currentUser, int postID, int commentID) {
        System.out.println("Pick a vote reaction: ");
        System.out.println("1. Upvote ");
        System.out.println("2. Downvote ");

        int input = scanner.nextInt();

        //get contentPost from content

        if(input == 1) {
            //the current user has an arrayList of contents
            //go into the arrayList of content and grab the one that has the same postID
            //since the arrayList is 0 based we need to subtract 1 from postID
            //once we have the specific content then get the Post object since react uses Post object as a parameter
            //need postID to get the post associated with the comment
            //go into the thread of comments to find the specific comment using comment ID
           // currentUser.react(currentUser.userContent.get(postID-1).contentThread.get(commentID-1).comments.get(commentID-1), voteType.UPVOTE);
             currentUser.react(currentUser.userContent.get(postID-1).contentThread.get(commentID-1), voteType.UPVOTE);
        }

        else if(input == 2) {
            currentUser.react(currentUser.userContent.get(postID-1).contentThread.get(commentID-1), voteType.DOWNVOTE);
        }
        else if(input == 3) {
            currentUser.react(currentUser.userContent.get(postID-1).contentThread.get(commentID-1), voteType.NOVOTE);
        }
    }

    public void getKarma(User currentUser) {
        System.out.println("Pick what you want to get karma for: ");
        System.out.println("1. Post ");
        System.out.println("2. Comment ");
        int karmaInput = scanner.nextInt();

       if (karmaInput == 1) {
            System.out.println("What is the ID of the post?: ");
            int postID = scanner.nextInt();
            System.out.println("Post Karma is: " + currentUser.userContent.get(postID - 1).contentPost.getPostKarma());
        }
        else{
            System.out.println("Please enter post ID that the comment belongs to: " );
            int wantedPost = scanner.nextInt();
            System.out.println("What is the ID of the comment?: " );
            int wantedComment = scanner.nextInt();
            System.out.println("Comment Karma is: " + currentUser.userContent.get(wantedPost-1).contentThread.get(wantedComment-1).getCommentKarma());

        }
    }
}
