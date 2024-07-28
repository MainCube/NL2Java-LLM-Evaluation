class Solution {
    public int waysToReachStair(int k) {
        int[] dp = new int[k + 2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= k + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[k + 1];
    }
}
