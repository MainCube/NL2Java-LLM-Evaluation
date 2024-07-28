class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int operations = 0;
        // We start comparing from the second element
        for (int i = 1; i < n; i++) {
            // If there is a change from the previous element, increment the operations counter
            if (nums[i] != nums[i - 1]) {
                operations++;
            }
        }
        
        // If the last element is 0, we need one more flip to turn it to 1
        if (nums[n - 1] == 0) {
            operations++;
        }
        
        return operations;
    }
}