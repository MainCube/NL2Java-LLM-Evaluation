class Solution { 
    public String clearStars(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        
        if (c == '*') {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(c);
        }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
        sb.append(stack.pop());
    }

    return sb.reverse().toString();


    }
}