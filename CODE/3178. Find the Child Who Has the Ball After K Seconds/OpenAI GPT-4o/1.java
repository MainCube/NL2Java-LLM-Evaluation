class Solution {
    public int numberOfChild(int n, int k) {
        int position = 0; // Start from child 0
        int direction = 1; // Initial direction is right
        
        for (int i = 1; i <= k; i++) {
            position += direction;
            
            // If we hit the left end, reverse the direction to right
            if (position == 0) {
                direction = 1;
            }
            // If we hit the right end, reverse the direction to left
            else if (position == n - 1) {
                direction = -1;
            }
        }
        
        return position;
    }
}
