class Solution {
    public int maximumLength(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = 0;
        
        while (right < nums.length) {
            if (nums[right] - nums[left] != 1) {
                count++;
            } else {
                left++;
            }
            
            if (count > k) {
                right++;
                count--;
            }
            
            right++;
        }
        
        return nums.length - count;
    }
}