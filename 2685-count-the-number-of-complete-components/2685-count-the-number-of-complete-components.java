class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int cnt = 0;
    int [] deg;
    public int countCompleteComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        deg = new int[n];
        for(int [] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean [] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> list = new ArrayList<>();
                dfs(i, visited, list);
                boolean flag = true;
                for(int next : list) {
                    if (graph.get(next).size() != list.size() - 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int start, boolean[] visited, List<Integer> list ) {
        list.add(start);
        visited[start] = true;
        for(int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next, visited, list);
            }
        }
    }
}