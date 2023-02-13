package abstarctmethodex;
//abstract class

abstract class Sum {

    /* These two are abstract methods, the child class
    /* These two are abstract methods, the child class
    * must implement these methods
     */
    abstract int sumOfTwo(int n1, int n2);

    abstract int sumOfThree(int n1, int n2, int n3);

    //Regular method 
    public void disp() {
        System.out.println("Method of class Sum");
    }
}

public class AbstarctMethodEx extends Sum {

    /* If I don't provide the implementation of these two methods, the
    * program will throw compilation error.
     */
    int sumOfTwo(int num1, int num2) {
        return num1 + num2;
    }

    int sumOfThree(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    public static void main(String args[]) {
        Sum obj = new AbstarctMethodEx();
        System.out.println(obj.sumOfTwo(3, 7));
        System.out.println(obj.sumOfThree(4, 3, 19));
        obj.disp();
    }
}
