class Solution {
    public int minimumOperations(int[] nums) {
        int[] count = new int[3]; // Stores the count of remainders when divided by 3

        // Count the occurrences of each remainder
        for (int num : nums) {
            count[num % 3]++;
        }

        int n = nums.length;
        int minOperations = Integer.MAX_VALUE;

        // Explore all possible scenarios to make all elements divisible by 3
        // There are three possible target remainders: 0, 1, or 2
        for (int targetRemainder = 0; targetRemainder <= 2; targetRemainder++) {
            int operations = 0;
            // Calculate operations needed for each remainder to reach the target
            for (int i = 0; i < 3; i++) {
                operations += Math.abs(count[i] - (i == targetRemainder ? n : 0));
            }
            // Update minimum operations if current scenario is better
            minOperations = Math.min(minOperations, operations / 2);
        }

        return minOperations;
    }
}