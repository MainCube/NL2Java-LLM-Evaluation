class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                
                int currDiff = k - (min & max);
                minDiff = Math.min(minDiff, currDiff);
            }
        }
        
        return minDiff;
    }
}
