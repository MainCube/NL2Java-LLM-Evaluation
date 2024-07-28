import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                // If it's a '*', remove the smallest preceding non-'*' character
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the '*' itself
                    findAndRemoveSmallest(stack);
                }
            } else {
                // If it's not a '*', push it onto the stack
                stack.push(c);
            }
        }

        // Construct the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    private void findAndRemoveSmallest(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return; 
        }

        // Find the smallest character in the stack
        char smallest = 'z';
        int smallestIndex = -1;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) < smallest) {
                smallest = stack.get(i);
                smallestIndex = i;
            }
        }

        // Remove the smallest character
        if (smallestIndex != -1) {
            stack.remove(smallestIndex);
        }
    }
}