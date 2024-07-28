class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        
        for (int num : nums) {
            int remainder = num % 3;
            if (remainder == 1) {
                operations += 1; // Subtract 1 to make it divisible by 3
            } else if (remainder == 2) {
                operations += 1; // Add 1 to make it divisible by 3
            }
            // if remainder == 0, do nothing as it's already divisible by 3
        }
        
        return operations;
    }
}