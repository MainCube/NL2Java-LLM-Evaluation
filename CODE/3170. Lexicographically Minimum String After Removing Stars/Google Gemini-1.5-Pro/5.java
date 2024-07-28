import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                // If it's a '*', remove the smallest non-'*' character to its left
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the '*' itself
                    // Find and remove the smallest character to the left
                    int smallestIndex = -1;
                    char smallestChar = 'z' + 1; // Initialize with a value larger than any lowercase letter
                    for (int i = 0; i < stack.size(); i++) {
                        if (stack.get(i) < smallestChar) {
                            smallestChar = stack.get(i);
                            smallestIndex = i;
                        }
                    }
                    if (smallestIndex != -1) {
                        stack.remove(smallestIndex);
                    }
                }
            } else {
                // If it's not a '*', push it onto the stack
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