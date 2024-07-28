class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        // Iterate through all possible subarrays
        for (int i = 0; i < n; i++) {
            int currentAnd = nums[i]; // Initialize AND with the first element
            for (int j = i; j < n; j++) {
                currentAnd &= nums[j]; // Calculate AND for the current subarray
                minDiff = Math.min(minDiff, Math.abs(k - currentAnd)); // Update minDiff

                // Optimization: If we reach 0, no need to continue as it's the minimum
                if (minDiff == 0) {
                    return 0; 
                }
            }
        }

        return minDiff;
    }
}