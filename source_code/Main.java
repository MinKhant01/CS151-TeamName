package redditClone;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Interact interaction = new Interact();

        User currentUser = null;

        boolean exit = true;

        while(exit) {
            System.out.println();
            System.out.println("Please select an option: " );
            System.out.println("1. Create User" );
            System.out.println("2. Create Post" );
            System.out.println("3. Make a comment" );
            System.out.println("4. Upvote/Downvote Post" );
            System.out.println("5. Upvote/Downvote Comment" );
            System.out.println("6. Display Karma" );
            System.out.println("7. Exit Reddit" );
            System.out.print("Enter your option: " );

            int input = scanner.nextInt();

            switch(input) {
                case 1:
                  currentUser = interaction.createUser();
                  break;
                  
                case 2:
                    interaction.createPost(currentUser);
                    break;
                case 3:
                    System.out.println("Please enter post ID you want to comment on: " );
                    int postID = scanner.nextInt();
                    interaction.makePostReplyingComment(currentUser, postID);
                    break;
                case 4:
                    System.out.println("Please enter post ID you want to react to: " );
                    int postReact = scanner.nextInt();
                    interaction.reactPost(currentUser,postReact);
                    break;
                case 5:
                    System.out.println("Please enter post ID that the comment belongs to: " );
                    int postItem = scanner.nextInt();
                    System.out.println("Please enter comment ID you want to react to: " );
                    int commentReact = scanner.nextInt();
                    interaction.reactComment(currentUser,commentReact, postItem);
                    break;
                case 6:
                    interaction.getKarma(currentUser);
                    break;
                case 7:
                    exit = false;
                    break;
                default:
                    exit = false;
                    break;
            }







        }
    }



}


