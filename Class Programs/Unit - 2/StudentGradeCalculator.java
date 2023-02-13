package StudentGradeCal;
import java.util.Scanner;
import java.util.Arrays;

class Person
{
	String name;
	long mobileno;
	String EmailID;
	
	Person(String name,long mobileno,String EmailID)
	{
		this.name=name;
		this.mobileno=mobileno;
		this.EmailID=EmailID;
	}
	
	void display()
	{
		System.out.println("Display from super ");
	}
}

class student extends Person{
	
	String srn;
	int data[];
	float total=0, avg;
	
	student(String name,long mobileno,String email,String srn,int marks[])
	{
		super(name,mobileno,email);
		this.srn=srn;
		data = new int[marks.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = marks[i];
            
        }
       
	}
	
	void displayGrade()
	{
		for (int i = 0; i < data.length; i++) {
            total = total + data[i];
        }
		
		 avg = total/5;
	        System.out.print("The student Grade is: ");
	        if(avg>=80)
	        {
	            System.out.print("A");
	        }
	        else if(avg>=60 && avg<80)
	        {
	           System.out.print("B");
	        } 
	        else if(avg>=40 && avg<60)
	        {
	            System.out.print("C");
	        }
	        else
	        {
	            System.out.print("D");
	        }
	}
	
	@Override
	public String toString()
	{
		return("Student details are \n SRN="+this.srn+"\nName="+super.name+"\nEmailID="+super.EmailID);
	}
	
	void showData() {
        System.out.println(Arrays.toString(data));
        super.display();
    }
}

public class StudentGradeCalculator {

	public static void main(String[] args) {
		int marks[] = new int[5];
        int i;
        
        Scanner scanner = new Scanner(System.in);		
        
        for(i=0; i<5; i++) { 
           System.out.print("Enter Marks of Subject"+(i+1)+":");
           marks[i] = scanner.nextInt();           
        }
        scanner.close();
        String name="Aditi";
        long mobileno=9686283821L;
        String email="aditi@gmail.com";
        String srn="1PE21CS034";
        
        student sobj=new student(name,mobileno,email,srn,marks);
        
        System.out.println(sobj.toString()+"\n Student marks are:");
        sobj.showData();
        sobj.displayGrade();
        
    


	}

}
