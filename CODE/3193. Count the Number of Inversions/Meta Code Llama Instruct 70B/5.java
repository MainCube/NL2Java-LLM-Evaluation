class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        
        for (int[] req : requirements) {
            int end_i = req[0], cnt_i = req[1];
            for (int i = 0; i <= end_i; i++) {
                for (int j = 0; j <= cnt_i; j++) {
                    if (dp[i][j] > 0) {
                        long factorial_i = factorial(i);
                        long factorial_n_minus_1_minus_i = factorial(n - 1 - i);
                        long factorial_n_minus_1 = factorial_n_minus_1_minus_i * (n - i);
                        dp[i + 1][j + 1] += dp[i][j] * factorial_i * factorial_n_minus_1_minus_i / factorial_n_minus_1;
                    }
                }
            }
        }
        
        long res = 0;
        for (int j = 0; j < requirements[n - 1][1]; j++) {
            res += dp[n - 1][j];
        }
        
        return (int) (res % (1e9 + 7));
    }
    
    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
