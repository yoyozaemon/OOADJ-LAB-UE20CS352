
package constructorexample1;
class myConstructor
{
    //this is constructor
    myConstructor()
    {
        System.out.println("Default constructor is called on creation of object");
    }
}
public class ConstructorExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        myConstructor Obj1=new myConstructor();
    }
    
}

/*
public class Hello {
   String name;
   //Constructor
   Hello(){
      this.name = "google.com";
   }
   public static void main(String[] args) {
      Hello obj = new Hello();
      System.out.println(obj.name);
   }
}

*/