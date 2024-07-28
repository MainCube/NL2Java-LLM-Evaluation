class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
