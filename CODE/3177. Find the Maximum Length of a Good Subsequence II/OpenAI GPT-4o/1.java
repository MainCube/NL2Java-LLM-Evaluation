class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int left = 0;
        int changes = 0;

        for (int right = 0; right < n; right++) {
            if (right > 0 && nums[right] != nums[right - 1]) {
                changes++;
            }

            while (changes > k) {
                if (nums[left] != nums[left + 1]) {
                    changes--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
