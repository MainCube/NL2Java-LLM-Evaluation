class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;

        // Iterate through all possible subarrays
        for (int i = 0; i < n; i++) {
            int currentAnd = nums[i]; // Initialize with the first element of the subarray
            for (int j = i; j < n; j++) {
                currentAnd &= nums[j]; // Calculate AND for the current subarray
                minDiff = Math.min(minDiff, Math.abs(k - currentAnd)); // Update minDiff

                // Optimization: If we reach 0, no need to continue as it's the smallest possible AND
                if (currentAnd == 0) {
                    break;
                }
            }
        }

        return minDiff;
    }
}