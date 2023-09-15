# GroupName
FL23 CS151 class project of bitBreakers with the following members
- Benjamin Le
- Vishwesh Dharmesh Mashruwala
- Edward Khant

We'll be creating a mock-up of Reddit. Below are the 3 phases:

Phase 1: Minimum Viable Product

Phase 2: Karma and Upvotes

Phase 3: UI and 3 pages

Extra Credit Potential (+15%)

Project Discussion: Minimum Viable Product
- Needs to implement CRUD (Create, Read, Update, Delete) for Users, Posts, and Comments.
- Posts can only be text posts for now
- Don’t worry about storage or database connections
- You can sort them based on time created (need to make time stamps)
- Comments should be able to be associated with the posts and other comments (like you should be able to reply to comments) and associated with the users that made the comments

Deliverables for phase 1:
- UML Diagrams to explain class design 
- Working Java code that can do basic code (based on MVP Above)
- Each phase is 1 month long 
- UML Diagram needs to be submitted every 2 weeks
- Java code is due in 4 weeks (or 2 weeks after the UML diagram)

Deliverables for Phase 2:
- Create Upvotes/Downvotes -> make Upvotes/Downvotes for posts and comments 
- Create “Karma” that’s associated with their posts/comments

  - sum total of upvotes - downvotes on a post/commments
  
- Working UML Diagram to explain class design 
- Working code with new constraints (below)

Constraints
- 1 user should only be able to up/down vote a post/comment once
- User Karma = Sum of Karma of each user post/comment
- Now that we have karma we can choose between sorting between users/comments/posts based on date created (the time stamp) / karma
- Create filters for users, comments, and posts

Deliverables for Phase 3:
- We’ll be creating a UI using JavaFX or Swing to see all of our code
- We want to develop 3 pages:
  
          1. “Home” pages that lists posts (sorted by date/karma)
  
            - Like the front page of reddit
  
          2. “Comments” page that lists comments associated with posts (sorted by date/karma)
  
            -  Similar to a ladder format like reddit
  
          3. “Users” page that lists users (sorted by date/karma)
  
            -  basically a leader board for users that first signed up and those that have the most karma
  
- Usual UML Diagram to explain class diagram
- Working Java Code that adheres to containers
- Project Presentation 

Possible stretch goals: +5% Extra Credit for each stretch goal (+15% EC total)
- Implement support for pictures/gifs
- Users should be able to set up profile pictures
- Users should be able to reply with comments that are pictures/ gifs
- Users should enable topmost image/gif posts

