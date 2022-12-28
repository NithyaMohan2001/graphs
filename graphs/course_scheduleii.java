class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++)
            adj[prerequisites[i][0]].add(prerequisites[i][1]);

        int visited[] = new int[numCourses];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0) {
                if (topSort(i, res, adj, visited) == false)
                    return new int[0];
            }
        }
        int ans[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    public boolean topSort(int curr, List<Integer> res, List<Integer> adj[], int visited[]) {
        visited[curr] = 1;
        List<Integer> neighbours = adj[curr];
        for (Integer i : neighbours) {
            if (visited[i] == 1)
                return false;
            if (visited[i] == 0) {
                if (topSort(i, res, adj, visited) == false)
                    return false;
            }
        }
        visited[curr] = 2;
        res.add(curr);
        return true;
    }
}
