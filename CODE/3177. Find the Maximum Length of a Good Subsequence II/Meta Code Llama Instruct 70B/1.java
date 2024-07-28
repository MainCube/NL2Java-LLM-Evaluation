class Solution {
    public int maximumLength(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < nums.length) {
            if (right > 0 && nums[right - 1] != nums[right]) {
                count++;
            }

            while (count > k) {
                if (nums[left] != nums[left + 1]) {
                    count--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}