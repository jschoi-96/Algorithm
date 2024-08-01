import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int [] wc;
    static int [] lc;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        wc = new int[n+1];
        lc = new int[n+1];
        
        for(int [] result : results) {
            int a = result[0];
            int b = result[1];
            graph.get(a).add(b);
        }
        
        
        for(int i = 1; i <= n; i++) {
            bfs(i, true);
            bfs(i, false);
            //System.out.print(graph.get(i));
        }
        
        for(int i = 1; i <= n; i++) {
            // System.out.println("wc: " + wc[i] + " lc: " + lc[i]);
            if (wc[i] + lc[i] == n - 1) answer++;
        }
    
        return answer;
    }
    
    public void bfs(int start, boolean flag) {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[graph.size()];
        visited[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                q.add(nxt);
                
                if (flag) wc[start]++;
                else lc[nxt]++;
            }
        }
    }
}