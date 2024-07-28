class Solution {
        public int maxTotalReward(int[] rewardValues) {
    // Sort the array in descending order
    Arrays.sort(rewardValues);
    Collections.reverse(Arrays.asList(rewardValues));

    // Initialize the total reward
    int x = 0;

    // Iterate through the sorted array
    for (int reward : rewardValues) {
        // If the current reward is greater than the total reward, add it to the total reward
        if (reward > x) {
            x += reward;
        }
    }

    return x;


        }
}
