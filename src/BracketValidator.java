import java.util.Stack;

public class BracketValidator {
    public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char sym = expression.charAt(i);
            if (sym == '(') {
                stack.push(sym);
            }else if (sym == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] expressions = {
                "s * (s - a) * (s - b) * (s - c)", // Well
                "(- b + (b2 - 4*a*c)^0.5) / 2*a",  // Well
                "s * (s - a) * (s - b * (s - c)",  // ???
                "s * (s - a) * s - b) * (s - c)",  // ???
                "(- b + (b^2 - 4*a*c)^(0.5/ 2*a))" // ???
        };
        for (String expr : expressions) {
            System.out.println("Expression: " + expr);
            System.out.println("Valid: " + isValidExpression(expr));
            System.out.println();
        }
    }
}
