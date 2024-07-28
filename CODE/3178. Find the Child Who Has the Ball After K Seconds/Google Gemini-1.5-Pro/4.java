class Solution {
    public int numberOfChild(int n, int k) {
        // Calculate the maximum steps the ball can take in one direction.
        int maxSteps = n - 1;

        // If k is less than maxSteps, the ball hasn't changed direction yet.
        if (k <= maxSteps) {
            return k;
        }

        // Calculate the remaining steps after completing full cycles.
        int remainingSteps = k % (2 * maxSteps);

        // If remaining steps are 0, the ball is with child n - 1.
        if (remainingSteps == 0) {
            return n - 1;
        } 
        // If remaining steps are less than maxSteps, the ball is moving towards the right.
        else if (remainingSteps <= maxSteps) {
            return remainingSteps;
        } 
        // Otherwise, the ball is moving towards the left.
        else {
            return 2 * maxSteps - remainingSteps + 1;
        }
    }
}