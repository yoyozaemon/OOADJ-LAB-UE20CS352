class Main {
  public static double getArea(double side) {
    return side * side;
  }
  public static double getArea(double length, double breadth) {
    return length * breadth;
  }
  public static double getArea(float radius){
      return 3.14 * radius * radius ;
  }
 
  public static void main(String[] args) {
    System.out.println("Area of square: " + getArea(10));
    System.out.println("Area of rectangle: " + getArea(10, 20));
    System.out.println("Area of circle: " + getArea(5));
  }
}
