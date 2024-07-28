class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int totalPairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Store the count of numbers in nums2 that are divisible by k
        for (int num : nums2) {
            int key = num / k;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // Iterate through nums1 and check if its division with k is present in the HashMap
        for (int num : nums1) {
            int key = num / k;
            if (map.containsKey(key)) {
                totalPairs += map.get(key);
            }
        }
        
        return totalPairs;
    }
}
