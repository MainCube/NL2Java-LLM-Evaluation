import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        boolean[] isPeak = new boolean[n];

        // Function to check if an element is a peak
        boolean isPeak(int[] nums, int i) {
            if (i <= 0 || i >= nums.length - 1) {
                return false;
            }
            return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
        }

        // Preprocess the initial peaks
        for (int i = 1; i < n - 1; i++) {
            isPeak[i] = isPeak(nums, i);
        }

        // Handle queries
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Count peaks in subarray nums[l_i..r_i]
                int l = query[1];
                int r = query[2];
                int count = 0;
                for (int i = l + 1; i < r; i++) {
                    if (isPeak[i]) {
                        count++;
                    }
                }
                result.add(count);
            } else if (query[0] == 2) {
                // Update nums[index_i] to val_i
                int index = query[1];
                int val = query[2];
                nums[index] = val;

                // Update peaks status for index-1, index, index+1
                if (index > 0 && index < n - 1) {
                    isPeak[index] = isPeak(nums, index);
                }
                if (index - 1 > 0) {
                    isPeak[index - 1] = isPeak(nums, index - 1);
                }
                if (index + 1 < n - 1) {
                    isPeak[index + 1] = isPeak(nums, index + 1);
                }
            }
        }

        return result;
    }
}
