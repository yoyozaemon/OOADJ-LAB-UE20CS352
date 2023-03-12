import java.util.*;
import java.text.*;

public class Calculator{
    DecimalFormat df = new DecimalFormat("#.##");
    public int add(int a,int b)
    {
        return a+b;
    }
    public float add(float a,float b)
    {
        float result=a+b;
        return Float.parseFloat(df.format(result));
    }
    public float add(float a,int b)
    {
        float result=a+b;
        return Float.parseFloat(df.format(result));
    }
    public String add(String a,String b)
    {
        return a+b;
    }
    public int round(float num)
    {
        return Math.round(num);
    }
    public int round(float num,boolean roundUp)
    {
        if(roundUp)
        {
            return(int) Math.ceil(num);
        }
        else
        {
            return(int) Math.floor(num);
        }
    }
    public static void main(String args[])
    {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        System.out.println(calc.add(scan.nextInt(),scan.nextInt()));
        System.out.println(calc.add(scan.nextFloat(),scan.nextFloat()));
        System.out.println(calc.add(scan.nextFloat(),scan.nextInt()));
        System.out.println(calc.add(scan.next(),scan.next()));
        System.out.println(calc.round(scan.nextFloat()));
        System.out.println(calc.round(scan.nextFloat(),scan.nextBoolean()));
        System.out.println(calc.round(scan.nextFloat(),scan.nextBoolean()));
    }
}

