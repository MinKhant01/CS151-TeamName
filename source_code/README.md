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

Our Content Class acts as a platform to hold both our post object and our commentThread arrayList.

Functionality:
1. Creates a post object and an arrayList of commentThreads.
2. Adds in new commentThreads when they're created
3. Sorts comments by time

Content Class Notes:
- Since a post can have multiple comments replying to it (commentThreads) we made an arrayList to contain all of them (contentThread)
- An arrayList allows us to continually add on new commments to the post as well

# 

