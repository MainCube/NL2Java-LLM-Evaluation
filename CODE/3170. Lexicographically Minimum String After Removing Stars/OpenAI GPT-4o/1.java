class Solution {
    public String clearStars(String s) {
        // Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Traverse the string character by character
        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                // Push non-'*' characters to the stack
                stack.push(ch);
            } else {
                // When '*' is found, pop the smallest character to its left
                // The stack should have at least one character
                if (!stack.isEmpty()) {
                    stack.pop();
                }
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
