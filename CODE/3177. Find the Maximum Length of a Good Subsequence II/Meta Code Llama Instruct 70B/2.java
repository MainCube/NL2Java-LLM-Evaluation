class Solution {
    public int maximumLength(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int maxLen = 0;
        while (left <= right) {
            if (nums[right] - nums[left] <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            if (nums[left] <= nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxLen;
    }
}
