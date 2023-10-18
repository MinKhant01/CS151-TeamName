# User Class
The User Class is our primary driver class that allows us to call and implement different methods.

Functionality:
1. Make a Post
2. Delete a post
3. Make a CommentThread (A comment replying to the post itself)
     a. Update a CommentThread (Update the comment replying to the post)
     b. Delete a CommentThread (Delete the comment replying to the post)
4. Make a comment (A comment replying to another comment)

User Class Notes:
- Problem: In our Sequence Diagram for making a comment to a post the function is called "makePostComment." However we renamed it to commentThread in our code. makePostComment is too vague because there are comments that reply to the post and there are comments that reply to another comment.
- Solution: Since every comment replying to a post creates a thread then we can have a seperate function that makes a commentThread and another function called makeComment that creates a comment replying to a comment.
- Thread: a thread of comment, meaning that it's a container to hold all the comments that are replying to each other. Since thread is already a keyword in java we renamed it to CommentThread instead. 

# PageFeed Class

In our Sequence Diagram it shows that the User Class will interact with the PageFeed Class in order to implement functions within different classes. PageFeed's purpose was to serve as an interface for the user to use and abstract the details away from the other classes. Since this is geared towards UX/UI design features instead we decided to hold from creating the class right now as it is unnecessary. 

# Content Class

Our Content Class acts as a platform to hold both our post object and our commentThread type arrayList.

Functionality:
1. Creates a post object and an arrayList of commentThreads.
2. Adds in new commentThreads when they're created
3. Sorts comments by time

Content Class Notes:
- Since a post can have multiple comments replying to it (commentThreads) we made an arrayList to contain all of them (contentThread)
- An arrayList allows us to continually add on new commments to the post as well

# Post Class

A simple class to create the post object. Contains text (string), contentID, userID, and a timeStamp for sorting.

Functionality:
1. Display Post
2. Update Post

# CommentThread Class

Every comment that responds to the post is a commentThread. This is because other comments can now reply to this comment. Thus each commentThread is just an ArrayList of comments replying to one another. 

Functionality:
1. Add a comment
2. Delete a comment
3. Update a comment
4. Display thread of comments
5. Sort by time
6. Get ThreadID

# Comment Class

The comment class represents the comments that are replying to other comments. Just like the commentThread we also have an ArrayList of comments replying to one another. The only distinction between the two is that commentThread replies directly to the post while the comment class replies to another comment thus functionality is primarily the same.


Functionality:
1. Add a comment
2. Delete a comment
3. Update a comment
4. Display comment text
5. Sort by time
6. Get CommentID

