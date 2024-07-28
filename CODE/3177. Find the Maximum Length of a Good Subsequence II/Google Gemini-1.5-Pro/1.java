class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] represents the maximum length of a good subsequence ending at index i with j inconsistencies.
        int[][] dp = new int[n][k + 1];

        // Initialize dp array. The maximum length at index 0 is always 1.
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 1;
        }

        // Iterate through the array from the second element.
        for (int i = 1; i < n; i++) {
            // For each index, iterate through possible inconsistency counts.
            for (int j = 0; j <= k; j++) {
                // Initialize the maximum length for the current state to 1 (including only the current element).
                dp[i][j] = 1; 
                // Iterate through previous indices to find the maximum length.
                for (int prev = i - 1; prev >= 0; prev--) {
                    // If the current and previous elements are the same, or we have enough inconsistencies allowed,
                    // update the maximum length.
                    if (nums[i] == nums[prev] || j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[prev][j] + 1); 
                    }
                    // If the elements are different, decrement the inconsistency count.
                    if (nums[i] != nums[prev]) {
                        j--;
                    }
                    // If j becomes negative, it means we have exceeded the allowed inconsistencies, so break the loop.
                    if (j < 0) {
                        break;
                    }
                }
            }
        }

        // Find the maximum length among all possible inconsistency counts at the last index.
        int maxLength = 0;
        for (int j = 0; j <= k; j++) {
            maxLength = Math.max(maxLength, dp[n - 1][j]);
        }
        return maxLength;
    }
}