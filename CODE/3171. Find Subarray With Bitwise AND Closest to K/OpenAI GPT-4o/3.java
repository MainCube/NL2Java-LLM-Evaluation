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
                // Early break if exact match found
                if (currentDiff == 0) {
                    return 0;
                }
            }
        }
        
        return minDiff;
    }
}
