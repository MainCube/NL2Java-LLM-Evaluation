class Solution {
    public int minimumOperations(int[] nums) {
        int[] count = new int[3]; // Stores the frequency of remainders (0, 1, or 2) when nums[i] is divided by 3

        // Calculate the frequency of each remainder
        for (int num : nums) {
            count[num % 3]++;
        }

        // Calculate the minimum operations
        int minOperations = nums.length; // Initialize with the maximum possible operations
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i != j) { // Avoid adding the same remainder group twice
                    int operations = count[i] + count[j];
                    minOperations = Math.min(minOperations, operations);
                }
            }
        }

        return minOperations;
    }
}