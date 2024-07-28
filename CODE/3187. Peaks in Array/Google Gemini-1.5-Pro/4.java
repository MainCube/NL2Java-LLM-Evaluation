import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        // Iterate through each query
        for (int[] query : queries) {
            int type = query[0];
            int l = query[1];
            int r = query[2];

            // Type 1: Count peaks in subarray nums[l..r]
            if (type == 1) {
                answer.add(countPeaksInRange(nums, l, r));
            } else { // Type 2: Update nums[index] to val
                nums[l] = r;
            }
        }

        return answer;
    }

    // Helper function to count peaks within a given range [l, r]
    private int countPeaksInRange(int[] nums, int l, int r) {
        int count = 0;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                count++;
            }
        }
        return count;
    }
}