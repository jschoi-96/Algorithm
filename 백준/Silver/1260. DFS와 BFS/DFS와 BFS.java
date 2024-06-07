import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, m, v;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>()); // 점점의 개수만큼 초기화
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 노드의 인접 리스트를 정렬
        for(int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println(sb.toString().trim());

        sb = new StringBuilder();
        bfs(v);
        System.out.println(sb.toString().trim());

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for(int next : graph.get(node)) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for(int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}