import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Sort the reward values
        Arrays.sort(rewardValues);
        
        int x = 0;
        
        // Iterate through the sorted rewards
        for (int reward : rewardValues) {
            if (reward > x) {
                x += reward;
            }
        }
        
        return x;
    }
}
