class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        boolean flip = false;

        for (int num : nums) {
            if (flip) {
                num = num == 1 ? 0 : 1;
            }
            if (num == 0) {
                operations++;
                flip = !flip;
            }
        }
        return operations;
    }
}