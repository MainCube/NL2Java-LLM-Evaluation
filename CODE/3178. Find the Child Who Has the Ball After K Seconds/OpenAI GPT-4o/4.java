class Solution {
    public int numberOfChild(int n, int k) {
        int current_position = 0;
        int direction = 1; // 1 for right, -1 for left

        for (int i = 0; i < k; i++) {
            current_position += direction;
            if (current_position == n - 1) {
                direction = -1; // reverse to left
            } else if (current_position == 0) {
                direction = 1; // reverse to right
            }
        }
        
        return current_position;
    }
}
