class Solution {
    public String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.setLength(sb.length() - 1);
                }
            } else {
                stack.push(c);
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
