import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m;
    static int[] dist;
    static int res = Integer.MAX_VALUE;
    static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i <= n; i++) {
            dist = new int[n+1];
            bfs(i);
        }

        System.out.println(num);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        int sum = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            sum += dist[cur];

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }

        if (sum < res) {
            res = sum;
            num = start;
        }
    }
}
