import java.util.*;
// 4번에서 출발해서 A와 B까지 도달하는 최단경로 노드를 찾는다.
// 
class Solution {
    static final int INF = Integer.MAX_VALUE / 2;
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int [] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }
        
        int [] dist = dijkstra(s, n);
        int [] a_dist = dijkstra(a, n);
        int [] b_dist = dijkstra(b, n);
        
        for(int i = 1; i <= n; i++){
            if (dist[i] + a_dist[i] + b_dist[i] < 0) continue;
            answer = Math.min(answer, dist[i] + a_dist[i] + b_dist[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((p,q) -> p.cost - q.cost);
        int [] dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node nxt = graph.get(cur.idx).get(i);
                if (dist[nxt.idx] <= cur.cost + nxt.cost) continue;
                dist[nxt.idx] = cur.cost + nxt.cost;
                pq.add(new Node(nxt.idx, dist[nxt.idx]));
            }
        }
        return dist;
    }
}

class Node { 
    int idx;
    int cost;
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}