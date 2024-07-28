class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0; // Initialize count of good pairs

        // Iterate through each element of nums1
        for (int i = 0; i < nums1.length; i++) {
            // Iterate through each element of nums2
            for (int j = 0; j < nums2.length; j++) {
                // Check if the current pair (i, j) is good
                if (nums1[i] % (nums2[j] * k) == 0) {
                    count++; // Increment count if the pair is good
                }
            }
        }

        return count; // Return the total count of good pairs
    }
}