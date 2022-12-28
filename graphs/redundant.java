class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return new int[] { -1, -1 };
    }

    private int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);

        if (iroot != jroot) {
            parent[jroot] = iroot;
        }
    }

}
