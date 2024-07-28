import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Long> memo = new HashMap<>();
    private static final int MOD = 1000000007;

    public int waysToReachStair(int k) {
        // Special case
        if (k == 0) return 2;
        return (int) (waysToReachStairHelper(1, 0, k) % MOD);
    }

    private long waysToReachStairHelper(int currentStair, int jump, int k) {
        // If we reached the target stair k
        if (currentStair == k) return 1;
        // If we passed the target stair k, this path is invalid
        if (currentStair > k) return 0;

        String key = currentStair + "," + jump;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Count ways from this position
        long ways = 0;

        // Option 1: Go down (currentStair > 0)
        if (currentStair > 0) {
            ways += waysToReachStairHelper(currentStair - 1, jump, k);
        }

        // Option 2: Go up
        ways += waysToReachStairHelper(currentStair + (1 << jump), jump + 1, k);

        // Save to memo and return
        ways %= MOD;
        memo.put(key, ways);
        return ways;
    }
}
