class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int [] bobTime;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length;
        bobTime = new int[n+1];
        boolean [] visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            bobTime[i] = -1; // 초기화
        }
        bobTime[bob] = 0; // 0으로 초기화

        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        calculateBobPath(bob, -1, 0);   
        return dfs(0, -1, 0, amount);
    }

    public int dfs(int node, int parent, int time, int [] amount) {
        int reward = 0;

        if (bobTime[node] == -1 || time < bobTime[node]) { // 도달하지 않았거나 alice가 먼저 도달
            reward += amount[node];
        }

        else if (time == bobTime[node]) {
            reward += amount[node] / 2;
        }
        
        int maxIncome = Integer.MIN_VALUE;

        for(int next : graph.get(node)) {
            if (next == parent) continue;
            maxIncome = Math.max(maxIncome, dfs(next, node, time + 1, amount));
        }

        if (maxIncome == Integer.MIN_VALUE) {
            System.out.println(reward);
            return reward;
        }
        //System.out.println(reward + maxIncome);
        return reward + maxIncome;
    }

    public boolean calculateBobPath(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }

        for(int next : graph.get(node)) {
            if (next == parent) continue;
            if (calculateBobPath(next, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }
}