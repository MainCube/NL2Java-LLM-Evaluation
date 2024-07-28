class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                int left = query[1];
                int right = query[2];
                answer.add(countPeaks(nums, left, right));
            } else {
                int index = query[1];
                int value = query[2];
                nums[index] = value;
            }
        }
        return answer;
    }

    private int countPeaks(int[] nums, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (i > 0 && i < nums.length - 1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    count++;
                }
            } else if (i == 0 && nums[i] > nums[i + 1]) {
                count++;
            } else if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
