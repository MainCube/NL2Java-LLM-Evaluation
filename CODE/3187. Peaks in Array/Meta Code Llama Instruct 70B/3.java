class Solution {
    private static class SegmentTree {
        int[] tree;
        int[] nums;
        int n;

        public SegmentTree(int[] nums) {
            this.nums = nums;
            n = nums.length;
            tree = new int[4 * n];
            buildTree(0, 0, n - 1);
        }

        private void buildTree(int node, int start, int end) {
            if (start == end) {
                tree[node] = isPeak(start) ? 1 : 0;
                return;
            }

            int mid = start + (end - start) / 2;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }

        private boolean isPeak(int index) {
            if (index == 0) {
                return nums[0] > nums[1];
            } else if (index == n - 1) {
                return nums[n - 1] > nums[n - 2];
            } else {
                return nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
            }
        }

        private void update(int node, int start, int end, int index, int val) {
            if (start == end) {
                nums[index] = val;
                tree[node] = isPeak(index) ? 1 : 0;
                return;
            }

            int mid = start + (end - start) / 2;
            if (index <= mid) {
                update(2 * node + 1, start, mid, index, val);
            } else {
                update(2 * node + 2, mid + 1, end, index, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }

        private int query(int node, int start, int end, int l, int r) {
            if (start > r || end < l) {
                return 0;
            }

            if (start >= l && end <= r) {
                return tree[node];
            }

            int mid = start + (end - start) / 2;
            return query(2 * node + 1, start, mid, l, r) + query(2 * node + 2, mid + 1, end, l, r);
        }
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        SegmentTree segmentTree = new SegmentTree(nums);
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                segmentTree.update(0, 0, nums.length - 1, query[1], query[2]);
            } else {
                result.add(segmentTree.query(0, 0, nums.length - 1, query[1], query[2]));
            }
        }

        return result;
    }
}
