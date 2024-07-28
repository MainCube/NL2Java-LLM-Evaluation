class Solution {
    public int minimumOperations(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        
        // Count elements with remainder 1 and 2 when divided by 3
        for (int num : nums) {
            if (num % 3 == 1) {
                count1++;
            } else if (num % 3 == 2) {
                count2++;
            }
        }
        
        // The total operations needed is the sum of all adjustments for remainders
        return count1 + count2;
    }
}