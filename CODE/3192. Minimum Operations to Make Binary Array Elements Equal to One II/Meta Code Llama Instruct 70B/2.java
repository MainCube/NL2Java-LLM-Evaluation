public class Solution {
public int minOperations(int[] nums) {
    Arrays.sort(nums);
    int median = nums.length % 2 == 0 ? nums[nums.length / 2 - 1] : nums[nums.length / 2];
    int sum = 0;
    for (int num : nums) {
        sum += Math.abs(num - median);
    }
    return sum;
}
}
