class Solution {
public int minimumSum(int[][] grid) {
int m = grid.length;
int n = grid[0].length;
int[][] height = new int[m][n];
int[][] width = new int[m][n];
int[][] area = new int[m][n];
int ans = Integer.MAX_VALUE;
for (int i = 0; i < m; i++) {
for (int j = 0; j < n; j++) {
if (grid[i][j] == 1) {
height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
width[i][j] = (j == 0) ? 1 : width[i][j - 1] + 1;
area[i][j] = (i == 0 || j == 0) ? 1 : area[i - 1][j - 1] + 1;
}
}
}
for (int i = 0; i < m; i++) {
for (int j = 0; j < n; j++) {
if (grid[i][j] == 1) {
for (int h = i; h >= 0; h--) {
if (height[h][j] == 0) {
break;
}
for (int w = j; w >= 0; w--) {
if (width[i][w] == 0) {
break;
}
if (area[i][j] == area[h][w]) {
ans = Math.min(ans, height[h][j] * width[i][w]);
}
}
}
}
}
}
return ans;
}
}