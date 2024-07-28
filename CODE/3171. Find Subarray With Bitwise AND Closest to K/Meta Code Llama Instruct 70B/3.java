class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int and = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                and &= nums[j];
                ans = Math.min(ans, Math.abs(k - and));
            }
        }
        return ans;
    }
}
