import java.util.Arrays;

public class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Step 1: Sort the array
        Arrays.sort(rewardValues);
        
        // Step 2: Initialize the total reward
        int x = 0;
        
        // Step 3: Iterate over the sorted reward values
        for (int reward : rewardValues) {
            if (reward > x) {
                x += reward;
            }
        }
        
        // Step 4: Return the total reward collected
        return x;
    }
}
