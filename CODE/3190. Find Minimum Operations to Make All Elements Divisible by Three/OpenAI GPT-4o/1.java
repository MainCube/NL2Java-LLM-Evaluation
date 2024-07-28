class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for (int num : nums) {
            int remainder = num % 3;
            if (remainder == 1) {
                operations += 1;  // Add 2 or subtract 1
            } else if (remainder == 2) {
                operations += 1;  // Add 1 or subtract 2
            }
            // remainder == 0 needs no operations
        }
        return operations;
    }
}