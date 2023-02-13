
package abstractclasscannotcreateobj;

abstract class AbstractDemo
{
   public void myMethod()
   {
      System.out.println("Hello");
   }
   abstract public void anotherMethod();
}


public class AbstractClassCannotCreateObj extends AbstractDemo
{

   public void anotherMethod() 
   { 
        System.out.print("Abstract method"); 
   }
   public static void main(String args[])
   { 
      //error: You can't create object of it
      AbstractDemo obj = new AbstractDemo();
      obj.anotherMethod();
   }
}