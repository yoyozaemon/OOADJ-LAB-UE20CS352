## Animal

**Problem Statement:**
 
- Create a class called Animal with a private attribute "name" and a method "speak()" that outputs "The animal [name] is making a sound". 
- Create two subclasses of Animal called Dog and Cat. Dog should have a private attribute "breed" and a method "speak()" that overrides the method from the superclass and outputs "The [breed] dog [name] is barking". Cat should have a private attribute "color" and a method "speak()" that overrides the method from the superclass and outputs "The [color] cat [name] is meowing". 
- Create an object of each subclass and call the speak() method on them.

**Input Format**

The first input line contains a single integer N indicating the number of test cases.
The next N lines of input contain N test cases -- one test case per line.
On each line, the test case is provided as input in the form of 3 values that occur in a space-separated manner as follows:

The first value indicates the type of animal (Dog / Cat). The second value provides the subclass specific attribute -- breed for dog or colour for cat. The third value specifies the name of the animal.

**Output Format**

For each test case, output a sentence in the following format:

The `[breed] [name]` is barking.
The `[colour] cat [name]` is meowing.

**Testcase 1**
**Input**
````
3
DOG LabradorRetriever Bailey
CAT white Mittens
DOG GermanShepherd Max
````
Output
````
The LabradorRetriever Bailey is barking.
The white cat Mittens is meowing.
The GermanShepherd Max is barking.
````