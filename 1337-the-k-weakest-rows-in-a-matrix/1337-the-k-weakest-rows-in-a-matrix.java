class Solution {
    class Pair {
        int index;
        int count;

        Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.index - b.index : a.count - b.count);

        int i = 0;

        for (int[] row: mat) {
            int low = 0;
            int high = n - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (row[mid] == 1) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            pq.offer(new Pair(i, low));
            i++;
        }

        int[] ans = new int[k];

        for (int j = 0; j < k; j++) {
            Pair cell = pq.poll();
            ans[j] = cell.index;
        }

        return ans;


    }
}