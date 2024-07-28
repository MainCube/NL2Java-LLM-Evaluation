class Solution {
    public int waysToReachStair(int k) {
        int[] dp = new int[k + 2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= k + 1; i++) {
            int jump = 0;
            for (int j = i - 2; j >= 0; j--) {
                dp[i] += dp[j];
                jump++;
            }
            dp[i + 1] = dp[i];
        }
        return dp[k + 1];
    }
}
