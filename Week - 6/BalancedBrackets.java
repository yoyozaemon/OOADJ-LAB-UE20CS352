import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner pes2ug20cs815 = new Scanner(System.in);
        int t = pes2ug20cs815.nextInt();
        pes2ug20cs815.nextLine(); 

        while (t-- > 0) {
            String s = pes2ug20cs815.nextLine();
            if (isBalanced(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        pes2ug20cs815.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

