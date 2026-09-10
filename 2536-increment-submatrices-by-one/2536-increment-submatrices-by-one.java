class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] row: mat) {
            Arrays.fill(row, 0);
        }

        for (int[] query: queries) {
            int i = query[0];
            int j = query[1];

            int x = query[2];
            int y = query[3];

            int minI = Math.min(i, x);
            int maxI = Math.max(i, x);

            int minJ = Math.min(j, y);
            int maxJ = Math.max(j, y);

            for (int a = minI; a <= maxI; a++) {
                for (int b = minJ; b <= maxJ; b++) {
                    mat[a][b] = mat[a][b] + 1;
                }
            }
        }

        return mat;
    }
}