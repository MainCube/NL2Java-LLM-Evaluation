class Solution {
    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;

    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] tree = new int[4 * n][2];

        // Build the segment tree
        buildTree(tree, nums, 0, n - 1, 0);

        List<Integer> results = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == TYPE_1) {
                // Query type 1: Find the number of peaks in the subarray
                int l = query[1];
                int r = query[2];
                int result = queryTree(tree, l, r, 0, n - 1, 0);
                results.add(result);
            } else {
                // Query type 2: Update the value at index_i to val_i
                int index = query[1];
                int val = query[2];
                updateTree(tree, index, val, 0, n - 1, 0);
            }
        }

        return results;
    }

    private void buildTree(int[][] tree, int[] nums, int start, int end, int node) {
        if (start == end) {
            tree[node][0] = 0;
            tree[node][1] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(tree, nums, start, mid, 2 * node + 1);
        buildTree(tree, nums, mid + 1, end, 2 * node + 2);

        tree[node][0] = tree[2 * node + 1][0] + tree[2 * node + 2][0];
        tree[node][1] = tree[2 * node + 1][1] + tree[2 * node + 2][1];

        if (start != end && isPeak(tree, 2 * node + 1, 2 * node + 2)) {
            tree[node][0]++;
        }
    }

    private boolean isPeak(int[][] tree, int leftNode, int rightNode) {
        return tree[leftNode][1] > tree[rightNode][1];
    }

    private int queryTree(int[][] tree, int l, int r, int start, int end, int node) {
        if (l > end || r < start) {
            return 0;
        }

        if (l <= start && end <= r) {
            return tree[node][0];
        }

        int mid = start + (end - start) / 2;
        int leftResult = queryTree(tree, l, r, start, mid, 2 * node + 1);
        int rightResult = queryTree(tree, l, r, mid + 1, end, 2 * node + 2);

        return leftResult + rightResult;
    }

    private void updateTree(int[][] tree, int index, int val, int start, int end, int node) {
        if (start == end) {
            tree[node][0] = 0;
            tree[node][1] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (index <= mid) {
            updateTree(tree, index, val, start, mid, 2 * node + 1);
        } else {
            updateTree(tree, index, val, mid + 1, end, 2 * node + 2);
        }

        tree[node][0] = tree[2 * node + 1][0] + tree[2 * node + 2][0];
        tree[node][1] = tree[2 * node + 1][1] + tree[2 * node + 2][1];

        if (start != end && isPeak(tree, 2 * node + 1, 2 * node + 2)) {
            tree[node][0]++;
        }
    }
}
