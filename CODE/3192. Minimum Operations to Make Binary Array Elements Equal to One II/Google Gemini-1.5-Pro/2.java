class Solution {
    public int minOperations(int[] nums) {
        /*
        The key observation is that we don't need to track the state of the entire array. 
        We only need to keep track of whether the prefix of the array up to the current index 
        needs to be flipped or not.

        Here's how the logic works:

        1. Initialize 'flips' to 0. This variable tracks the number of flip operations.
        2. Iterate through the array 'nums' from left to right.
        3. For each element 'num' at index 'i':
           - If 'flips' is even and 'num' is 0, or if 'flips' is odd and 'num' is 1, 
             it means the current prefix needs to be flipped. 
           - Increment 'flips' to indicate a flip operation.
        4. Finally, return 'flips' which represents the minimum operations needed.
        */
        int flips = 0; // Initialize flip count
        for (int num : nums) {
            // Check if the current prefix needs flipping
            if ((flips % 2 == 0 && num == 0) || (flips % 2 == 1 && num == 1)) {
                flips++; // Increment flip count if a flip is needed
            }
        }
        return flips; // Return the total number of flips
    }
}