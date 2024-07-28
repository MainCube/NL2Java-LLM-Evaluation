import java.util.*;

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        final int MOD = 1000000007;
        
        // Maximum possible number of inversions for any length k
        int maxInversions = n * (n - 1) / 2;
        
        // DP array
        int[][] dp = new int[n + 1][maxInversions + 1];
        dp[0][0] = 1;
        
        // Fill the DP table
        for (int k = 1; k <= n; k++) {
            for (int inv = 0; inv <= maxInversions; inv++) {
                dp[k][inv] = 0;
                for (int l = 0; l <= Math.min(k - 1, inv); l++) {
                    dp[k][inv] = (dp[k][inv] + dp[k - 1][inv - l]) % MOD;
                }
            }
        }
        
        // Requirements
        Map<Integer, Integer> reqMap = new HashMap<>();
        for (int[] requirement : requirements) {
            reqMap.put(requirement[0], requirement[1]);
        }
        
        // Check for the requirements
        int[] currentInversions = new int[n];
        for (int i = 0; i < n; i++) {
            currentInversions[i] = reqMap.getOrDefault(i, -1);
        }
        
        // Result
        int result = 0;
        for (int inv = 0; inv <= maxInversions; inv++) {
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if (currentInversions[i] != -1 && dp[i + 1][inv] != currentInversions[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result = (result + dp[n][inv]) % MOD;
            }
        }
        
        return result;
    }
}