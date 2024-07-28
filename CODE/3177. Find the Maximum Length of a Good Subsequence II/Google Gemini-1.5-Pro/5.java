class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] represents the maximum length of a good subsequence ending at index i with at most j unequal adjacent pairs.
        int[][] dp = new int[n][k + 1];

        // Initialize dp array. The maximum length at each index with 0 unequal pairs is 1 (the element itself).
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; 
        }

        // Iterate through each element in the array.
        for (int i = 1; i < n; i++) {
            // For each element, iterate through possible numbers of unequal pairs.
            for (int j = 1; j <= k; j++) {
                // Initially, the maximum length at this index with j unequal pairs is the same as the previous index with j unequal pairs (we don't include the current element).
                dp[i][j] = dp[i - 1][j]; 
                
                // Iterate backwards from the current index.
                for (int l = i - 1; l >= 0; l--) {
                    // If the current element is equal to the element at index l, we can potentially extend the subsequence ending at index l.
                    if (nums[i] == nums[l]) {
                        // Update dp[i][j] to be the maximum of its current value and 1 (for the current element) + the maximum length of a good subsequence ending at index l with j - (i - l - 1) unequal pairs.
                        // (i - l - 1) represents the number of unequal pairs added by including the elements between index l and i.
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[l][j - (i - l - 1)]); 
                    }
                }
            }
        }

        // Find the maximum length among all possible numbers of unequal pairs at the last index.
        int maxLength = 0;
        for (int j = 0; j <= k; j++) {
            maxLength = Math.max(maxLength, dp[n - 1][j]);
        }

        return maxLength;
    }
}