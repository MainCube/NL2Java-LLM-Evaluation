public class Solution {
public int minOperations(int[] nums) {
    int count = 0;
    for(int num : nums) {
        if(num == 0)
            count++;
    }
    return count;
}
}