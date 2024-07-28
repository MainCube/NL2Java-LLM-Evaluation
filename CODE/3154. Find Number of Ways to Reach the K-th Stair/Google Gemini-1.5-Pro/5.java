class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[] dp;

    public int waysToReachStair(int k) {
        dp = new Long[k + 1];
        return (int) ways(k);
    }

    private long ways(int k) {
        if (k == 0) {
            return 1; // Base case: One way to reach stair 0
        }
        if (k < 0) {
            return 0; // Base case: Cannot reach negative stairs
        }
        if (dp[k] != null) {
            return dp[k]; // Return memoized result if available
        }

        // Recursively calculate ways to reach stair k:
        // 1. Go down from stair k+1 (ways(k + 1))
        // 2. Jump from a lower stair i (ways(i)) where i + 2*j = k 
        long count = ways(k + 1); 
        for (int i = k - 1, j = 0; i >= 0; i--, j++) {
            if (i + 2 * j == k) {
                count = (count + ways(i)) % MOD;
            }
        }

        dp[k] = count; // Memoize the result
        return count;
    }
}