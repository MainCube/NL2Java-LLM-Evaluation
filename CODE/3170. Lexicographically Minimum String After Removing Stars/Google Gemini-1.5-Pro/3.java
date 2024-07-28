import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                // If it's a '*', remove the smallest preceding character
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else {
                // Otherwise, push the character onto the stack
                stack.push(c);
            }
        }

        // Construct the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}