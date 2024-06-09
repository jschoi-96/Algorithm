import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = i + 1; j < computers[i].length; j++) {
                if (computers[i][j] == 1) { // 서로 이어져있는 경우 그래프에 추가
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        for(int i = 0; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
        
        return answer - 1;
    }
    
    public void bfs(int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        answer++;
        
        queue.add(start);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int next : graph.get(node)) {
                if (visited[next]) continue;
                System.out.println(next);
                visited[next] = true;
                queue.add(next);
            }
        }
    }
    
}