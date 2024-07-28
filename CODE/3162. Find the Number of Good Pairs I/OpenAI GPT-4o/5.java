class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        
        // Iterate through all pairs (i, j)
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // Check if nums1[i] is divisible by nums2[j] * k
                if (nums1[i] % (nums2[j] * k) == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
