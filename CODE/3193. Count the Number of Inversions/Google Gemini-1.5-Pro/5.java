class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // dp[i][j] represents the number of permutations of [0...i] with j inversions.
        long[][] dp = new long[n][401]; // Max inversions possible is n*(n-1)/2 < 400 for n <= 300

        // Base case: There's one permutation of length 1 (no inversions).
        dp[0][0] = 1;

        // Iterate through possible positions to place the next number.
        for (int i = 1; i < n; i++) {
            // For each possible inversion count for the current position.
            for (int j = 0; j <= 400; j++) {
                // Iterate through possible positions of the previous number.
                for (int k = 0; k <= i && k <= j; k++) {
                    // Placing the current number at position 'i' contributes 'k' inversions.
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }

        // Calculate the result based on requirements.
        long result = 0;
        for (int[] requirement : requirements) {
            int endIndex = requirement[0];
            int inversionCount = requirement[1];

            // Sum up the permutations satisfying the current requirement.
            if (inversionCount <= 400) {
                result = (result + dp[endIndex][inversionCount]) % MOD;
            }
        }

        return (int) result;
    }
}