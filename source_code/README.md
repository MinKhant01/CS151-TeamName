Our user class will be the diver class that allows us to do a few things:
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

In our Sequence Diagram it shows that 

The Content Class is what holds our post and thread together
