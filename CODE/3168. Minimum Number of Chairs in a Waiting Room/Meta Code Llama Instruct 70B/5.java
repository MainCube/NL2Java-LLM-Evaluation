class Solution {
    public int minimumChairs(String s) {
        Stack<Character> stack = new Stack<>();
        int numChairs = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    numChairs++;
                }
            }
        }
        
        return numChairs + stack.size();
    }
}
