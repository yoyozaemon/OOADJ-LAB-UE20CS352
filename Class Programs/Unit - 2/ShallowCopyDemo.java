package CopyConstructorDemo;

import java.util.Arrays;

/*When we do a copy of some entity to create two or more than two entities such that 
 * changes in one entity are reflected in the other entities as well, then we can say we 
 * have done a shallow copy. In shallow copy, new memory allocation never happens for the 
 * other entities, and the only reference is copied to the other entities. The following 
 * example demonstrates the same. 
 */

class SCopy1 
{  
// instance variable of the class ABC  
int x = 30;  
}  


//code illustrating shallow copy
class Ex {

  private int[] data;

  // makes a shallow copy of values
   Ex(int[] values) {
      data = values;
  }

  void showData() {
      System.out.println( Arrays.toString(data) );
  }
}

//Deep Copy 

class Ex1 {
    
    private int[] data;
  
    // altered to make a deep copy of values
    Ex1(int[] values) 
    {
        data = new int[values.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = values[i];
        }
    }
  
    void showData() {
        System.out.println(Arrays.toString(data));
    }


}
public class ShallowCopyDemo {

	public static void main(String[] args) {
		SCopy1 obj1 = new SCopy1();  
		  
		// it will copy the reference, not value  
		SCopy1 obj2 = obj1;  
		  
		// updating the value to 6   
		// using the reference variable obj2  
		obj2.x = 6;  
		  
		// printing the value of x using reference variable obj1   
		System.out.println("The value of x is: " + obj1.x);  
		
		System.out.println("shallow copy");  
		
		/*shallow copy*/
		int[] vals = {3, 7, 9};
        Ex e = new Ex(vals);
        e.showData(); // prints out [3, 7, 9]
        vals[0] = 13;
        e.showData(); // prints out [13, 7, 9]
        System.out.println("deep Copy");  
		
        /*deep Copy*/
        int[] vals1 = {3, 7, 9};
        Ex1 e1 = new Ex1(vals1);
        e1.showData(); // prints out [3, 7, 9]
        vals1[0] = 13;
        e1.showData(); // prints out [3, 7, 9]
        //System.out.println(Arrays.toString(vals1));
        

	}

}
