class Solution {
    private int[] nums;
    private int[] tree;
    private int n;

    private void buildSegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        this.nums = nums;
        buildSegmentTree(0, 0, n - 1);
    }

    private void buildSegmentTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = (nums[start] > nums[start - 1] && nums[start] > nums[start + 1]) ? 1 : 0;
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(2 * node + 1, start, mid);
        buildSegmentTree(2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    private void update(int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = (val > nums[index - 1] && val > nums[index + 1]) ? 1 : 0;
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

    private int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        return query(2 * node + 1, start, mid, left, right) + query(2 * node + 2, mid + 1, end, left, right);
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        buildSegmentTree(nums);

        List<Integer> answer = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                answer.add(query(0, 0, n - 1, query[1], query[2]));
            } else {
                update(0, 0, n - 1, query[1], query[2]);
            }
        }
        return answer;
    }
}
