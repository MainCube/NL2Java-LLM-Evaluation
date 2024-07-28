class Solution {
    public int waysToReachStair(int k) {
        int[] memo = new int[k + 1];
        Arrays.fill(memo, -1);
        return dp(k, 0, memo);
    }

    private int dp(int k, int jump, int[] memo) {
        if (k == 0) {
            return 1;
        }
        if (k < 0) {
            return 0;
        }
        if (memo[k] != -1) {
            return memo[k];
        }
        int ways = dp(k - 1, jump, memo);
        if (k >= 2 * jump) {
            ways += dp(k - 2 * jump, jump + 1, memo);
        }
        memo[k] = ways;
        return ways;
    }
}