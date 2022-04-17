<h1 align="center">Homework 1: First Android App</h1>
<h4 align="center">Points: 10</h4>

The purpose of this assignment is to get the first taste of Android application programming and use the 
Android Studio editor, as well as using widgets/views and events to produce an interactive graphical app.  
 
Before working on this or any assignment, you will need to set up the **Android Studio** IDE on your computer. You will create an Android project with the name **HW1_YOURNAME** by selecting Kotlin as the language. We suggest that you do this as early as possible, because some students may get stuck and need time to get the IDE set up. 
**Assignment Description:**
 
For this first assignment, we'll practice whatever topics we covered in the class. You should develop an app that has the following: 

1. Your app should be set up as an **Android Studio** project, so it can easily be opened/graded by others. 
2. In **MainActivity** you will display either a profile picture, populate listview under the image with your name, department, year using the **static (string.xml)** listing method.
3. Create a button named **Grade** and write intent to go **GradeActivity**. Here you will take the input score from editTextNumber and display letter grade in TextView once you click the Show **Grade** button. You will implement our grading policy in GradeActivity along with the **Back** button.
 
 x<70: F | 70≤x<73: C- | 73≤x<77: C
 |:--:|:--:|:--:
 **77≤x<80: C+** | **80≤x<83: B-** |	**83≤x<87: B**
 **87≤x<90: B+** | **90≤x<94: A-** | **94<x: A**

> For example, if you input 95 in editTextNumber, it will display **You got A grade** into the text view.
4. Create another button in **MainActivity** named **Discount** and go to activity **DiscountActivity**. In **DiscountActivity**, take your name and email id as input, hit the discount button, and generate a coupon. You have to implement saving and restoring the State in Layouts activity (Exercise 2.02). Saving and Restoring the State in Layouts for all the UI means if you rotate the screen, your state will not disappear. Your output for this activity will be like Figure 2.11 from the book.
5. Apply the material design to all the TextField like Figure 1.22 in the book.  
  
If you want help, please feel free to show your code to others or ask for help in our online discussion forum. Feel free to make an app as simple or as complex as you like, relative to your familiarity level and time constraints. If you work on your solution for a few hours and are still not done, you can turn it in, and we will award you credit. You can do it! 
 
### For uploading the project, you have to follow two steps:

1.  Create a folder name called **“Output”** inside the **HW1_YOURNAME folder**. Make a small video showing your program functionality in the emulator and show your code as well. 1~2 minutes video is fine. 
1.  Push your code with video in Github.
Your submission will be graded by watching the video or simply running the code and evaluating its functionality. It does not need to be perfect or bug-free to receive credit. Your code will not be graded on style, but we still encourage you to follow a good overall coding style for your own sake. 

If you have any confusion, please raise this issue before the class. I will try to clarify as much as possible. 

<h5>Grading Rubrics:</h5>

```diff
- Task 1 and 2: 2.5 points
- Task 3: 2.5 points
- Task 4: 3 points
- Task 5: 2 points
```

