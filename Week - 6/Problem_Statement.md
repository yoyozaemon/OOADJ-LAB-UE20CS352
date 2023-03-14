## Evaluate postfix expression

You are given a postfix arithmetic expression. Evaluate the expression using a stack. The operators used are `'+' , '-' , '/' and '*'.` Each operand WILL be an integer. Represent the final answer as an Integer.
The division between two integers always truncates towards zero `(type cast the result to 'int' , Example : 5/2 = 2)`

**For your reference**
``(a+b)*c is represented in postfix as :
ab+c*
`` 
  
**Input Format**
The postfix expression is the input , which is a single line , with a space separating each token.  
**for example**  
`12 13 + 18 *`

**Output Format**


The result of the expression , which is an expression.  
For the above example  
The answer is `((12+13)*18) = 450`

**Testcase 1**  
**Input**
```
4 13 5 / +
```
**Output**
```
6
```
