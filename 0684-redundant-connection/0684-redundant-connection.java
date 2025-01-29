class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int n;
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        int [] res = new int[2];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).remove((Integer) v);
            graph.get(v).remove((Integer) u);

            boolean [] visited = new boolean[n+1];
            dfs(u, visited);
            if (checkVisited(n, visited)) {
                res[0] = u;
                res[1] = v;
                // System.out.println(u + " " + v);
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return res;
    }

    public void dfs(int start, boolean[] visited) {
        visited[start] = true;

        for(int next : graph.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited);
            }
        }
    }

    public boolean checkVisited(int n, boolean[] visited) {
        for(int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}