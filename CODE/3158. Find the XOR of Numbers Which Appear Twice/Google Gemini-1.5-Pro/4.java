class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            // XOR each element in the array with the current XOR value
            xor ^= num;
        }
        return xor;
    }
}