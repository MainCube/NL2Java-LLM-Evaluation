class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int andValue = nums[i];
            for (int j = i; j < n; j++) {
                andValue &= nums[j];
                int currentDifference = Math.abs(k - andValue);
                if (currentDifference < minDifference) {
                    minDifference = currentDifference;
                }
                if (minDifference == 0) {
                    return 0; // Early exit if the difference is zero
                }
                // Since AND value can only decrease or stay the same, if it's already smaller than k, 
                // increasing the window size will only get the value smaller or equal
                if (andValue < k) break;
            }
        }
        return minDifference;
    }
}
