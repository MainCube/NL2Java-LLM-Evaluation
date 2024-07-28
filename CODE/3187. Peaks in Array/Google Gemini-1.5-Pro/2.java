class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();

        // Step 1: Preprocess the array to efficiently calculate peak counts.
        // peaks[i] will store 1 if nums[i] is a peak, otherwise 0.
        int[] peaks = new int[n];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peaks[i] = 1;
            }
        }

        // Step 2: Calculate prefix sums of the peaks array.
        // prefixSums[i] will store the count of peaks in nums[0...i].
        int[] prefixSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + peaks[i - 1];
        }

        // Step 3: Process each query.
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Type 1 query: Count peaks in subarray nums[l...r].
                int l = query[1], r = query[2];
                // The count of peaks in nums[l...r] is prefixSums[r + 1] - prefixSums[l].
                answer.add(prefixSums[r + 1] - prefixSums[l]);
            } else {
                // Type 2 query: Update nums[index] to val.
                int index = query[1], val = query[2];
                nums[index] = val;

                // Update peaks array for index, index - 1, and index + 1.
                for (int i = Math.max(0, index - 1); i <= Math.min(n - 1, index + 1); i++) {
                    peaks[i] = (i > 0 && i < n - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) ? 1 : 0;
                }

                // Recalculate prefix sums from index onwards.
                for (int i = index; i <= n; i++) {
                    prefixSums[i] = prefixSums[i - 1] + peaks[i - 1];
                }
            }
        }

        return answer;
    }
}