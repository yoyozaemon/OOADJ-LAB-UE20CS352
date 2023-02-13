
package abstarctclassesex;

abstract class MyClass
{
   public void disp()
   {
     System.out.println("Concrete method of parent class");
   }
   abstract public void disp2();
}

class xyz extends MyClass
{
     @Override
   public void disp2()
   {
       System.out.println("overriding abstract method");
   }   
   //abstract public void disp();   
}

public class AbstarctClassesEx 
{
   /* Must Override this method while extending
    * MyClas
    */  
   public static void main(String args[])
   {
       xyz obj = new xyz();
       obj.disp(); // calling non abstarct method of  using sub class object
       obj.disp2();
   }
}

/*

Abstract class declaration
An abstract class outlines the methods but not necessarily implements all the methods.

//Declaration using abstract keyword
abstract class A{
   //This is abstract method
   abstract void myMethod();

   //This is concrete method with body
   void anotherMethod(){
      //Does something
   }
}

Rules when we need abstarct classes
1. there are cases when it is difficult or often unnecessary to implement all the methods in parent class. 
In these cases, we can declare the parent class as abstract, which makes it a special class which is not complete on its own.

2.Abstract class cannot be instantiated which means you cannot create the object of it. To use this class, you need to create another
class that extends this this class and provides the implementation of abstract methods, then you can use the 
object of that child class to call non-abstract methods of parent class as well as implemented methods

3. If a child does not implement all the abstract methods of abstract parent class, 
then the child class must need to be declared abstract as well.

Why can’t we create the object of an abstract class?
Because these classes are incomplete, they have abstract methods that have no body so if java allows you to create object of 
this class then if someone calls the abstract method using that object then What would happen?There would be no actual 
implementation of the method to invoke.
Also because an object is concrete. An abstract class is like a template, so you have to extend it and build on it before you can use it.
*/