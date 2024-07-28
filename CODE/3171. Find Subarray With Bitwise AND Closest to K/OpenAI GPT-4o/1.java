class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        // Iterate over each possible starting point of the subarray
        for (int i = 0; i < n; i++) {
            int currentAnd = nums[i];
            
            // Expand the subarray to the right
            for (int j = i; j < n; j++) {
                currentAnd &= nums[j];
                minDiff = Math.min(minDiff, Math.abs(k - currentAnd));
                
                // If we achieve the smallest possible difference (0), we can stop early
                if (minDiff == 0) {
                    return 0;
                }
            }
        }
        
        return minDiff;
    }
}
