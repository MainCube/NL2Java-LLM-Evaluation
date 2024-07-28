import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();

        // Preprocess the array to mark peak elements
        boolean[] isPeak = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                isPeak[i] = true;
            }
        }

        // Process each query
        for (int[] query : queries) {
            int type = query[0];
            if (type == 1) { // Count peaks in a range
                int left = query[1];
                int right = query[2];
                int count = 0;
                for (int i = left + 1; i < right; i++) { // Exclude first and last elements
                    if (isPeak[i]) {
                        count++;
                    }
                }
                answer.add(count);
            } else { // Update an element
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