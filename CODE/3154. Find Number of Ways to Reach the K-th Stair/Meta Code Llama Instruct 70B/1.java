class Solution {
    public int waysToReachStair(int k) {
        if(k == 0)
            return 1;
        if(k == 1)
            return 1;
        int[] dp = new int[k+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= k; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[k];
    }
}