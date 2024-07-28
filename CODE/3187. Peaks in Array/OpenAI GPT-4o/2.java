import java.util.*;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        // Auxiliary array to keep track of peaks
        boolean[] isPeak = new boolean[n];
        
        // Initialize the isPeak array
        for (int i = 1; i < n - 1; i++) {
            isPeak[i] = nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
        }
        
        // Helper function to check if an index is a peak
        // No need to check boundaries, they are never considered peaks
        boolean isPeak(int[] nums, int index) {
            return index > 0 && index < nums.length - 1 && nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
        }
        
        // Process each query
        for (int[] query : queries) {
            if (query[0] == 2) {
                // Update query
                int index = query[1];
                int newVal = query[2];
                
                // Update the nums array
                nums[index] = newVal;
                
                // Recalculate the peak status for the affected elements
                if (index > 0) {
                    isPeak[index - 1] = isPeak(nums, index - 1);
                }
                if (index < n - 1) {
                    isPeak[index + 1] = isPeak(nums, index + 1);
                }
                isPeak[index] = isPeak(nums, index);
                
            } else if (query[0] == 1) {
                // Count peaks query
                int l = query[1];
                int r = query[2];
                int peakCount = 0;
                
                // Count peaks in the subarray
                for (int i = l + 1; i < r; i++) {
                    if (isPeak[i]) {
                        peakCount++;
                    }
                }
                
                // Add the result to the list
                result.add(peakCount);
            }
        }
        
        return result;
    }
}
