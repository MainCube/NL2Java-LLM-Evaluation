class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Edge case: An array with only one element is always special
        if (nums.length == 1) {
            return true;
        }
        
        // Iterate through the array and check the parity of adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if both numbers have the same parity
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false; // If they do, the array is not special
            }
        }
        
        // If no adjacent elements have the same parity, the array is special
        return true;
    }
}
