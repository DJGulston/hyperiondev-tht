# Section C: Code Challenge - Option 4 (International Standard Book Numbers)

## How to install the project

This solution was built in Java using JDK 17. In order to run this project, you will have to download and install JDK 17 on your local machine. You can download JDK 17 [here](https://www.oracle.com/za/java/technologies/downloads/#java17).

The project was specifically built using Eclipse IDE, but you can use any IDE of your choice. If you would also like to use Eclipse IDE, you can download the IDE [here](https://www.eclipse.org/downloads/).

Once your IDE is downloaded, you can create a new project and import the ISBN.java into your project.

## How to use the project

Once the ISBN.java file is imported into your Java project, simply click the run button in your IDE and you should see the results in your console.

## Worst-case Space Complexity

In the ISBN.java file, we have created the isbn13() function. The best-case space complexity in this function is O(1), when the user enters an invalid ISBN number that is not 10 characters, not 13 characters and does not begin with 978.

The worst-case space complexity is O(n + m) when the parameter passed to the isbn13() function is a valid ISBN-10 number. This is due to the fact that we are assigning a new digit_i character variable n times when we are checking if the parameter is a valid ISBN-10 number, and due to the fact that we are assigning a new digit_i character variable m times when we are adding to the isbn13Sum.

We can reduce the worst-case space complexity from O(n + m) to O(1) by removing the digit_i variable in each of the for loops, and replace all the references to the digit_i variable with its raw value instead (i.e. isbnOutput.charAt(i), and isbn.charAt(i)). However, this would reduce the readability and modularity of the code, since we would have to type out the raw value of the digit_i variable more than once in several areas of the code. And if for some reason that raw value for the digit_i variable had to change, we would have to change it in several areas of the code instead of just the one area of the code where we declared it.
