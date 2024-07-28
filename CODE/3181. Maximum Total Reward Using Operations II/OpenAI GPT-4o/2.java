import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Step 1: Sort the rewardValues array in descending order
        Arrays.sort(rewardValues);
        
        // Initialize total reward x to 0
        int totalReward = 0;
        
        // Step 2: Iterate through the sorted reward values in reverse order
        for (int i = rewardValues.length - 1; i >= 0; i--) {
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
            }
        }
        
        // Step 3: Return the maximum total reward
        return totalReward;
    }
}
