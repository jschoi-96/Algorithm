import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static int [] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        dist = new int[n + 1];
        for(int [] ed : edge) {
            graph.get(ed[0]).add(ed[1]);
            graph.get(ed[1]).add(ed[0]);
        }
        
        //dfs(1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 1;
        visited[1] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                    dist[nxt] = dist[cur] + 1;
                    //System.out.println("cur: " + cur + " nxt: " + nxt);
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(dist[i], max);
        }
        
        for(int i = 1; i <= n; i++) {
            if (dist[i] == max) answer++;
        }
        return answer;
    }
}