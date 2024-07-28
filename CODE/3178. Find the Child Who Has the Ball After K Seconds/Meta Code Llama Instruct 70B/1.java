class Solution {
    public int numberOfChild(int n, int k) {
        // If k is less than n, then the child who receives the ball after k seconds is the child at index k % n.
        if (k < n) {
            return k % n;
        }

        // If k is greater than or equal to n, then the child who receives the ball after k seconds is the child at index k % n.
        // After every n seconds, the ball reaches the same child who received it at the start. So, we can reduce the number of seconds to k % n.
        else {
            return k % n;
        }
    }
}
