import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int end = 0; // 그래프 최대 정점 값 
    int center = 0; // 생성한 정점
    
    int total = 0;
    boolean[] visited;
    int[] degree;
    
    Set<Integer> start = new HashSet<>();
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        findMax(edges);
        
        visited = new boolean[end + 1];
        degree = new int[end + 1];
        
        initGraph(edges);
        findCenter();
        
        total = graph.get(center).size(); // 전체 그래프의 갯수
        
        removeEdge();
        
        int barCnt = barCnt();
        int eightCnt = eightCnt();
        //for(int i = 1; i <= end; i++) System.out.println(i + " " + graph.get(i) + " " + degree[i]);
        
        
        answer[0] = center;
        answer[2] = barCnt;
        answer[3] = eightCnt;
        answer[1] = total - (barCnt + eightCnt);
        return answer;
    }
    
    public int barCnt() {
        int cnt = 0; 
        
        for(int i : start) {
            if (i == center) continue; // 생성된 정점은 스킵
            if (graph.get(i).isEmpty()) {
                cnt++;
                visited[i] = true;
            }
        }
        return cnt;
    }
    
    public int eightCnt() {
        int cnt = 0;
        for(int i : start) {
            if (visited[i]) continue;
            if (graph.get(i).size() >= 2 && degree[i] >= 2) {
                cnt++;
                visited[i] = true;
            }
        }
        return cnt; 
    }
    
    public void findMax(int[][] edges) {
        for(int[] edge : edges) end = Math.max(end, Math.max(edge[0], edge[1]));
    }
    
    public void initGraph(int[][] edges) {
        for(int i = 0; i <= end; i++) graph.add(new ArrayList<>());
        for(int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            degree[edge[1]]++;
            start.add(edge[0]);
            start.add(edge[1]);
        }
    }
    
    public void findCenter() {
        // 가운데 정점을 찾음
        for(int i = 1; i <= end; i++) {
            // 나가는 간선이 2개이거나 방문되지 않았은 경우
            if (degree[i] == 0 && graph.get(i).size() >= 2) {
                center = i;
                visited[i] = true;
                break;
            }
        }
    }
    
    public void removeEdge() {
        List<Integer> list = graph.get(center);
        for(Integer lis : list) degree[lis]--;
        graph.set(center, new ArrayList<>());
    }
}