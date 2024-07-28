class Solution {
    public int minimumOperations(int[] nums) {
        int[] count = new int[3]; // Stores the count of remainders (0, 1, and 2) when nums[i] is divided by 3

        // Count the occurrences of each remainder
        for (int num : nums) {
            count[num % 3]++;
        }

        // Calculate the minimum operations
        int minOperations = Math.min(count[1], count[2]); // Minimum operations for remainders 1 and 2
        minOperations += Math.abs(count[1] - count[2]) / 3; // Adjust for any remaining difference

        return minOperations;
    }
}