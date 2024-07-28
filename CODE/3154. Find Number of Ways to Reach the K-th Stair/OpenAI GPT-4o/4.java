import java.util.*;

class Solution {
    public int waysToReachStair(int k) {
        // Edge case for k = 0
        if (k == 0) return 2;
        
        // Map to store the number of ways to reach each stair
        Map<Integer, Integer> dp = new HashMap<>();
        
        // Initialize the starting point
        dp.put(1, 1);
        
        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // {stair, jump}
        
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int stair = state[0];
            int jump = state[1];
            
            // Calculate the next stair if we go down
            if (stair - 1 >= 0) {
                dp.put(stair - 1, dp.getOrDefault(stair - 1, 0) + dp.get(stair));
                queue.add(new int[]{stair - 1, jump});
            }
            
            // Calculate the next stair if we go up
            int nextStair = stair + (1 << jump);
            dp.put(nextStair, dp.getOrDefault(nextStair, 0) + dp.get(stair));
            queue.add(new int[]{nextStair, jump + 1});
        }
        
        return dp.getOrDefault(k, 0);
    }
}
