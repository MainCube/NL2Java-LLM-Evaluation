class Solution {
    private static final int MOD = 1000000007;
    
    public int numberOfPermutations(int n, int[][] requirements) {
        int[][] dp = new int[n + 1][n * (n - 1) / 2 + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n * (n - 1) / 2; j++) {
                dp[i][j] = 0;
                for (int k = 0; k < i; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                    }
                }
            }
        }
        
        // Requirements check
        int[] requiredInversions = new int[n];
        for (int i = 0; i < n; i++) {
            requiredInversions[i] = -1; // -1 means no requirement
        }
        for (int[] req : requirements) {
            requiredInversions[req[0]] = req[1];
        }
        
        // Check if dp[i][j] meets the requirements
        int result = 0;
        for (int j = 0; j <= n * (n - 1) / 2; j++) {
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                if (requiredInversions[i] != -1 && dp[i + 1][j] != requiredInversions[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result = (result + dp[n][j]) % MOD;
            }
        }
        
        return result;
    }
}