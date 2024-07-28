class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int[] requirement : requirements) {
            int end = requirement[0], count = requirement[1];
            for (int i = 0; i <= end; i++) {
                int left = i - 1 >= 0 ? dp[i - 1][i - 1] : 0;
                int right = i + 1 <= end ? dp[i + 1][end] : 0;
                dp[i][end] = (left * right) % mod;
            }
            for (int i = 0; i <= end; i++) {
                if (i - 1 >= 0) {
                    dp[i][end] = (dp[i][end] - dp[i - 1][end] + mod) % mod;
                }
            }
            for (int i = 0; i <= end; i++) {
                if (i + 1 <= end) {
                    dp[i][end] = (dp[i][end] - dp[i][end - 1] + mod) % mod;
                }
            }
            if (count == 0) {
                dp[0][end] = (dp[0][end] - 1 + mod) % mod;
            }
            for (int i = 0; i <= end; i++) {
                if (i + 1 <= end) {
                    dp[i][end] = (dp[i][end] * factorial(i + 1, mod)) % mod;
                }
            }
            for (int i = 0; i <= end; i++) {
                if (i - 1 >= 0) {
                    dp[i][end] = (dp[i][end] * factorial(i, mod)) % mod;
                }
            }
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * dp[i][i]) % mod;
        }
        return result;
    }
    public int factorial(int n, int mod) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % mod;
        }
        return result;
    }
}
