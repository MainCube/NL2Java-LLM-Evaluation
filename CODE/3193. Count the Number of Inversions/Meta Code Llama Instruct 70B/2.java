class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for (int[] requirement : requirements) {
            int end = requirement[0];
            int cnt = requirement[1];
            for (int i = 0; i <= end; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j < cnt) {
                        dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % mod;
                    }
                    if (j >= cnt) {
                        dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % mod;
                    }
                }
            }
        }
        return dp[n - 1][0];
    }
}
