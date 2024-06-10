import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        for(int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        
        for(int [] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int [] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            graph.get(u).remove((Integer) v);
            graph.get(v).remove((Integer) u); 
            
            visited = new boolean[n + 1];
            int count = bfs(u, visited);
            int count2 = n - count;
            
            min = Math.min(min, Math.abs(count - count2));
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return min;
    }
    
    public int bfs(int start, boolean [] visited) {
        int cnt = 0;
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;
            for(int next : graph.get(node)) {
                if (visited[next]) continue;
                
                visited[next] = true;
                queue.add(next);
            }
        }
        return cnt;
    }
}