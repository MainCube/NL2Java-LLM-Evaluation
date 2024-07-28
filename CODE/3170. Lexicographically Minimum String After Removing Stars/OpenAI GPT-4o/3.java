import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // We need to remove the top element from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push the character onto the stack
                stack.push(ch);
            }
        }
        
        // Build the resulting string from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
