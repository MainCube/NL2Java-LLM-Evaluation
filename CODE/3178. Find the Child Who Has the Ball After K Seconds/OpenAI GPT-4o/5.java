class Solution {
    public int numberOfChild(int n, int k) {
        int cycleLength = 2 * (n - 1);
        int remainder = k % cycleLength;
        
        if (remainder < n) {
            return remainder; // Forward phase
        } else {
            return cycleLength - remainder; // Backward phase
        }
    }
}
