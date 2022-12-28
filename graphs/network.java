class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        for (int i = 1; i < n; i++) {
            for (int[] edge : times) {
                int source = edge[0];
                int dest = edge[1];
                int weight = edge[2];
                if (dist[source] != Integer.MAX_VALUE && dist[source] + weight < dist[dest]) {
                    dist[dest] = dist[source] + weight;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;

    }
}
