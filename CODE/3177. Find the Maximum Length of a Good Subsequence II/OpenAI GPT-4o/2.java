class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int changes = 0;
        int maxLength = 1;

        while (right < n - 1) {
            if (nums[right] != nums[right + 1]) {
                changes++;
            }
            right++;

            while (changes > k) {
                if (nums[left] != nums[left + 1]) {
                    changes--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
