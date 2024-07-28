class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k <= i; k++) {
                        for (int l = 0; l <= j; l++) {
                            if (grid[k][l] == 1) {
                                int area = (i - k + 1) * (j - l + 1);
                                int sum = dp[k - 1][l] + dp[k][l - 1];
                                min = Math.min(min, area + sum);
                            }
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
