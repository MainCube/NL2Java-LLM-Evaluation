class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int MOD = 1000000007;
        // dp[i][k] will be the number of ways to form a permutation of length i with k inversions
        int[][] dp = new int[n + 1][401];
        
        dp[0][0] = 1; // Base case: One way to form an empty permutation with zero inversions
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 400; k++) {
                dp[i][k] = 0;
                for (int j = 0; j < i && j <= k; j++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % MOD;
                }
            }
        }
        
        // To satisfy the requirements, we need to check all combinations of valid permutations
        int[][] validCombinations = new int[requirements.length + 1][401];
        validCombinations[0][0] = 1; // Base case
        
        for (int idx = 0; idx < requirements.length; idx++) {
            int endIndex = requirements[idx][0];
            int cnt = requirements[idx][1];
            
            for (int k = 0; k <= 400; k++) {
                validCombinations[idx + 1][k] = 0;
                for (int i = 0; i <= k; i++) {
                    if (i == cnt) {
                        validCombinations[idx + 1][k] = (validCombinations[idx + 1][k] + 
                            validCombinations[idx][k - i] * dp[endIndex + 1][i]) % MOD;
                    }
                }
            }
        }
        
        return validCombinations[requirements.length][400];
    }
}