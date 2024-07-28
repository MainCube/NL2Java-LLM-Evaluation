class Solution {
public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
List<Integer> answer = new ArrayList<>();

    for (int[] query : queries) {
        if (query[0] == 1) {
            int left = query[1];
            int right = query[2];
            int count = 0;
            
            for (int i = left; i <= right; i++) {
                if ((i == 0 || nums[i] > nums[i - 1]) &&
                    (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                    count++;
                }
            }
            
            answer.add(count);
        } else {
            int index = query[1];
            int value = query[2];
            nums[index] = value;
        }
    }
    
    return answer;
}
}