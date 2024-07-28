class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();

        // Step 1: Preprocess the array to mark peak elements
        boolean[] isPeak = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                isPeak[i] = true;
            }
        }

        // Step 2: Process each query
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Type 1 query: Count peaks in subarray
                int left = query[1];
                int right = query[2];
                int count = 0;
                for (int i = left + 1; i < right; i++) { // Exclude boundaries
                    if (isPeak[i]) {
                        count++;
                    }
                }
                answer.add(count);
            } else {
                // Type 2 query: Update array element
                int index = query[1];
                int val = query[2];
                nums[index] = val;

                // Update peak status for affected elements
                for (int i = Math.max(1, index - 1); i <= Math.min(n - 2, index + 1); i++) {
                    isPeak[i] = (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]);
                }
            }
        }

        return answer;
    }
}