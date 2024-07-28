class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flips = 0;
        boolean inZeroSegment = false;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                if (!inZeroSegment) {
                    flips++; // Start of a new segment of 0s
                    inZeroSegment = true;
                }
            } else {
                inZeroSegment = false;
            }
        }

        return flips;
    }
}