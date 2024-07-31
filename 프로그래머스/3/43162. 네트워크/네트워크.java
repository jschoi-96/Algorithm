import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static boolean [] visited = new boolean[202];
    public int solution(int n, int[][] computers) {
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                // System.out.println(computers[i][j]);
                if (computers[i][j] == 1) {
                    graph.get(i+1).add(j+1);
                }
            }
        }
        
        // BFS
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if (!visited[i]){
                bfs(i);
                cnt++;
            }
        }
      
        return cnt;
    }
    
    public void bfs(int start) {
        q.add(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if (visited[nxt]) continue;
                q.add(nxt);
                visited[nxt] = true;
            }
        }
    }
}