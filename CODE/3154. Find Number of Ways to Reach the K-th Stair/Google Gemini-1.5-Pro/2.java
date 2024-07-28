class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[] dp;

    public int waysToReachStair(int k) {
        dp = new Long[k + 1];
        return (int) ((long) ways(k) % MOD);
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

        // Recursively calculate the number of ways
        long waysFromKMinus1 = ways(k - 1); // Ways from the stair below
        long waysFromJumps = ways(k - (int) Math.ceil((double) k / 2)); // Ways using jumps

        // Memoize the result and return
        dp[k] = (waysFromKMinus1 + waysFromJumps) % MOD;
        return dp[k];
    }
}