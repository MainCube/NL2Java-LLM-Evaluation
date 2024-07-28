class Solution {
    public boolean isArraySpecial(int[] nums) {
        // An array with 0 or 1 element is trivially special
        if (nums.length <= 1) {
            return true;
        }

        // Iterate through the array
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if both elements in the adjacent pair have the same parity
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                // If they have the same parity, return false
                return false;
            }
        }
        
        // If no such pair is found, return true
        return true;
    }
}
