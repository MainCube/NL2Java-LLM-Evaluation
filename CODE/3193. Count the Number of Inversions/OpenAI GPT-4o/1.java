class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // Initialize DP table
        int[][] dp = new int[n + 1][n * (n - 1) / 2 + 1];
        dp[0][0] = 1;

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= n * (n - 1) / 2; k++) {
                for (int j = 0; j < i; j++) {
                    if (k >= j) {
                        dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % MOD;
                    }
                }
            }
        }

        // Create a map of requirements
        int[] reqInversions = new int[n];
        for (int[] req : requirements) {
            int end = req[0];
            int cnt = req[1];
            reqInversions[end] = cnt;
        }

        // To count valid permutations
        int result = 0;

        // Check all permutations ending at n-1
        int maxInversions = n * (n - 1) / 2;
        for (int k = 0; k <= maxInversions; k++) {
            boolean valid = true;
            for (int end = 0; end < n; end++) {
                if (dp[end + 1][k] != 0 && reqInversions[end] != 0) {
                    if (k != reqInversions[end]) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                result = (result + dp[n][k]) % MOD;
            }
        }

        return result;
    }
}