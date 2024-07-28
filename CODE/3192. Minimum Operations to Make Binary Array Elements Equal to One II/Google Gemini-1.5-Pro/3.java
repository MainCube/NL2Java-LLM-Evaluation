class Solution {
    public int minOperations(int[] nums) {
        /*
        We can solve this problem by tracking the number of flips and the current state of the array. 
        The key observation is that flipping a prefix of the array multiple times is redundant. 
        We only need to flip a position at most once.
        */
        int flips = 0; // Initialize the number of flips to 0
        for (int i = 0; i < nums.length; i++) {
            // If the current element is 0 and the number of flips is even (meaning it's originally 0), 
            // or the current element is 1 and the number of flips is odd (meaning it's flipped to 1),
            // we need to perform a flip operation.
            if (nums[i] == (flips % 2 == 0 ? 0 : 1)) {
                flips++; // Increment the flip count
            }
        }
        return flips; // Return the total number of flips
    }
}