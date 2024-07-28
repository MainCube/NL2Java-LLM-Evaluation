class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] represents the maximum length of a good subsequence ending at index i with j changes.
        int[][] dp = new int[n][k + 1];

        // Initialize dp array. The first element of nums always forms a good subsequence of length 1 with 0 changes.
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 1;
        }

        // Iterate over the nums array starting from the second element.
        for (int i = 1; i < n; i++) {
            // For each element, iterate over the possible number of changes from 0 to k.
            for (int j = 0; j <= k; j++) {
                // Initialize the maximum length for the current state to 1, considering only the current element.
                dp[i][j] = 1; 
                // Iterate over the previous elements to find the maximum length.
                for (int m = 0; m < i; m++) {
                    // If the current element is equal to the previous element, we can extend the subsequence without increasing the number of changes.
                    if (nums[i] == nums[m]) {
                        dp[i][j] = Math.max(dp[i][j], dp[m][j] + 1);
                    } else if (j > 0) {
                        // If the current element is not equal to the previous element and we have changes left, we can make a change and extend the subsequence.
                        dp[i][j] = Math.max(dp[i][j], dp[m][j - 1] + 1);
                    }
                }
            }
        }

        // Find the maximum length of a good subsequence ending at any index with at most k changes.
        int maxLength = 0;
        for (int j = 0; j <= k; j++) {
            maxLength = Math.max(maxLength, dp[n - 1][j]);
        }

        return maxLength;
    }
}