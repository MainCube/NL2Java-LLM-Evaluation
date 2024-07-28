import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                stack.push(ch);
            } else {
                // '*' found, so we need to remove the smallest non-'*' character to the left
                // We pop the top of the stack as it represents the latest character added
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        
        // Building the result from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
