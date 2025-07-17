import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[102];
    static PriorityQueue<Pos> pq = new PriorityQueue<>((a,b) -> {
        if (a.time != b.time) return a.time - b.time;
        else if (a.a != b.a) return a.a - b.a;
        return a.b - b.b;
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(0, 1);
        Pos p = pq.poll();
        System.out.println(p.a + " " + p.b + " " + p.time);
    }

    public static void dfs(int depth, int start) {
        if (depth == 2) {
            checkTime();
            return;
        }

        for(int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void checkTime() {
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if (visited[i]) {
                q.add(new int[]{i, 0});
                dist[i] = 0;
                list.add(i);
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int cur_dist = cur[1];

            for(int next : graph.get(x)) {
                if (dist[next] > cur_dist + 1) {
                    dist[next] = cur_dist + 1;
                    q.add(new int[]{next, cur_dist + 1});
                }
            }
        }

        int total = 0;
        for(int i = 1; i <= n; i++) {
            total += dist[i] * 2;
        }
        pq.add(new Pos(list.get(0), list.get(1), total));
    }

    public static class Pos {
        int a;
        int b;
        int time;
        public Pos(int a, int b, int time) {
            this.a = a;
            this.b = b;
            this.time = time;
        }
    }
}
