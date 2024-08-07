import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int v, e, k;
    static List<List<Node>> graph = new ArrayList<>();
    static int [] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[v + 1]; // 최소 거리를 저장하는 배열
        for(int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(k,w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(k, 0)); // 시작점 노드를 집어넣는다
        dist[k] = 0; // 시작점의 거리는 0

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.idx] < cur.cost) continue;

            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node nxt = graph.get(cur.idx).get(i);

                if (dist[nxt.idx] <= cur.cost + nxt.cost) continue; // 현재 선택된 노드보다 주변 노드로 가는 비용이 더 크다면, 넘어간다.
                dist[nxt.idx] = cur.cost + nxt.cost; // 아닌 경우에, 현재 선택된 노드의 비용을 갱신해준다.
                pq.add(new Node(nxt.idx, dist[nxt.idx]));

            }
        }

        for(int i = 1; i <= v; i++){
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else System.out.println(dist[i]);
        }
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}