import java.util.*;
class Solution {
    static int [] dist;
    static final int INF = Integer.MAX_VALUE / 2;
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int n, int[][] road, int k) {
        int answer = 0;

        dist = new int[n+1];
        Arrays.fill(dist, INF);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int [] r : road) {
            graph.get(r[0]).add(new Node(r[1],r[2]));
            graph.get(r[1]).add(new Node(r[0],r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        dist[1] = 0;
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node nxt = graph.get(cur.idx).get(i);
                
                if (dist[nxt.idx] <= cur.cost + nxt.cost) continue;
                dist[nxt.idx] = cur.cost + nxt.cost;
                
                pq.add(new Node(nxt.idx, dist[nxt.idx]));
                // System.out.println(nxt.idx);
            }
        }
        

       
        for(int i = 1; i <= n; i++){
            if (dist[i] <= k) answer++;
        }
        return answer;
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