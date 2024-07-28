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

    // Helper function to find the minimum area covered by two rectangles in a single array
    private int minArea(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        // Find the indices of the two largest elements
        int firstMax = 0, secondMax = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[firstMax]) {
                secondMax = firstMax;
                firstMax = i;
            } else if (arr[i] > arr[secondMax] && i != firstMax) {
                secondMax = i;
            }
        }

        // Calculate the minimum area covered by two rectangles
        int area = 0;
        for (int i = 0; i < n; i++) {
            if (i != firstMax && i != secondMax) {
                area += arr[i];
            }
        }
        area += Math.max(arr[firstMax], arr[secondMax]); // Choose the larger one to cover its entire range

        return area;
    }
}