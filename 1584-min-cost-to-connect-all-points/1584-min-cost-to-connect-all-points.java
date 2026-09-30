class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int min_cost = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();

        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int cost = cell[0];
            int index = cell[1];

            if (visited[index]) {
                continue;
            }

            visited[index] = true;
            min_cost = min_cost + cost;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[i][0] - points[index][0]) + Math.abs(points[i][1] - points[index][1]);
                    if (dist < map.getOrDefault(i, Integer.MAX_VALUE)) {
                        map.put(i, dist);
                        pq.offer(new int[] {dist, i});
                    }
                }
            }
        }

        return min_cost;
    }
}