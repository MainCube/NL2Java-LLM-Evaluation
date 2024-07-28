class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;

        // Iterate through all possible subarrays
        for (int i = 0; i < n; i++) {
            int currentAnd = nums[i]; // Initialize AND with the first element
            for (int j = i; j < n; j++) {
                currentAnd &= nums[j]; // Calculate AND for the current subarray
                minDiff = Math.min(minDiff, Math.abs(k - currentAnd)); // Update minDiff

                // Optimization: If we've reached 0, no need to continue
                if (currentAnd == 0) {
                    break;
                }
            }
        }

        return minDiff;
    }
}