class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int maxLength = 0;
        int left = 0;
        int count = 0;
        
        for (int right = 1; right < n; right++) {
            if (nums[right] != nums[right - 1]) {
                count++;
            }
            
            while (count > k) {
                if (nums[left] != nums[left + 1]) {
                    count--;
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
