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
            return dp[k]; // Return cached result if available
        }

        // Recursively calculate ways to reach stair k:
        // 1. From stair (k-2) with a jump, then going down
        // 2. From stair (k-1) by going down
        dp[k] = (ways(k - 2) + ways(k - 1)) % MOD; 
        return dp[k];
    }
}