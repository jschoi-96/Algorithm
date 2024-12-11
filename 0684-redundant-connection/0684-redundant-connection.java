class Solution {
    // 1. 간선을 하나 끊어도 정점이 전부 연결될 수 있는 곳을 찾음
    // 2. 간선이 여러개라면 가장 나중에 등장한 것을 삭제
    private List<List<Integer>> graph = new ArrayList<>();
    private boolean [] visited;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int [] res = new int[2];
        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).remove((Integer)v);
            graph.get(v).remove((Integer)u);

            visited = new boolean[n+1];
            dfs(1, n);
            if (allVisited(n)) {
                res[0] = u; 
                res[1] = v;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return res;
    }

    public void dfs(int start, int n) {
        visited[start] = true;
        for(int nxt : graph.get(start)) {
            // System.out.println("start: " + start + " nxt: " + nxt);
            if (!visited[nxt]) {
                visited[nxt] = true;
                dfs(nxt, n);
            }
        }
    }

    public boolean allVisited(int n) {
        for(int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
