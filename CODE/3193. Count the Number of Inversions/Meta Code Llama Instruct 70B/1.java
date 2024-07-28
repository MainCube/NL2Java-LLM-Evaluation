class Solution {
    int mod = (int)1e9+7;
    int[][] dp;
    int[][] inv;
    int[][] cnt;

    public int numberOfPermutations(int n, int[][] requirements) {
        dp = new int[n][n];
        inv = new int[n][n];
        cnt = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = -1;
                inv[i][j] = -1;
                cnt[i][j] = -1;
            }
        }
        for(int i=0;i<n;i++) {
            dp[i][i] = 1;
            inv[i][i] = 0;
            cnt[i][i] = 0;
        }
        for(int[] req:requirements) {
            int end = req[0];
            int count = req[1];
            cnt[end][end] = count;
        }
        return dfs(0,n-1);
    }

    public int dfs(int start, int end) {
        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        if(start == end) {
            return 1;
        }
        int res = 0;
        for(int i=start;i<=end;i++) {
            if(cnt[start][end] == inv[start][i]) {
                res = (res + dfs(start,i-1)*dfs(i+1,end))%mod;
            }
        }
        dp[start][end] = res;
        return res;
    }

    public int getInv(int start, int end) {
        if(inv[start][end] != -1) {
            return inv[start][end];
        }
        if(start == end) {
            return 0;
        }
        int res = 0;
        for(int i=start;i<end;i++) {
            res += getInv(start,i)*getInv(i+1,end);
        }
        inv[start][end] = res;
        return res;
    }
}
