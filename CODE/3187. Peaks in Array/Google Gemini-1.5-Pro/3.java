class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;

        // Handle edge case: an array with less than 3 elements cannot have peaks
        if (n < 3) {
            for (int[] query : queries) {
                if (query[0] == 1) {
                    answer.add(0); 
                }
            }
            return answer;
        }

        // Create a difference array to track changes in peak counts efficiently
        // diff[i] = 1 if nums[i] is a peak, -1 if it was a peak but isn't anymore, 0 otherwise
        int[] diff = new int[n];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                diff[i] = 1;
            }
        }

        // Process each query
        for (int[] query : queries) {
            int type = query[0];
            if (type == 1) { // Type 1: Count peaks in a range
                int l = query[1];
                int r = query[2];
                answer.add(countPeaksInRange(diff, l, r));
            } else { // Type 2: Update a value in nums and potentially the diff array
                int index = query[1];
                int val = query[2];
                updateArrayAndDiff(nums, diff, index, val);
            }
        }

        return answer;
    }

    // Helper function to count peaks within a given range using the difference array
    private int countPeaksInRange(int[] diff, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            count += diff[i];
        }
        return Math.max(0, count); // Ensure count is non-negative
    }

    // Helper function to update nums and the difference array after a value change
    private void updateArrayAndDiff(int[] nums, int[] diff, int index, int val) {
        // If the value hasn't changed, no need to update
        if (nums[index] == val) {
            return;
        }

        // Update nums with the new value
        nums[index] = val;

        // Update the difference array based on changes in peak status
        for (int i = Math.max(1, index - 1); i <= Math.min(index + 1, nums.length - 2); i++) {
            boolean isPeakBefore = (i > 0 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]);
            boolean isPeakAfter = (i > 0 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]);

            // Adjust diff[i] based on whether the element at index i became a peak or stopped being one
            if (isPeakBefore && !isPeakAfter) {
                diff[i]--; 
            } else if (!isPeakBefore && isPeakAfter) {
                diff[i]++; 
            }
        }
    }
}