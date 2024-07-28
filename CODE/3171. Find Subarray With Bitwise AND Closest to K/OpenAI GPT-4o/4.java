class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        for (int left = 0; left < n; ++left) {
            int currentAnd = nums[left];
            for (int right = left; right < n; ++right) {
                currentAnd &= nums[right];
                int currentDiff = Math.abs(k - currentAnd);
                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                }
                // If the currentAnd is already less than k, no need to extend the subarray further
                if (currentAnd < k) {
                    break;
                }
            }
        }
        
        return minDiff;
    }
}
