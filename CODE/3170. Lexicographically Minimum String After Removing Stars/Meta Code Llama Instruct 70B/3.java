class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        
        return result;
    }
}
