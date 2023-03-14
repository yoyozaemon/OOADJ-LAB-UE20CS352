import java.util.*;

public class PostfixEvaluator {
    
    public static int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner pes2ug20cs815 = new Scanner(postfix);

        while (pes2ug20cs815.hasNext()) {
            if (pes2ug20cs815.hasNextInt()) {
                stack.push(pes2ug20cs815.nextInt());
            } else {
                int b = stack.pop();
                int a = stack.pop();
                String operator = pes2ug20cs815.next();
                int result = 0;
                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }
                stack.push(result);
            }
        }
        pes2ug20cs815.close();
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String postfix = input.nextLine();
        int result = evaluate(postfix);
        System.out.println(+ result);
        input.close();
    }
}

