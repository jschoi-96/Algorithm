class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 0 -> 1 -> 2 -> 0
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int [] deg = new int[numCourses];
        

        for(int [] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            deg[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < deg.length; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }

        if (q.isEmpty()) return new int[]{};


        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for(int nxt : graph.get(cur)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }

        if (res.size() != numCourses) return new int[]{};

        int [] result = new int[res.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}