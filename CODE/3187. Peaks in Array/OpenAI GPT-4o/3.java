import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isPeak = new boolean[n];
        
        // Initial peak calculation
        for (int i = 1; i < n - 1; i++) {
            isPeak[i] = nums[i] > nums[i-1] && nums[i] > nums[i+1];
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                int peakCount = 0;
                
                // Count peaks in the subarray
                for (int i = l + 1; i < r; i++) {
                    if (isPeak[i]) {
                        peakCount++;
                    }
                }
                
                result.add(peakCount);
            } else if (query[0] == 2) {
                int index = query[1];
                int val = query[2];
                nums[index] = val;
                
                // Update the peak status of the affected elements
                if (index > 0) {
                    isPeak[index - 1] = (index - 1 > 0 && index - 1 < n - 1) && (nums[index - 1] > nums[index - 2] && nums[index - 1] > nums[index]);
                }
                if (index < n - 1) {
                    isPeak[index + 1] = (index + 1 > 0 && index + 1 < n - 1) && (nums[index + 1] > nums[index] && nums[index + 1] > nums[index + 2]);
                }
                isPeak[index] = (index > 0 && index < n - 1) && (nums[index] > nums[index - 1] && nums[index] > nums[index + 1]);
            }
        }
        
        return result;
    }
}
