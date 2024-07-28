class Solution {
    public int maximumLength(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        int start = 0;
        int changes = 0;
        
        for (int end = 1; end < n; end++) {
            if (nums[end] != nums[end - 1]) {
                changes++;
            }
            while (changes > k) {
                if (nums[start] != nums[start + 1]) {
                    changes--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}
