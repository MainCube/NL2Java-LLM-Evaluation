import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // Sort requirements by end_i
        Arrays.sort(requirements, Comparator.comparingInt(a -> a[0]));

        // DP table
        int[][] dp = new int[n + 1][n * (n - 1) / 2 + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            // Prefix sum for DP transitions
            int[] prefixSum = new int[n * (n - 1) / 2 + 1];
            
            // Update prefix sums
            for (int k = 0; k <= n * (n - 1) / 2; k++) {
                prefixSum[k] = dp[i - 1][k];
                if (k > 0) {
                    prefixSum[k] += prefixSum[k - 1];
                    if (prefixSum[k] >= MOD) {
                        prefixSum[k] -= MOD;
                    }
                }
            }
            
            // Update DP for current i
            for (int k = 0; k <= n * (n - 1) / 2; k++) {
                dp[i][k] = 0;
                if (k >= i) {
                    dp[i][k] = (prefixSum[k] - prefixSum[k - i] + MOD) % MOD;
                } else {
                    dp[i][k] = prefixSum[k];
                }
            }
        }

        // Apply requirements
        int[] validDP = new int[n * (n - 1) / 2 + 1];
        validDP[0] = 1;
        
        for (int[] req : requirements) {
            int end = req[0] + 1;
            int count = req[1];
            
            int[] newValidDP = new int[n * (n - 1) / 2 + 1];
            for (int k = 0; k <= n * (n - 1) / 2; k++) {
                if (k >= count) {
                    newValidDP[k] = validDP[k] * dp[end][k - count] % MOD;
                }
            }
            validDP = newValidDP;
        }

        // The final result is the sum of all validDP values
        long result = 0;
        for (int val : validDP) {
            result = (result + val) % MOD;
        }
        
        return (int) result;
    }
}