Brackets

Write a Java program that checks if the brackets in the given expression are balanced. There are three sets of brackets - (), {} and []. These brackets can occur in any order. You are given an input string made up of only these 6 characters and your program must decide whether the given input string has all its brackets balanced. An input's strings brackets are not balanced if an (opening / closing) bracket does not have a corresponding (closing / opening) bracket of the same type.

Input Format

The first line of input contains a single integer N indicating the number of test cases.
The next N lines contain N test cases -- one per each line.
Each line represents one test case and has an input expression made up solely of these three types of opening and closing brackets. 

Output Format

Write a program to read each test case as input and decide whether the input expression has its brackets balanced or not. Print "Yes" if the brackets are balanced and print "No" if the brackets are not balanced.

Testcase 1
Input

3
({{[]([])}})
[{(()}]
{([])}}
Output

Yes
No
No
