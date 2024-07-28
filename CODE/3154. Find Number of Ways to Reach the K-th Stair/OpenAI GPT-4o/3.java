class Solution {
    public int waysToReachStair(int k) {
        if (k == 0) return 2;
        if (k == 1) return 4;
        
        // Use a dynamic programming approach to count the ways to reach stair `k`.
        long[] dp = new long[k + 1];
        dp[0] = 1; // There's one way to be on stair 0 initially.
        dp[1] = 1; // Starting at stair 1.
        
        for (int i = 2; i <= k; i++) {
            // Calculate the number of ways to reach stair `i`
            // Alice can come to `i` from `i - 1` or `i - 2^jump`
            dp[i] = dp[i - 1];
            for (int j = 1; (i - (1 << j)) >= 0; j++) {
                dp[i] += dp[i - (1 << j)];
            }
        }
        
        return (int) dp[k];
    }
}
