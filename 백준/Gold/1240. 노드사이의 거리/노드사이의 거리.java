import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, cost));
            graph.get(v).add(new Node(u, cost));
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int dist = bfs(start, end);
            System.out.println(dist);
        }
    }

    public static int bfs(int start, int end) {
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;

            if (x == end) {
                return cur.dist;
            }

            for(Node next: graph.get(x)) {
                if (visited[next.x]) continue;
                visited[next.x] = true;
                int newDist = cur.dist + next.dist;
                q.add(new Node(next.x, newDist));
            }
        }
        return 0;
    }

    public static class Node {
        int x;
        int dist;
        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
}
