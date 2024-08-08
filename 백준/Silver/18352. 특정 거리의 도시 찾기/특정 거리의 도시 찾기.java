import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, x;
    static List<List<Node>> graph = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 도달 위치
        x = Integer.parseInt(st.nextToken()); // 시작

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, 1));
        }

        int [] dist = new int [n + 1];
        for(int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));
        dist[x] = 0; // 시작점
        pq.add(new Node(x,0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node nxt = graph.get(cur.idx).get(i);

                if (dist[nxt.idx] <= cur.cost + nxt.cost) continue;
                dist[nxt.idx] = cur.cost + nxt.cost;
                pq.add(new Node(nxt.idx, dist[nxt.idx]));

                if (dist[nxt.idx] == k) {
                    list.add(nxt.idx);
                }
            }
        }

        if (list.size() == 0) System.out.println(-1);
        else {
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}
