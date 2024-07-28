class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> rewardValues[b] - rewardValues[a]);
        int totalReward = 0;
        for (int i = 0; i < n; i++) {
            totalReward += rewardValues[indices[i]];
        }
        return totalReward;
    }
}
