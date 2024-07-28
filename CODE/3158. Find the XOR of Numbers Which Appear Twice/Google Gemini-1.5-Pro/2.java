class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor = 0; // Initialize the XOR accumulator

        // Iterate through each element in the array
        for (int num : nums) {
            xor ^= num; // XOR the current element with the accumulator
        }

        return xor; // Return the final XOR result
    }
}