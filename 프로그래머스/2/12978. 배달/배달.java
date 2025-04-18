import java.util.*;
class Solution {
    static int [] dist;
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 초기화
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int [] r : road) {
            // 양방향 이므로 두 정점을 넣어준다.
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 우선순위 큐는 더 낮은 경로를 탐색할 수 있도록 구현
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));
        
        // 시작점 1과 거리 0을 넣어주고, 거리배열도 0으로 초기화.
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.idx] < cur.cost) continue; // 만약에 현재 탐색하려는 거리값이 이미 최소라면 더이상 탐색 x
            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node nxt = graph.get(cur.idx).get(i);
                if (dist[nxt.idx] <= cur.cost + nxt.cost) continue; // 이미 최소라면 마찬가지로 넘어감
                dist[nxt.idx] = cur.cost + nxt.cost;
                pq.add(new Node(nxt.idx, dist[nxt.idx]));
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
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