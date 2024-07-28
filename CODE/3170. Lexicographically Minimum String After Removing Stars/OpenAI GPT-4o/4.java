class Solution {
    public String clearStars(String s) {
        // Initialize a stack to store characters
        Stack<Character> stack = new Stack<>();
        
        // Iterate over each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // If the character is '*', pop the top element of the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // If the character is not '*', push it onto the stack
                stack.push(ch);
            }
        }
        
        // Build the resulting string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Convert StringBuilder to String and return
        return result.toString();
    }
}
