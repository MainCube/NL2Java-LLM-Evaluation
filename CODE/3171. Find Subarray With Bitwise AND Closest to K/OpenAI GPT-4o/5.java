class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int andValue = nums[i];
            for (int j = i; j < n; j++) {
                andValue &= nums[j];
                int currentDiff = Math.abs(k - andValue);
                minDiff = Math.min(minDiff, currentDiff);
                if (minDiff == 0) return 0; // early exit if we find exact match
                if (andValue == 0) break; // no need to proceed further as AND value will remain 0
            }
        }
        
        return minDiff;
    }
}
