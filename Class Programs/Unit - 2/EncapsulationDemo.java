/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encapsulation;
import java.util.Scanner;

class Encapsulation{
    private int ssn;
    private String empName;
    private int empAge;
    
    

    //Getter and Setter methods
    /*public int getEmpSSN(){
        return ssn;
    }

    public String getEmpName(){
        return empName;
    }

    public int getEmpAge(){
        return empAge;
    }

    public void setEmpAge(int newValue){
        empAge = newValue;
    }

    public void setEmpName(String newValue){
        empName = newValue;
    }

    public void setEmpSSN(int newValue){
        ssn = newValue;
    }*/

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn1) {
        ssn = ssn1;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
    	
    	// Validating the employee's name and   
        // throwing an exception if the name is null or its length is less than or equal to 0.  
        if(empName == null ||  empName.length() <= 0)   
        {  
            throw new IllegalArgumentException("Name cannot be numm or empty!!!!!");  
        }  
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
    	if(empAge>35)
    	{
    		throw new IllegalArgumentException("Employee age cannot be more than 35!!!");
    	}
    else {
        this.empAge = empAge;
        }     
        
    }
    
 // for printing the values  
    @Override  
    public String toString()   
    {  
        String str = "Employee: [id = " + getSsn() + ", name = " + getEmpName() + ", Age = " + getEmpAge()  + "]";  
        return str;  
    }  
}
public class EncapsulationDemo{
    public static void main(String args[]){
    	
    	try {
         Encapsulation obj = new Encapsulation();
         obj.setEmpName("vaibhav");
         obj.setEmpAge(38);
         obj.setSsn(112233);
         System.out.println("Employee Name: " + obj.getEmpName());
         System.out.println("Employee SSN: " + obj.getSsn());
         System.out.println("Employee Age: " + obj.getEmpAge());
        
      /*  Scanner sc=new Scanner(System.in); 
       System.out.println("Enter the number of employees");
        int noOfEmployees=sc.nextInt();
        
        Encapsulation objs[]=null;
        
        for (int i=0;i<noOfEmployees;i++)
        {
            objs[i]=new Encapsulation();
            objs[i].setEmpAge(25);
            objs[i].setEmpName("axcvb");
            objs[i]
        }*/
         
      // Displaying the details of the employee details using the   
         // 'toString()' method, which uses the getter methods  
         System.out.println(obj.toString());  
    	}
    	catch(Exception e)
    	{
    		System.out.print("Error in data\n "+e.getMessage());
    	}
    	
    	}
    } 



/* notes

Getters and setters, also known as accessor and mutator in java, are the conventional methods used to retrieve and 
update the values of a variable, respectively. See this basic example below demonstrating a class with a private variable as 
getter and setter methods are used to set and get that private value:

1.	public class class01 {
2.	private int num1;
3.	public int getNum1() {
4.	return this.num1;
5.	}
6.	public void setNum1(int num) {
7.	this.num1 = num;
8.	}
9.	}

Class01 declares a private variable called num1. As num1 is a private variable, you cannot access the variable directly 
from the outside of the class, see the code below:

1.	Class01 obj = new class01();
2.	obj.num1 = 10; // It will prompt a compiler error, because num1 is private
3.	int num = obj.num1; // same as above
Now to get the value, you must invoke a getter, getNum1(), and the setter, setNum1(), to read or update the variable from outside, like this:

1.	Class01 obj = new class01();
2.	obj.setNum1(50); // This will work fine
3.	int num = obj.getNum1(); // This as well
Why do we need getters and setters in Java?
As mentioned earlier, the primary use of setter and getter is to maintain encapsulation. 
We require a setter method to update the value of a private variable from outside of the class and a getter method
 to read the value of that variable. It allows developers to control how the main variables in the code are accessed and updated. 


*/