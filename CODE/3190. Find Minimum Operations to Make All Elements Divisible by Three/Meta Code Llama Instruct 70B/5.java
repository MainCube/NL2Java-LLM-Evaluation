class Solution {
    public int minimumOperations(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num % 3]++;
        }
        int minOps = Math.min(count[1], count[2]);
        return count[0] + Math.abs(count[1] - count[2]);
    }
}
