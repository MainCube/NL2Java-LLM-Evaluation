class Solution {
    public int numberOfChild(int n, int k) {
        // Handle the case where the ball stays within the initial range
        if (k < n) {
            return k;
        }

        // Calculate the number of complete cycles the ball makes
        int cycles = (k - (n - 1)) / (2 * (n - 1));

        // Adjust k to represent the remaining time after the complete cycles
        k -= cycles * 2 * (n - 1);

        // Determine the ball's position and direction after the remaining time
        if (k == 0) {
            return n - 1; // Ball ends at the rightmost child
        } else if (k <= n - 1) {
            return k; // Ball is moving rightward
        } else {
            return 2 * (n - 1) - k; // Ball is moving leftward
        }
    }
}