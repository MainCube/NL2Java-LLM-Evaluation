class Solution {
    public int numberOfChild(int n, int k) {
        // Calculate the total distance the ball travels in one complete cycle (from child 0 to n-1 and back).
        int cycleDistance = (n - 1) * 2; 

        // Calculate the remaining seconds after all the complete cycles.
        int remainingSeconds = k % cycleDistance; 

        // Determine the child holding the ball after the remaining seconds.
        if (remainingSeconds == 0) {
            // If there are no remaining seconds, the ball is with child n-1 (end of a cycle).
            return n - 1; 
        } else if (remainingSeconds <= n - 1) {
            // If remaining seconds are within the first half of the cycle, the ball is moving towards the right.
            return remainingSeconds; 
        } else {
            // If remaining seconds are in the second half of the cycle, the ball is moving towards the left.
            return 2 * (n - 1) - remainingSeconds; 
        }
    }
}