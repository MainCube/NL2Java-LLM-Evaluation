class Solution {
    public int minOperations(int[] nums) {
        /*
        We need to find the minimum number of flips to make all elements 1. 
        Instead of focusing on individual flips, we can track changes in the array's state.

        Consider these observations:
        - Flipping from index i to the end changes the state of all elements from i onwards.
        - If we flip a subarray twice, it's as if we did nothing (elements revert to their original state).

        Therefore, we only need to track whether a given index has been flipped an odd or even number of times.

        Algorithm:
        1. Initialize a variable 'flips' to 0 (representing the initial state: no flips).
        2. Iterate through the array 'nums'.
            - If 'nums[i]' is different from the current 'flips' state:
                - This means we need to perform a flip from index 'i' to the end.
                - Increment 'flips' to mark the state change.
        3. Return 'flips' as the minimum number of operations.
        */

        int flips = 0; // Initially, no flips have been performed
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != flips) { // If the element doesn't match the current flip state
                flips++; // Increment flips to indicate a state change from this index onwards
            }
        }
        return flips;
    }
}