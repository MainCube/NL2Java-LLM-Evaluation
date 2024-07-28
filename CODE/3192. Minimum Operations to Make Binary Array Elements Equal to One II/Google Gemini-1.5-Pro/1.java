class Solution {
    public int minOperations(int[] nums) {
        /*
        The key observation is that we don't need to track the state of the entire array. 
        We only need to track whether the prefix of the array up to the current index is flipped or not. 
        This is because flipping from index i to the end will always either flip the entire prefix or revert it back to its original state.

        Here's how the code works:
        1. Initialize 'flips' to 0, representing the initial state of the array (not flipped).
        2. Iterate through the array 'nums'.
            - If the current element 'num' is 1 and 'flips' is even (meaning the prefix is not flipped), 
              or if 'num' is 0 and 'flips' is odd (meaning the prefix is flipped), 
              we need to perform a flip operation.
            - Increment 'flips' whenever a flip operation is needed.
        3. Return 'flips' as the minimum number of operations.
        */
        int flips = 0; // Start with no flips
        for (int num : nums) {
            if ((num == 1 && flips % 2 == 0) || (num == 0 && flips % 2 != 0)) {
                flips++; // Flip the prefix if the current element doesn't match the expected state
            }
        }
        return flips;
    }
}