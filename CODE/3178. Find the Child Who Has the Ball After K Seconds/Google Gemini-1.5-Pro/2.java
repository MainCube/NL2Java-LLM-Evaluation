class Solution {
    public int numberOfChild(int n, int k) {
        // Calculate the maximum steps the ball can take in one direction
        // before reversing. It's one less than the number of children.
        int maxSteps = n - 1; 

        // If k is less than maxSteps, the ball hasn't reversed direction yet.
        if (k <= maxSteps) {
            return k; // The child's index is simply the number of seconds passed.
        }

        // Calculate how many times the ball has traversed the line back and forth.
        int numTraversals = k / maxSteps;

        // Calculate the remaining steps after the complete traversals.
        int remainingSteps = k % maxSteps;

        // If the number of traversals is even, the ball is moving towards the right.
        if (numTraversals % 2 == 0) {
            return remainingSteps; // Child's index is the remaining steps.
        } else {
            // If odd, the ball is moving towards the left.
            return maxSteps - remainingSteps; // Index is calculated from the end.
        }
    }
}