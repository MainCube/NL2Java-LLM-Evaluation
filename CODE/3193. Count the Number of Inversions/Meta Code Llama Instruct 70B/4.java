class Solution {
public int numberOfPermutations(int n, int[][] requirements) {
long[][] dp = new long[n][n];
for (int i = 0; i < n; i++) {
dp[i][i] = 1;
}
for (int i = 1; i < n; i++) {
for (int j = 0; j + i < n; j++) {
dp[j][j + i] = (j + 1 < n ? dp[j + 1][j + i] : 0) + (j > 0 ? dp[j - 1][j + i - 1] : 0);
}
}
long ans = 1;
for (int[] requirement : requirements) {
ans = ans * dp[0][requirement[0]] % 1000000007;
}
return (int) ans;
}
}