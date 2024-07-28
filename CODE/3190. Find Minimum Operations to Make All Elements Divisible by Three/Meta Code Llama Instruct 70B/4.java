class Solution {
public int minimumOperations(int[] nums) {
    int[] count = new int[3];
    for(int num : nums) {
        count[num % 3]++;
    }
    return Math.min(count[1], count[2]) + count[0];
}
}