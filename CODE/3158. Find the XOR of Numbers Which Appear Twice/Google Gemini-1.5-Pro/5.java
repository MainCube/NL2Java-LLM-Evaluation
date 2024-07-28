class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            // XOR each element with the running XOR.
            xor ^= num;
        }
        return xor;
    }
}