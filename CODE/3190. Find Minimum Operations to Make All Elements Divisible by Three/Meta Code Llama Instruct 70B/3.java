class Solution {
    public int minimumOperations(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            int[] next = new int[3];
            for (int i = 0; i < 3; i++) {
                next[i] = dp[i] + num % (i + 1);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        next[i] = Math.min(next[i], dp[j] + Math.abs(num - (i + 1)));
                    }
                }
            }
            dp = next;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
