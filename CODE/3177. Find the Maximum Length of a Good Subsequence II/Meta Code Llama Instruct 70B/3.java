class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;

        for (int end = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (map.size() > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }

            if (map.size() <= k) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }
}
