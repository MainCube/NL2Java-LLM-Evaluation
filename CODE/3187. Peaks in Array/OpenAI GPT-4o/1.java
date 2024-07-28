import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Count peaks in the subarray nums[l_i..r_i]
                int l = query[1];
                int r = query[2];
                result.add(countPeaks(nums, l, r));
            } else if (query[0] == 2) {
                // Update nums[index_i] to val_i
                int index = query[1];
                int val = query[2];
                nums[index] = val;
            }
        }
        
        return result;
    }
    
    private int countPeaks(int[] nums, int l, int r) {
        int count = 0;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
