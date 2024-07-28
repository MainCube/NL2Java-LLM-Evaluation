class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // dp[i][j] represents the number of valid permutations of numbers [0, i]
        // where the prefix [0...i] has j inversions.
        long[][] dp = new long[n][401]; // Max inversions possible is n*(n-1)/2 < 400 for n <= 300

        // Base case: There's one way to arrange a single element (0 inversions).
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            // Calculate the cumulative sum of permutations with inversions up to 'j'
            // for the previous index 'i-1'.
            long[] cumulativeSum = new long[401];
            cumulativeSum[0] = dp[i - 1][0];
            for (int j = 1; j <= 400; j++) {
                cumulativeSum[j] = (cumulativeSum[j - 1] + dp[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= 400; j++) {
                // For each possible inversion count 'j' at index 'i':

                // 1. Placing 'i' at the beginning of the permutation [0...i-1]
                //    adds 'i' inversions.
                if (j - i >= 0) {
                    dp[i][j] = (dp[i][j] + cumulativeSum[j - i]) % MOD;
                }

                // 2. Placing 'i' somewhere after the beginning will result in
                //    fewer than 'j' inversions. We've already accounted for
                //    these in the cumulative sum.
                if (j < i) {
                    dp[i][j] = (dp[i][j] + cumulativeSum[j]) % MOD;
                }
            }
        }

        // Calculate the total valid permutations by considering all requirements.
        long totalPermutations = 0;
        for (int[] requirement : requirements) {
            int endIndex = requirement[0];
            int requiredInversions = requirement[1];
            totalPermutations = (totalPermutations + dp[endIndex][requiredInversions]) % MOD;
        }

        return (int) totalPermutations;
    }
}