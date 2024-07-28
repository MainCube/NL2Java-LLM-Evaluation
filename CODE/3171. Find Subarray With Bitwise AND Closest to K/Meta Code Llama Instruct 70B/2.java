class Solution {
public int minimumDifference(int[] nums, int k) {
Arrays.sort(nums);
int min_diff = Integer.MAX_VALUE;
int left = 0, right = nums.length - 1;

    while (left < right) {
        if (nums[right] & k <= nums[left] & k) {
            min_diff = Math.min(min_diff, Math.abs(k - (nums[right] & k)));
            right--;
        } else {
            left++;
        }
    }
    
    return min_diff;
}


}