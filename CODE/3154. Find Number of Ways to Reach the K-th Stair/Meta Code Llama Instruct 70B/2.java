class Solution {
    public int waysToReachStair(int k) {
        if (k == 0) {
            return 1;
        }
        int[] dp = new int[k + 1];
        dp[0] = 1;
        dp[1] = 2;
        int jump = 0;
        for (int i = 2; i <= k; i++) {
            dp[i] = dp[i - 1] + dp[i - 2 * jump];
            jump++;
        }
        return dp[k];
    }
}
