class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[][] dp;

    public int waysToReachStair(int k) {
        dp = new Long[k + 1][k + 1]; // dp[i][j] = ways to reach stair i with jump j
        return (int) ways(k, 0);
    }

    private long ways(int k, int jump) {
        if (k == 1) {
            return 1; // Base case: Always 1 way to stay at stair 1
        }
        if (k < 0) {
            return 0; // Invalid state, cannot go below stair 0
        }
        if (dp[k][jump] != null) {
            return dp[k][jump]; // Return cached result if available
        }

        long waysFromCurrentStair = ways(k, jump); // Option 1: Stay at the current stair

        // Option 2: Go down one step (if not already at stair 0)
        long waysFromDownStair = 0;
        if (k > 0) {
            waysFromDownStair = ways(k - 1, jump);
        }

        // Option 3: Jump up (if possible)
        long waysFromUpStair = 0;
        if (k >= 2 * jump + 2) {
            waysFromUpStair = ways(k - (2 * jump + 2), jump + 1);
        }

        long totalWays = (waysFromCurrentStair + waysFromDownStair + waysFromUpStair) % MOD;
        dp[k][jump] = totalWays; // Cache the result
        return totalWays;
    }
}