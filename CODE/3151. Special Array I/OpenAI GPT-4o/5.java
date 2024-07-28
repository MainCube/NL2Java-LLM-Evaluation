class Solution {
    public boolean isArraySpecial(int[] nums) {
        // If the array has only one element, it's trivially special
        if (nums.length == 1) {
            return true;
        }
        
        // Iterate through the array and check adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if adjacent elements have different parity
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                // If they have the same parity, return false
                return false;
            }
        }
        
        // If all adjacent pairs have different parities, return true
        return true;
    }
}
