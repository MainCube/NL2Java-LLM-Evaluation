class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        for (int num : nums1) {
            if (map.containsKey(num / k)) {
                count += map.get(num / k);
            }
        }
        
        return count;
    }
}
