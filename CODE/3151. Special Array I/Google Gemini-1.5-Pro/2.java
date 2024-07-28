class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Handle the edge case where the array has less than two elements.
        if (nums.length < 2) {
            return true; 
        }

        // Iterate through the array, checking each adjacent pair.
        for (int i = 1; i < nums.length; i++) {
            // Check if both the current and previous elements have the same parity.
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                return false; // Not a special array.
            }
        }

        // If no adjacent pairs violated the condition, it's a special array.
        return true; 
    }
}