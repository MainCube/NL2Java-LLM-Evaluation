class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int differences = 0;
        int max_length = 0;

        for (int right = 1; right < n; right++) {
            if (nums[right] != nums[right - 1]) {
                differences++;
            }

            while (differences > k) {
                if (nums[left + 1] != nums[left]) {
                    differences--;
                }
                left++;
            }

            max_length = Math.max(max_length, right - left + 1);
        }

        return max_length;
    }
}
