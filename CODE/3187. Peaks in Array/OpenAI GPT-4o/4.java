import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        
        // A helper function to determine if a position is a peak
        boolean isPeak(int[] arr, int i) {
            if (i <= 0 || i >= arr.length - 1) return false;
            return arr[i] > arr[i - 1] && arr[i] > arr[i + 1];
        }

        // Initial peak count array
        boolean[] isPeak = new boolean[n];
        int peakCount = 0;
        for (int i = 1; i < n - 1; i++) {
            isPeak[i] = nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
            if (isPeak[i]) peakCount++;
        }

        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                int count = 0;
                for (int i = l + 1; i < r; i++) {
                    if (isPeak(nums, i)) count++;
                }
                answer.add(count);
            } else if (query[0] == 2) {
                int index = query[1];
                int val = query[2];
                
                // Check and update peaks around the index before the update
                for (int i = Math.max(1, index - 1); i <= Math.min(n - 2, index + 1); i++) {
                    if (isPeak[i]) {
                        isPeak[i] = false;
                        peakCount--;
                    }
                }
                
                // Update the value in the array
                nums[index] = val;

                // Check and update peaks around the index after the update
                for (int i = Math.max(1, index - 1); i <= Math.min(n - 2, index + 1); i++) {
                    if (isPeak(nums, i)) {
                        if (!isPeak[i]) {
                            isPeak[i] = true;
                            peakCount++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
