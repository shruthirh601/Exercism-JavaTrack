import java.util.*;
class BracketChecker {
     private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );
    
    private String expression;
    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (BRACKET_PAIRS.containsValue(c)) { 
                stack.push(c);
            } else if (BRACKET_PAIRS.containsKey(c)) { 
                if (stack.isEmpty() || stack.pop() != BRACKET_PAIRS.get(c)) {
                    return false; 
                }
            }
          
        }
        return stack.isEmpty(); 
    }
}