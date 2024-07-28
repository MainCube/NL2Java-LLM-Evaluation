class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort the indices based on the reward values in descending order
        Arrays.sort(indices, (i1, i2) -> rewardValues[i2] - rewardValues[i1]);
        
        int totalReward = 0;
        for (int i = 0; i < n; i++) {
            if (rewardValues[indices[i]] > totalReward) {
                totalReward += rewardValues[indices[i]];
            }
        }
        
        return totalReward;
    }
}
