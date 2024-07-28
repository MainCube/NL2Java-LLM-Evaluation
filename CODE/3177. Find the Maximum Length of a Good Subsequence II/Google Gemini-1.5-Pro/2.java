class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] represents the maximum length of a good subsequence ending at index i with at most j unequal adjacent pairs.
        int[][] dp = new int[n][k + 1]; 

        // Initialize dp array. The maximum length at each index with 0 unequal pairs is 1 (just the element itself).
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; 
        }

        // Iterate through the array to populate the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                // By default, the subsequence can include the current element itself.
                dp[i][j] = 1; 

                // Check if we can extend subsequences ending at previous indices.
                for (int prev = 0; prev < i; prev++) {
                    // If the current and previous elements are the same, we can extend the subsequence without increasing the unequal pairs count.
                    if (nums[i] == nums[prev]) {
                        dp[i][j] = Math.max(dp[i][j], dp[prev][j] + 1); 
                    } else if (j > 0) {
                        // If the elements are different and we have unequal pairs available (j > 0), we can use one to extend the subsequence.
                        dp[i][j] = Math.max(dp[i][j], dp[prev][j - 1] + 1); 
                    }
                }
            }
        }

        // Find the maximum length subsequence ending at any index with at most k unequal pairs.
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i][k]);
        }

        return maxLength;
    }
}