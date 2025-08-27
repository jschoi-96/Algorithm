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
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            if (dfs(i, visited, 0)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean dfs(int start, boolean[] visited, int cur) {
        if (cur == 4) return true;

        for(int next : graph.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                if (dfs(next, visited, cur + 1)) return true;
                visited[next] = false;
            }
        }
        return false;
    }

    public static boolean bfs(int start) {
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int dist = cur[1];
            System.out.println("start: " + start + " dist: " + dist);

            if (dist == 4) return true;

            for(int next : graph.get(x)) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next, dist + 1});
            }
        }

        return false;
    }
}
