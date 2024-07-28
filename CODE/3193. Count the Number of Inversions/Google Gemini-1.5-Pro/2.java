class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // dp[i][j] represents the number of valid permutations ending at index i
        // with j inversions in the prefix [0...i].
        long[][] dp = new long[n][401]; // Max inversions possible is n*(n-1)/2 <= 400

        // Base case: The only valid permutation for an empty prefix is the empty permutation.
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            // Calculate prefix sums for each inversion count.
            // prefixSum[j] stores the number of valid permutations ending before index i
            // with at most j inversions.
            long[] prefixSum = new long[401];
            prefixSum[0] = dp[i - 1][0];
            for (int j = 1; j <= 400; j++) {
                prefixSum[j] = (prefixSum[j - 1] + dp[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= 400; j++) {
                // For each possible inversion count at index i,
                // we can insert the number 'i' into the permutations ending before index i.
                // Inserting 'i' at a position k positions from the end contributes k inversions.
                for (int k = 0; k <= i && j - k >= 0; k++) {
                    // Add the number of permutations ending before index i with (j-k) inversions.
                    dp[i][j] = (dp[i][j] + prefixSum[j - k]) % MOD;
                }
            }
        }

        // Calculate the total count of valid permutations for all requirements.
        long count = 0;
        for (int[] requirement : requirements) {
            int endIndex = requirement[0];
            int requiredInversions = requirement[1];
            count = (count + dp[endIndex][requiredInversions]) % MOD;
        }

        return (int) count;
    }
}