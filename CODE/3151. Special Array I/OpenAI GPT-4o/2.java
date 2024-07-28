class Solution {
    public boolean isArraySpecial(int[] nums) {
        // If the array has only one element, it's trivially special
        if (nums.length == 1) {
            return true;
        }
        
        // Traverse through the array and check adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if the parity of nums[i] is different from nums[i+1]
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false; // Same parity means it's not a special array
            }
        }
        
        // If all adjacent pairs have different parity, the array is special
        return true;
    }
}
