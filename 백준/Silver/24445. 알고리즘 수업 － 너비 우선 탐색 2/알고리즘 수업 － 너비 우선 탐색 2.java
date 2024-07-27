import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, cnt = 1;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int [] arr;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
            // System.out.println(graph.get(i));
        }

        bfs(r);
        for(int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            arr[cur] = cnt++;
            for(int next : graph.get(cur)) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }

        }
    }
}