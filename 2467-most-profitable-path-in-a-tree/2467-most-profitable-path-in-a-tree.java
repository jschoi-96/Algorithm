class Solution {
    int n;
    int [] bob_time;
    boolean [] bob_visited;
    List<List<Integer>> graph = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = edges.length + 1;
        bob_time = new int[n+1];
        bob_visited = new boolean[n+1];

        Arrays.fill(bob_time, -1);
        bob_time[bob] = 0;

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        calculateBob(bob, bob_time);
        // for(int i = 0; i < n; i++) {
        //     System.out.print(bob_time[i] + " ");
        // }
        calculateIncome(amount);
        return max;
    }

    public boolean calculateBob(int bob, int[] bob_time) {
        if (bob == 0) { // 노드 0에 도착했을 때 
            return true;
        }

        bob_visited[bob] = true;
        for(int nxt : graph.get(bob)) {
            if (!bob_visited[nxt]) {
                bob_time[nxt] = bob_time[bob] + 1;
                if (calculateBob(nxt, bob_time)) {
                    return true;
                }
                bob_time[nxt] = -1;
            }
        }
        return false;
    }

    public void calculateIncome(int[] amount) {
        boolean [] visited = new boolean[n + 1];
        visited[0] = true;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0, amount[0] , 0}); // 현재노드, reward, time 순서대로 삽입

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int node = cur[0];
            int income = cur[1];
            int a_time = cur[2];

            boolean isLeaf = true;
            for(int nxt : graph.get(node)) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                
                int b_time = bob_time[nxt];
                int newIncome = income;
                if (a_time + 1 < b_time || b_time == -1) { 
                    // bob이 방문하지 않았거나 앨리스보다 늦게 방문하는 경우
                    newIncome += amount[nxt];
                }

                else if (a_time + 1 == b_time) {
                    // 동시에 방문하는 경우는 reward / 2
                    newIncome += amount[nxt] / 2;
                }
                q.add(new int[]{nxt, newIncome, a_time + 1});
                isLeaf = false;
            }
            if (isLeaf) {
                max = Math.max(max, income);
            }
        }
    }
}