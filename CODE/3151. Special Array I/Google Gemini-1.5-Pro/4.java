class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Handle the edge case where the array has less than two elements.
        if (nums.length < 2) {
            return true;
        }

        // Iterate through the array, checking each pair of adjacent elements.
        for (int i = 1; i < nums.length; i++) {
            // Check if the current and previous elements have the same parity.
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                // If they have the same parity, the array is not special.
                return false;
            }
        }

        // If no adjacent elements have the same parity, the array is special.
        return true;
    }
}