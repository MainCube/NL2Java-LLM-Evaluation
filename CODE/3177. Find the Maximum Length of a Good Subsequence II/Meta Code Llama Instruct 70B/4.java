class Solution {
    public int maximumLength(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] subseq = new int[n];
        int len = 0;
        subseq[len++] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != subseq[len - 1]) {
                subseq[len++] = nums[i];
            }
            while (len > k + 1) {
                len--;
            }
        }

        return len;
    }
}
