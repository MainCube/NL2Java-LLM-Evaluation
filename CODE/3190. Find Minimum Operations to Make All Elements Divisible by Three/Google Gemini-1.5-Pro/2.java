class Solution {
    public int minimumOperations(int[] nums) {
        int[] counts = new int[3]; // Stores count of numbers with remainders 0, 1, and 2 when divided by 3
        
        // Count the remainders
        for (int num : nums) {
            counts[num % 3]++;
        }
        
        // Calculate the minimum operations
        int minOperations = nums.length; // Initialize with maximum possible operations
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) { // We need two different remainders to combine into a multiple of 3
                    int k = 3 - i - j; // Calculate the third remainder
                    if (k >= 0 && k < 3 && (i != k || j != k)) { // Ensure k is valid and not equal to both i and j
                        // Calculate operations using the formula: 
                        // total length - (count of one remainder + count of another remainder)
                        minOperations = Math.min(minOperations, nums.length - counts[i] - counts[j]);
                    }
                }
            }
        }
        
        return minOperations;
    }
}