class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[] dp;

    public int waysToReachStair(int k) {
        dp = new Long[k + 1];
        return (int) ways(k);
    }

    private long ways(int k) {
        if (k == 0) {
            return 1; // Base case: 1 way to reach stair 0
        }
        if (k < 0) {
            return 0; // Invalid state: cannot be below stair 0
        }
        if (dp[k] != null) {
            return dp[k]; // Return memoized result if available
        }

        // Recursively calculate ways to reach stair k:
        // 1. From stair (k - 1) by going down
        // 2. From stair (k - 2*j) for all possible previous jump values j
        dp[k] = ways(k - 1); 
        for (int j = 1; k - 2 * j >= 0; j++) {
            dp[k] = (dp[k] + ways(k - 2 * j)) % MOD;
        }

        return dp[k];
    }
}