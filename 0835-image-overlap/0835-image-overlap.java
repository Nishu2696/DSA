class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) listA.add(new int[] {i, j});
                if (img2[i][j] == 1) listB.add(new int[] {i, j});
            }
        }

        int[][] count = new int[2*n][2*n];
        int best = 0;

        for (int[] a: listA) {
            int x = a[0];
            int y = a[1];
            for (int[] b: listB) {
                int dx = b[0] - x + n;
                int dy = b[1] - y + n;

                count[dx][dy]++;
                best = Math.max(best, count[dx][dy]);
            }
        }

        return best;
    }
}