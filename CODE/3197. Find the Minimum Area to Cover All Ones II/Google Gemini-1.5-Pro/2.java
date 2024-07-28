class Solution {
    public int minimumSum(int[][] grid) {
        // Step 1: Find candidate rectangles
        List<Rectangle> rectangles = findCandidateRectangles(grid);

        // Step 2: Try all combinations of 3 rectangles
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < rectangles.size(); i++) {
            for (int j = i + 1; j < rectangles.size(); j++) {
                for (int k = j + 1; k < rectangles.size(); k++) {
                    Rectangle r1 = rectangles.get(i);
                    Rectangle r2 = rectangles.get(j);
                    Rectangle r3 = rectangles.get(k);

                    // Step 3: Check if the rectangles cover all 1's and are non-overlapping
                    if (coversAllOnes(grid, r1, r2, r3) && !isOverlapping(r1, r2, r3)) {
                        minArea = Math.min(minArea, r1.getArea() + r2.getArea() + r3.getArea());
                    }
                }
            }
        }

        return minArea;
    }

    // Helper function to find all possible rectangles formed by 1's
    private List<Rectangle> findCandidateRectangles(int[][] grid) {
        List<Rectangle> rectangles = new ArrayList<>();
        int m = grid.length, n = grid[0].length;

        for (int top = 0; top < m; top++) {
            for (int left = 0; left < n; left++) {
                if (grid[top][left] == 1) {
                    for (int bottom = top; bottom < m; bottom++) {
                        for (int right = left; right < n; right++) {
                            if (grid[bottom][right] == 1 && isValidRectangle(grid, top, left, bottom, right)) {
                                rectangles.add(new Rectangle(top, left, bottom, right));
                            }
                        }
                    }
                }
            }
        }
        return rectangles;
    }

    // Helper function to check if a rectangle is valid (contains only 1's)
    private boolean isValidRectangle(int[][] grid, int top, int left, int bottom, int right) {
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper function to check if three rectangles cover all 1's in the grid
    private boolean coversAllOnes(int[][] grid, Rectangle r1, Rectangle r2, Rectangle r3) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !r1.contains(i, j) && !r2.contains(i, j) && !r3.contains(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper function to check if any two rectangles overlap
    private boolean isOverlapping(Rectangle r1, Rectangle r2, Rectangle r3) {
        return r1.overlaps(r2) || r1.overlaps(r3) || r2.overlaps(r3);
    }

    // Inner class to represent a rectangle
    class Rectangle {
        int top, left, bottom, right;

        public Rectangle(int top, int left, int bottom, int right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }

        public int getArea() {
            return (bottom - top + 1) * (right - left + 1);
        }

        public boolean contains(int row, int col) {
            return row >= top && row <= bottom && col >= left && col <= right;
        }

        public boolean overlaps(Rectangle other) {
            return !(left > other.right || right < other.left || top > other.bottom || bottom < other.top);
        }
    }
}