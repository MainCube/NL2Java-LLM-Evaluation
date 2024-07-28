class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] represents the maximum length of a good subsequence ending at index i
        // with at most j indices where adjacent elements are different.
        int[][] dp = new int[n][k + 1];

        // Initialize dp array. The maximum length at each index with 0 changes is 1 (the element itself).
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; 
        }

        // Iterate through each element in the array.
        for (int i = 1; i < n; i++) {
            // For each element, iterate through the possible number of allowed changes (0 to k).
            for (int j = 0; j <= k; j++) {
                // By default, the maximum length at this index with j changes is the same 
                // as the maximum length at the previous index with j changes (we don't include nums[i]).
                dp[i][j] = dp[i - 1][j]; 

                // If we have changes left (j > 0), try to include nums[i] in the subsequence.
                if (j > 0) {
                    // Iterate backwards from the current index to find the longest good subsequence
                    // that can include nums[i] with at most j changes.
                    for (int l = i - 1; l >= 0; l--) {
                        // If nums[i] is different from nums[l], we've used up one change.
                        if (nums[i] != nums[l]) {
                            j--;
                        }
                        // Update dp[i][j] to be the maximum of its current value and 
                        // the length of the subsequence found (i - l + 1).
                        dp[i][j] = Math.max(dp[i][j], i - l + 1); 
                        // If we've used up all allowed changes (j == 0), we can stop looking back.
                        if (j == 0) {
                            break;
                        }
                    }
                }
            }
        }

        // After filling the dp array, the maximum length of a good subsequence will be 
        // the maximum value in the last row of the dp array (considering all possible values of j).
        int maxLength = 0;
        for (int j = 0; j <= k; j++) {
            maxLength = Math.max(maxLength, dp[n - 1][j]);
        }
        return maxLength;
    }
}