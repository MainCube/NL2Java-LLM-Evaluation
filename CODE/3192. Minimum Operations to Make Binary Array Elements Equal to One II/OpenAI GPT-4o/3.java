class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        
        // We need to check if the first element is 0
        if (nums[0] == 0) {
            operations++;
        }
        
        // Count transitions from 1 to 0
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 1 && nums[i] == 0) {
                operations++;
            }
        }
        
        return operations;
    }
}