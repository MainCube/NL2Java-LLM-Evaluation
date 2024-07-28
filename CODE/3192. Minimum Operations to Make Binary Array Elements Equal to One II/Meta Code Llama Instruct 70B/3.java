public class Solution {
public int minOperations(int[] nums) {
int minZeros = Integer.MAX_VALUE;

    for(int i = 0; i < nums.length; i++) {
        int zeros = 0;
        
        for(int j = i; j < nums.length; j++) {
            if(nums[j] == 0) {
                zeros++;
            }
        }
        
        minZeros = Math.min(minZeros, zeros);
    }
    
    return minZeros;
}


}