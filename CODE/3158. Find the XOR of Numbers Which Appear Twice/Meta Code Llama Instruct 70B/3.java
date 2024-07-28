class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        int xorSum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                xorSum ^= nums[i];
            }
        }
        return xorSum;
    }
}
