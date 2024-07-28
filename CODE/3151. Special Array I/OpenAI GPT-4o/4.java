class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Iterate through the array up to the second-to-last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if the current element and the next element have different parity
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                // If they have the same parity, return false
                return false;
            }
        }
        // If all adjacent pairs have different parities, return true
        return true;
    }
}
