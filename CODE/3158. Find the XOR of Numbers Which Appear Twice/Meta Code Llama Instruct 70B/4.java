class Solution {
public int duplicateNumbersXOR(int[] nums) {
Arrays.sort(nums);
int result = 0;
for(int i = 1; i < nums.length; i++) {
if(nums[i] == nums[i-1]) {
result ^= nums[i];
}
}
return result;
}
}