class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // dp[i][j]: Number of permutations of [0, 1, ..., i] with j inversions
        // considering elements up to index i (inclusive).
        long[][] dp = new long[n][401]; 

        // Base case: For an empty permutation (i = -1), there are 0 inversions.
        dp[0][0] = 1; 

        // Iterate through each element from 1 to n - 1.
        for (int i = 1; i < n; i++) {
            // Calculate the cumulative sum of permutations for the previous index (i - 1)
            // with varying numbers of inversions.
            long[] cumSum = new long[401];
            cumSum[0] = dp[i - 1][0];
            for (int j = 1; j <= 400; j++) {
                cumSum[j] = (cumSum[j - 1] + dp[i - 1][j]) % MOD;
            }

            // Iterate through possible inversion counts for the current index i.
            for (int j = 0; j <= 400; j++) {
                // Calculate the number of permutations with j inversions at index i.
                // This involves considering placing element i at different positions
                // within the existing permutations.
                dp[i][j] = cumSum[j]; // Placing i at the end adds 0 inversions.
                if (j - i >= 0) {
                    dp[i][j] = (dp[i][j] - cumSum[j - i] + MOD) % MOD; 
                    // Placing i at earlier positions adds i, i - 1, ..., 1 inversions.
                    // We subtract to avoid overcounting permutations with more inversions.
                }
            }
        }

        long result = 0;
        // Iterate through each requirement.
        for (int[] req : requirements) {
            // Calculate the number of permutations satisfying the current requirement
            // and add it to the result.
            result = (result + dp[req[0]][req[1]]) % MOD; 
        }

        return (int) result;
    }
}