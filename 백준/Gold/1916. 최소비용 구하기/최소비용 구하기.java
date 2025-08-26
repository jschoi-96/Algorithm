import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        for(int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost); // 최소값
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.idx] < cur.cost) continue; // 현재 비용이 작다면 고려할 필요 x

            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);

                if (dist[next.idx] > cur.cost + next.cost) { 
                    dist[next.idx] = cur.cost + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        System.out.println(dist[end]);
    }

    public static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
