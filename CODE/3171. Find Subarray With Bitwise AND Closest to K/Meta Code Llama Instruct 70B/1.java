class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = k;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] & nums[i - 1];
            min = Math.min(min, Math.abs(k - dp[i]));
        }
        return min;
    }
}
