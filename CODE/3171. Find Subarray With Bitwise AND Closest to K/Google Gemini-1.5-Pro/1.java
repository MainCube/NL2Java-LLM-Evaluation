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

                // Optimization: If we find a subarray with AND equal to k, we can stop
                if (minDiff == 0) {
                    return 0; 
                }
            }
        }

        return minDiff;
    }
}