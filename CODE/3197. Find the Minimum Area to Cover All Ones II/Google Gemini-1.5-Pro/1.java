class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowSum = new int[m]; // Stores the number of 1s in each row
        int[] colSum = new int[n]; // Stores the number of 1s in each column

        // Calculate rowSum and colSum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }

        // Find the minimum sum of areas using three rectangles
        return minArea(rowSum) + minArea(colSum);
    }

    // Helper function to find the minimum area covered by three rectangles
    // in a single array (representing either rows or columns)
    private int minArea(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        // Sort the array in descending order
        Arrays.sort(arr);
        int left = 0, right = n - 1;

        // Find the three largest non-overlapping segments
        int area = 0;
        for (int i = 0; i < 3 && left <= right; i++) {
            // Calculate the area of the current segment
            area += arr[left] * (right - left + 1);

            // Move the left and right pointers to find the next segment
            while (left <= right && arr[left] == arr[left + 1]) {
                left++;
            }
            left++;
            right--;
        }
        return area;
    }
}