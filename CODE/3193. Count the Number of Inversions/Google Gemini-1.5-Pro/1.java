class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // dp[i][j] represents the number of permutations of [0, 1, ..., i]
        // where the prefix [0, 1, ..., i] has j inversions.
        long[][] dp = new long[n][401]; 

        // Base case: There's one way to arrange a single element (0 inversions).
        dp[0][0] = 1; 

        for (int i = 1; i < n; i++) {
            // Calculate the cumulative sum of inversions for the previous index.
            long[] cumSum = new long[401];
            cumSum[0] = dp[i - 1][0];
            for (int j = 1; j <= 400; j++) {
                cumSum[j] = (cumSum[j - 1] + dp[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= 400; j++) {
                // For each possible inversion count 'j' at index 'i':

                // 1. Placing 'i' at the beginning contributes 'i' inversions.
                if (j >= i) {
                    dp[i][j] = (dp[i][j] + cumSum[j - i]) % MOD;
                }

                // 2. Placing 'i' somewhere in the middle or end contributes fewer inversions.
                dp[i][j] = (dp[i][j] + cumSum[j]) % MOD; 
            }
        }

        // Calculate the answer based on the requirements.
        long ans = 0;
        for (int[] req : requirements) {
            ans = (ans + dp[req[0]][req[1]]) % MOD;
        }

        return (int) ans;
    }
}