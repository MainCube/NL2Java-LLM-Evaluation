import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Long> memo = new HashMap<>();

    public int waysToReachStair(int k) {
        return (int) waysToReach(1, 0, k);
    }

    private long waysToReach(int currentStair, int jump, int target) {
        if (currentStair == target) {
            return 1;
        }
        if (currentStair > target + 1) {
            return 0;
        }

        int key = currentStair * 100000 + jump;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long ways = 0;

        // Option 1: Jump up
        int nextStair = currentStair + (1 << jump);
        ways += waysToReach(nextStair, jump + 1, target);

        // Option 2: Go down
        if (currentStair > 1) {
            ways += waysToReach(currentStair - 1, jump, target);
        }

        memo.put(key, ways);
        return ways;
    }
}