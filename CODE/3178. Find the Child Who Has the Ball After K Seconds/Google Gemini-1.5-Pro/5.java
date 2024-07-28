class Solution {
    public int numberOfChild(int n, int k) {
        // Calculate the maximum steps the ball can take in one direction.
        int maxSteps = n - 1; 
        
        // If k is less than maxSteps, the ball hasn't reversed direction yet.
        if (k <= maxSteps) {
            return k; // The ball is at the kth child.
        }

        // Calculate the remaining steps after considering direction changes.
        int remainingSteps = k % (2 * maxSteps);

        // If remainingSteps is 0, the ball is at child n - 1.
        if (remainingSteps == 0) {
            return maxSteps;
        } 
        // If remainingSteps is within the first half of a cycle, the ball is moving right.
        else if (remainingSteps <= maxSteps) {
            return remainingSteps; 
        } 
        // Otherwise, the ball is moving left.
        else {
            return 2 * maxSteps - remainingSteps; 
        }
    }
}