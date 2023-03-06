## BankAccount

**Problem Statement:** 

- Create a class 'Account' that has a protected variable 'balance' and a method 'deposit' which takes in double 'amount' as an argument and adds it to the balance. It must also have a method for displaying the balance named getBalance.  
- Create a subclass of 'Account' called 'CheckingAccount' that has a method 'withdraw' which takes in double 'amount' as an argument and subtracts it from the balance.  
- Create a subclass of 'CheckingAccount' called 'SavingsAccount' that overrides the 'withdraw' method to check if the balance will be negative after the withdrawal.  
- If it is negative, print "Insufficient balance!" and do not subtract the amount from the balance.  
- Remember to create a constructor to initialize initial balance.

**Input Format**

The 3 lines will have initial balances for Account,CheckingAccount and SavingsAccount. The next line will have the number of test cases(n). The test case will be of the following format
`<account type> <operation> <money>`
After each testcase call the get balance method.
for example
````
"savings deposit 100.53"
"checking withdraw 76.54"
<balance Account>
<balance Checking account>
<balance Savings account>
n
<n lines>
````
Please refer to the test case for better clarity!

**Output Format**

The method getBalance must just print the balance.
In savings account , if the withdrawal isnt permitted , print "Insufficient balance!"
After all test cases are completed , print "fin"

**Testcase 1**
**Input**
````
3425
76353
872338
7
account deposit 100
checking withdraw 567
checking deposit 1000
checking withdraw 3476470
savings deposit 101
savings withdraw 69420
savings withdraw 32675323
````

**Output**
````
3525.0
75786.0
76786.0
-3399684.0
872439.0
803019.0
Insufficient balance!
803019.0
fin
````
