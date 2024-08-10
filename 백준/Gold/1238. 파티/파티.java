import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;
    static int n, m, x;
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> graph2 = new ArrayList<>();
    static int [] dist;
    static int [] dist2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        dist2 = new int[n+1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
            dist[i] = INF;
            dist2[i] = INF;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph2.get(b).add(new Node(a, c));
        }

        dijkstra(graph, dist);
        dijkstra(graph2, dist2);

        int [] res = new int[n+1];
        for(int i = 1; i <= n; i++){
            res[i] = dist[i] + dist2[i];
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if (res[i] > max) max = res[i];
        }
        System.out.println(max);
    }

    public static void dijkstra(List<List<Node>> graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node nxt = graph.get(cur.idx).get(i);

                if (dist[nxt.idx] <= cur.cost + nxt.cost) continue;
                dist[nxt.idx] = cur.cost + nxt.cost;
                pq.add(new Node(nxt.idx, dist[nxt.idx]));
                // System.out.println(nxt.idx + " " + nxt.cost);
            }
        }
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
