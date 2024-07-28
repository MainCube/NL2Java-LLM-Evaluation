class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Handle the edge case where the array has less than two elements.
        if (nums.length < 2) {
            return true; 
        }

        // Iterate through the array, checking the parity of adjacent elements.
        for (int i = 1; i < nums.length; i++) {
            // If adjacent elements have the same parity, the array is not special.
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }

        // If no adjacent elements have the same parity, the array is special.
        return true;
    }
}