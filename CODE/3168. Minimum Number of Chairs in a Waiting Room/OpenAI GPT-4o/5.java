class Solution {
    public int minimumChairs(String s) {
        int current = 0;
        int max_needed = 0;

        for (char c : s.toCharArray()) {
            if (c == 'E') {
                current++;
            } else if (c == 'L') {
                current--;
            }
            max_needed = Math.max(max_needed, current);
        }

        return max_needed;
    }
}
