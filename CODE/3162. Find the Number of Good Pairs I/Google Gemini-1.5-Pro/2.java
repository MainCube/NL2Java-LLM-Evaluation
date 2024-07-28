class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0; // Initialize the count of good pairs

        // Iterate through each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            // Iterate through each element in nums2
            for (int j = 0; j < nums2.length; j++) {
                // Check if the product of nums2[j] and k divides nums1[i]
                if (nums1[i] % (nums2[j] * k) == 0) {
                    count++; // If divisible, increment the count of good pairs
                }
            }
        }

        return count; // Return the total count of good pairs
    }
}