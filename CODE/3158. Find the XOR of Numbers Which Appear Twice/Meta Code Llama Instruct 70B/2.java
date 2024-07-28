public class Solution {
public int duplicateNumbersXOR(int[] nums) {
int xor_sum = 0;
for(int num : nums) {
xor_sum ^= num;
}
return xor_sum;
}
}