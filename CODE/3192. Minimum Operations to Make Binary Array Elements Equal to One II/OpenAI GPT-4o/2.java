class Solution {
    public int minOperations(int[] nums) {
        // If the array is empty, no operations are required.
        if (nums.length == 0) return 0;
        
        int operations = 0;
        
        // We start by checking if the first element is 0.
        if (nums[0] == 0) {
            operations++;
        }
        
        // Traverse the array to count transitions from 1 to 0.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 1 && nums[i] == 0) {
                operations++;
            }
        }
        
        return operations;
    }
}