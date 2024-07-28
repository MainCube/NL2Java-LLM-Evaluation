import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        // Build the resulting string from the characters left in the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}
