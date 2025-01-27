class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i <= numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            graph.get(u).add(v);
        }

        for(int [] query : queries) {
            int u = query[0];
            int v = query[1];

            boolean [] visited = new boolean[numCourses + 1];
            boolean flag = dfs(u, v, visited);
            res.add(flag);
        }

        return res;
    }

    public boolean dfs(int start, int end, boolean [] visited) {
        if (start == end) {
            return true;
        }

        visited[start] = true;
        for(Integer nxt : graph.get(start)) {
            if (!visited[nxt]) {
                if (dfs(nxt, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}