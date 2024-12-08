class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int [] deg = new int[numCourses];

        boolean [] visited = new boolean[numCourses];
        for(int [] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            graph.get(v).add(u);
            deg[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < deg.length; i++) {
            if (deg[i] == 0) q.add(i);
        }

        int visCount = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            visCount++;
            for(int nxt : graph.get(cur)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        return visCount == numCourses;
    }
}