class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int diff = Math.abs(k - (nums[left] & nums[right]));
            minDiff = Math.min(minDiff, diff);
            if (nums[left] & nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        return minDiff;
    }
}
