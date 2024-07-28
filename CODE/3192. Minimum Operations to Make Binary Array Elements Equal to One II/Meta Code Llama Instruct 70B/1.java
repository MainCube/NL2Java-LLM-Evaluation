public class Solution {
public int minOperations(int[] nums) {
int count0 = 0;
int count1 = 0;

for(int num : nums) {
    if(num == 0) {
        count0++;
    } else {
        count1++;
    }
}

int operationsTo0 = nums.length - count0;
int operationsTo1 = nums.length - count1;

return Math.min(operationsTo0, operationsTo1);


}
}